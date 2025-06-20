package nur.prog3.basededatos.factory;

import nur.prog3.basededatos.dao.PersonaDao;
import nur.prog3.basededatos.dao.PersonaDaoMemory;

public class FactoryDaoMemory extends FactoryDao {
    @Override
    public PersonaDao getPersonaDao() {
        return new PersonaDaoMemory();
    }
}
