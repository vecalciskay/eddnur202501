package nur.prog3.listas;

public class ListaSimple {
    private NodoSimple inicio;

    public ListaSimple() {
        inicio = null;
    }

    public void insertar(Object o) {
        NodoSimple nuevo = new NodoSimple(o);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }

    @Override
    public String toString() {
        if (inicio == null) {
            return "[VACIA]";
        }
        StringBuilder resultado = new StringBuilder();
        NodoSimple actual = inicio;
        while(actual != null) {
            resultado.append(actual.toString());
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }
}
