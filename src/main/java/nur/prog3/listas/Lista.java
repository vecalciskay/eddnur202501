package nur.prog3.listas;

public class Lista<E> {
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

    public void eliminar(int posicion) {
        tamano--;
    }
    
    public void intercambiar(int posicion1, int posicion2) {

    }

    public int getTamano() {
        return tamano;
    }

    public E get(int posicion) {

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
