package nur.prog3.basededatos.factory;

import nur.prog3.basededatos.bd.ConfigLoader;
import nur.prog3.basededatos.dao.PersonaDao;

public abstract class FactoryDao {

    public abstract PersonaDao getPersonaDao();

    private static FactoryDao instance;

    public static FactoryDao getFactory(){
        if(instance != null){
            return instance;
        }

        String db = ConfigLoader.getProperty("db.type");

        if(db == null){
            return null;
        }

        if(db.equalsIgnoreCase("mysql")){
            instance = new FactoryDaoMySql();
        }else if(db.equalsIgnoreCase("file")){
            instance = new FactoryDaoFile();
        }else{
            instance = new FactoryDaoMemory();
        }
        return instance;
    }


}
