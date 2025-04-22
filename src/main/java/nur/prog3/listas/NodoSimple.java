package nur.prog3.listas;

public class NodoSimple {
    private Object contenido;
    private NodoSimple siguiente;

    public NodoSimple(Object o) {
        contenido = o;
        siguiente = null;
    }

    public Object getContenido() {
        return contenido;
    }

    public void setContenido(Object contenido) {
        this.contenido = contenido;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return contenido.toString() + " --> ";
    }
}
