package nur.prog3.listas;

public class ListaSimple {
    private Nodo inicio;

    public ListaSimple() {
        inicio = null;
    }

    public void insertar(Object o) {
        Nodo nuevo = new Nodo(o);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    @Override
    public String toString() {
        if (inicio == null) {
            return "[VACIA]";
        }
        StringBuilder resultado = new StringBuilder();
        Nodo actual = inicio;
        while(actual != null) {
            resultado.append(actual.toString());
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }
}
