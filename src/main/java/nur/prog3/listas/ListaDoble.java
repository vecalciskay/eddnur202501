package nur.prog3.listas;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

public class ListaDoble<E> implements  Iterable<E>{
    private static final Logger logger = LogManager.getRootLogger();
    protected Nodo<E> inicio;
    protected Nodo<E> fin;
    protected int tamano;
    public ListaDoble() {
        fin = null;
        inicio = null;
        tamano = 0;
    }

    public void insertar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setSiguiente(inicio);
        if (inicio != null) {
            inicio.setAnterior(nuevo);
        }
        inicio = nuevo;
        if (fin == null) {
            fin = nuevo;
        }
        tamano++;
    }

    public void adicionar(E o) {
        Nodo<E> nuevo = new Nodo<>(o);
        nuevo.setAnterior(fin);
        if (fin != null) {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        if (inicio == null) {
            inicio = nuevo;
        }
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
            if (inicio == null) {
                fin = null;
            } else {
                inicio.setAnterior(null);
            }
            tamano--;
            return;
        }

        if (posicion == tamano - 1) {
            logger.debug("Elimina el ultimo con nodo fin");
            fin = fin.getAnterior();
            if (fin == null) {
                inicio = null;
            } else {
                fin.setSiguiente(null);
            }
            tamano--;
            return;
        }

        Nodo<E> actual = inicio;
        int posActual = 0;
        while(posActual < (posicion-1)) {
            actual = actual.getSiguiente();
            posActual++;
        }
        Nodo<E> nuevoSiguiente = actual.getSiguiente().getSiguiente();
        actual.setSiguiente(nuevoSiguiente);
        nuevoSiguiente.setAnterior(actual);
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
        if (posicion < (tamano / 2)) {
            Nodo<E> actual = inicio;
            int posActual = 0;
            while (posActual < posicion && actual != null) {
                actual = actual.getSiguiente();
                posActual++;
            }

            return actual;
        }
        logger.debug("Posicion menor que la mitad, comienza del fin");
        Nodo<E> actual = fin;
        int posActual = tamano - 1;
        while (posActual > posicion && actual != null) {
            actual = actual.getAnterior();
            posActual--;
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


    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(inicio);
    }

    public Nodo<E> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<E> inicio) {
        this.inicio = inicio;
    }

    public Nodo<E> getFin() {
        return fin;
    }

    public void setFin(Nodo<E> fin) {
        this.fin = fin;
    }

    class Nodo<E> {
        private Nodo<E> siguiente;
        private Nodo<E> anterior;
        private E contenido;

        public Nodo(E o) {
            contenido = o;
            siguiente = null;
            anterior = null;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }

        public E getContenido() {
            return contenido;
        }

        public void setContenido(E contenido) {
            this.contenido = contenido;
        }

        @Override
        public String toString() {
            return contenido.toString() + " --> ";
        }
    }

    class IteradorLista<E> implements Iterator<E> {
        private Nodo<E> actual;

        public IteradorLista(Nodo<E> raiz) {
            actual = raiz;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            // Retorna lo que tiene actual y avanza uno
            E o = actual.getContenido();
            actual = actual.getSiguiente();
            return o;
        }
    }
}
