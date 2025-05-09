package nur.prog3.listas;

public class Pila<E> extends Lista<E> {
    public Pila() {
        super();
    }

    public void push(E o) {
        insertar(o);
    }

    public E pop() {
        E o = get(0);
        eliminar(0);
        return o;
    }

    public boolean isEmpty() {
        return tamano == 0;
    }
}
