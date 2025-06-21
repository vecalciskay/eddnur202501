package nur.prog3.basededatos.service;

import nur.prog3.basededatos.dao.PersonaDao;
import nur.prog3.basededatos.model.Persona;

import java.util.List;

public class PersonaService {

    private PersonaDao personaDao;

    public PersonaService(PersonaDao personaDao) {
        this.personaDao = personaDao;
    }

    public void insertarPersona(String nombre, int edad) {

        if(nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser vacio");
        }

        if(edad < 0) {
            throw new IllegalArgumentException("El edad no puede ser negativo");
        }

        Persona persona = new Persona(nombre, edad);

        personaDao.insertar(persona);

    }

    public List<Persona> obtenerPersonas() {
        return personaDao.getListaPersonas();
    }
}
