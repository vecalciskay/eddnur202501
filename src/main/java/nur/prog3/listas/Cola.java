package nur.prog3.listas;

public class Cola<E> extends ListaDoble<E> {
    public Cola() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }

    public E pull() {
        E o = get(tamano - 1);
        eliminar(tamano-1);
        return o;
    }

    public boolean isEmpty() {
        return tamano == 0;
    }
}
