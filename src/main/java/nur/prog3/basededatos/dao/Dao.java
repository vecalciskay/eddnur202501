package nur.prog3.basededatos.dao;

import java.util.List;

public interface Dao<T> {
    int insertar(T o);

    List<T> getLista();
}
