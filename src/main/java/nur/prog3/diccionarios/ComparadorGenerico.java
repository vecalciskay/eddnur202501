package nur.prog3.diccionarios;

public class ComparadorGenerico<TKEY> implements Comparador<TKEY> {

    @Override
    public boolean equals(TKEY key1, TKEY key2) {
        return key1.equals(key2);
    }

    @Override
    public int hashCode(TKEY key) {
        return key.hashCode();
    }
}
