package nur.prog3.basededatos.dao;

import nur.prog3.basededatos.model.Persona;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoFile implements PersonaDao {

    private int idActual;
    private String fileName;

    public PersonaDaoFile() {
        this.fileName = "D:\\NUR\\pro3\\personas.json";
        idActual = 1;
    }

    @Override
    public int insertar(Persona persona) {

        List<Persona> personas = getLista();
        persona.setId(idActual);
        personas.add(persona);

        idActual++;

        JSONArray jsonArray = new JSONArray(personas);
        String jsonString = jsonArray.toString();


        Path filePath = Paths.get(fileName);

        try {
            // Write the string to the file, creating it if it doesn't exist
            Files.write(filePath, jsonString.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        return persona.getId();

    }

    @Override
    public List<Persona> getLista() {
        List<Persona> personas = new ArrayList<>();
        Path ruta = Paths.get(fileName);
        if(!Files.exists(ruta)) {
            return personas;
        }
        try {
            List<String> contenido = Files.readAllLines(ruta);
            StringBuilder json = new StringBuilder();
            for (String s : contenido) {
                json.append(s);
            }

            JSONArray jsonArray = new JSONArray(json.toString());

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String nombre = jsonObject.getString("nombreCompleto");
                int edad = jsonObject.getInt("edad");
                int id = jsonObject.getInt("id");

                Persona persona = new Persona(id, nombre, edad);
                personas.add(persona);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return personas;
    }
}
