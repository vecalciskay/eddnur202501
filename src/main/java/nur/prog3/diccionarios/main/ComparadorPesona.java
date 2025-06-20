package nur.prog3.diccionarios.main;

import nur.prog3.diccionarios.Comparador;

public class ComparadorPesona implements Comparador<Persona> {

    @Override
    public boolean equals(Persona key1, Persona key2) {
        return key1.getId().equals(key2.getId());
    }

    @Override
    public int hashCode(Persona key) {
        return key.getId().hashCode();
    }
}
