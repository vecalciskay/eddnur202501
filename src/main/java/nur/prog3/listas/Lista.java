package nur.prog3.listas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lista<E> {
    private static final Logger logger = LogManager.getRootLogger();
    private Nodo<E> inicio;
    private int tamano;
    public Lista() {

        inicio = null;
        tamano = 0;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
        tamano++;
    }

    /**
     * f -> b -> t -> a -> p ->
     * eliminar(2): elimina la posicion 2, es decir el elemento 't'
     * significa que 'b' apunta a 'a'
     * Caso especial, si posicion es 0, entonces se cambia el inicio
     * al siguiente de inicio.
     * @param posicion numero entre 0 y tamano - 1
     */
    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= tamano) {
            String msg = "La posicion " + posicion + " esta fuera de la lista";
            logger.error(msg);
            throw new IndexOutOfBoundsException(msg);
        }

        if (posicion == 0) {
            inicio = inicio.getSiguiente();
            tamano--;
            return;
        }

        Nodo<E> actual = inicio;
        int posActual = 0;
        while(posActual < (posicion-1)) {
            actual = actual.getSiguiente();
            posActual++;
        }
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        tamano--;
    }

    public void intercambiar(int posicion1, int posicion2) {
        String msg;
        if (posicion1 < 0 || posicion1 >= tamano) {
            msg = "La posicion1 " + posicion1 + " esta fuera de la lista";
            logger.error(msg);
            throw new IndexOutOfBoundsException(msg);
        }

        if (posicion2 < 0 || posicion2 >= tamano) {
            msg = "La posicion2 " + posicion2 + " esta fuera de la lista";
            logger.error(msg);
            throw new IndexOutOfBoundsException(msg);
        }

        Nodo<E> nodoPosicion1 = getNodo(posicion1);
        Nodo<E> nodoPosicion2 = getNodo(posicion2);

        E contenido1 = nodoPosicion1.getContenido();
        nodoPosicion1.setContenido(nodoPosicion2.getContenido());
        nodoPosicion2.setContenido(contenido1);
    }

    private Nodo<E> getNodo(int posicion) {
        if (posicion < 0 || posicion >= tamano) {
            logger.error("La posicion " + posicion + " esta fuera de la lista");
            return null;
        }
        Nodo<E> actual = inicio;
        int posActual = 0;
        while(posActual < posicion && actual != null) {
            actual = actual.getSiguiente();
            posActual++;
        }

        return actual;
    }

    public int getTamano() {
        return tamano;
    }

    public E get(int posicion) {
        Nodo<E> actual = getNodo(posicion);
        if (actual != null)
            return actual.getContenido();
        return null;
    }

    @Override
    public String toString() {
        if (inicio == null)
            return "[VACIA]";

        StringBuilder resultado = new StringBuilder();
        Nodo<E> actual = inicio;
        while(actual != null) {
            resultado.append(actual.toString());
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    static class Nodo<E> {
        private E contenido;
        private Nodo<E> siguiente;

        public Nodo(E o) {
            contenido = o;
            siguiente = null;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E o) {
            this.contenido = o;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return contenido.toString() + " --> ";
        }
    }
}
