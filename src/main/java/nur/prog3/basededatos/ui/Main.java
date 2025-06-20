package nur.prog3.basededatos.ui;

import nur.prog3.basededatos.dao.PersonaDao;
import nur.prog3.basededatos.dao.PersonaDaoFile;
import nur.prog3.basededatos.dao.PersonaDaoMemory;
import nur.prog3.basededatos.dao.PersonaDaoMySql;
import nur.prog3.basededatos.factory.FactoryDao;
import nur.prog3.basededatos.model.Persona;
import nur.prog3.basededatos.service.PersonaService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PersonaDao personaDao = FactoryDao.getFactory().getPersonaDao();
        PersonaService service = new PersonaService(personaDao);

//        service.insertarPersona("Juan Perez", 18);
//
//        service.insertarPersona("Carlos Montero", 23);
//
//        service.insertarPersona("Maria Barboza", 42);
//        service.insertarPersona("Alexander Mojica", 50);

        List<Persona> personas = service.obtenerPersonas();
        System.out.println("Personas:");
        for (Persona persona : personas) {
            System.out.println("-" + persona);
        }
    }
}
