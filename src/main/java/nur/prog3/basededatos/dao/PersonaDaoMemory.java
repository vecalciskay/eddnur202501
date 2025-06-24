package nur.prog3.basededatos.dao;

import nur.prog3.basededatos.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class PersonaDaoMemory implements PersonaDao {

    private List<Persona> personas;
    private int idActual;

    public PersonaDaoMemory() {
        personas = new ArrayList<Persona>();
        idActual = 1;
    }

    @Override
    public int insertar(Persona persona) {
        persona.setId(idActual);
        personas.add(persona);

        idActual++;

        return persona.getId();
    }

    @Override
    public List<Persona> getLista() {
        return personas;
    }
}
