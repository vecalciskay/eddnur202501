package nur.prog3.basededatos.factory;

import nur.prog3.basededatos.dao.PersonaDao;
import nur.prog3.basededatos.dao.PersonaDaoFile;

public class FactoryDaoFile extends FactoryDao {
    @Override
    public PersonaDao getPersonaDao() {
        return new PersonaDaoFile();
    }
}
