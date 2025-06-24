package nur.prog3.basededatos.dao;

import nur.prog3.basededatos.bd.ConexionMySql;
import nur.prog3.basededatos.model.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoMySql implements PersonaDao {

    @Override
    public int insertar(Persona persona) {
        ConexionMySql conexion = ConexionMySql.getInstance();

        String sql = "INSERT INTO persona (nombreCompleto, edad) VALUES (?,?)";

        int insertedId = 0;

        try  (Connection conn = conexion.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, persona.getNombreCompleto());
            statement.setInt(2, persona.getEdad());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No se pudo insertar persona");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    insertedId = generatedKeys.getInt(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conexion.closeConnection();
        }
        return insertedId;
    }

    @Override
    public List<Persona> getLista() {
        ConexionMySql conexion = ConexionMySql.getInstance();
        List<Persona> personas = new ArrayList<>();

        String sql = "SELECT personaId, nombreCompleto, edad FROM persona";
        try  (Connection conn = conexion.getConnection();
              PreparedStatement statement = conn.prepareStatement(sql)) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {

                    int id = resultSet.getInt("personaId");
                    String nombreCompleto = resultSet.getString("nombreCompleto");
                    int edad = resultSet.getInt("edad");


                    Persona persona = new Persona(id, nombreCompleto, edad);
                    personas.add(persona);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            conexion.closeConnection();
        }
        return personas;
    }
}
