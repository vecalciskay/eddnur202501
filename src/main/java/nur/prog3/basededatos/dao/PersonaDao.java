package nur.prog3.basededatos.dao;

import nur.prog3.basededatos.model.Persona;

import java.util.List;

public interface PersonaDao {

    int insertar(Persona persona);

    List<Persona> getListaPersonas();
}
