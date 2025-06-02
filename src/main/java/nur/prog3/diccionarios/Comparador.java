package nur.prog3.diccionarios;

public interface Comparador<TKEY> {
    boolean equals(TKEY key1, TKEY key2);

    int hashCode(TKEY key);
}

