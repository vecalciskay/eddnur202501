package nur.prog3.diccionarios;

import java.util.List;

public abstract class Diccionario<TKEY, TVALUE> {

    protected Comparador<TKEY> comparador;
    protected int size;

    public Diccionario() {
        this.comparador = new ComparadorGenerico<>();
        this.size = 0;
    }

    public Diccionario(Comparador<TKEY> comparador) {
        if(comparador == null) throw new IllegalArgumentException("Comparador no puede ser nulo");
        this.comparador = comparador;
        this.size = 0;
    }

    public abstract void insertar(TKEY key, TVALUE value);

    public abstract TVALUE buscar(TKEY key);

    public abstract TVALUE eliminar(TKEY key);

    public abstract boolean contiene(TKEY key);

    public abstract List<TKEY> llaves();

    public abstract List<TVALUE> valores();

    public int size(){
        return size;
    }

    public boolean esVacio(){
        return size == 0;
    }

}

