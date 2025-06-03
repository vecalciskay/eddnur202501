package nur.prog3.diccionarios;


import java.util.List;

public class DiccionarioLista<TKEY, VALUE> extends Diccionario<TKEY, VALUE>{

    private Nodo<TKEY, VALUE> inicio;
    private Nodo<TKEY, VALUE> fin;

    public DiccionarioLista() {
        super();
        this.inicio = null;
        this.fin = null;
    }

    public DiccionarioLista(Comparador<TKEY> comparador) {
        super(comparador);
        this.inicio = null;
        this.fin = null;
    }

    @Override
    public void insertar(TKEY key, VALUE value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("La clave y el valor no pueden ser nulos");
        }

        Nodo<TKEY, VALUE> nodoExistente = buscarNodo(key);
        if (nodoExistente != null) {
            nodoExistente.setValor(value);
            return; // Si ya existe, actualizamos el valor y salimos
        }

        Nodo<TKEY, VALUE> nuevoNodo = new Nodo<>(key, value);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(fin);
            fin = nuevoNodo;
        }
        size++;
    }

    @Override
    public VALUE buscar(TKEY key) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        Nodo<TKEY, VALUE> nodo = buscarNodo(key);
        return (nodo != null) ? nodo.getValor() : null;
    }

    @Override
    public VALUE eliminar(TKEY key) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        Nodo<TKEY, VALUE> nodo = buscarNodo(key);
        if(nodo == null) {
            return null; // Si no existe, retornamos null
        }
        VALUE valor = nodo.getValor();
        if(nodo == inicio && nodo == fin) { // Si es el único nodo
            inicio = null;
            fin = null;
        } else if(nodo == inicio) { //Si es el primer nodo
            inicio = nodo.getSiguiente();
            inicio.setAnterior(null);
        } else if(nodo == fin) { // Si es el último nodo
            fin = nodo.getAnterior();
            fin.setSiguiente(null);
        } else { // Si es un nodo intermedio
            Nodo<TKEY, VALUE> anterior = nodo.getAnterior();
            Nodo<TKEY, VALUE> siguiente = nodo.getSiguiente();
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
        }

        size--;

        return valor;
    }

    @Override
    public boolean contiene(TKEY key) {
        if (key == null) {
            throw new IllegalArgumentException("La clave no puede ser nula");
        }
        Nodo<TKEY, VALUE> nodo = buscarNodo(key);
        return nodo != null; // Si el nodo no existe, la clave no está presente
    }

    @Override
    public List<TKEY> llaves() {
        if (inicio == null) {
            return List.of(); // Retorna una lista vacía si no hay nodos
        }
        List<TKEY> llaves = new java.util.ArrayList<>();
        Nodo<TKEY, VALUE> actual = inicio;
        while (actual != null) {
            llaves.add(actual.getLlave());
            actual = actual.getSiguiente();
        }
        return llaves;
    }

    @Override
    public List<VALUE> valores() {
        if (inicio == null) {
            return List.of(); // Retorna una lista vacía si no hay nodos
        }
        List<VALUE> valores = new java.util.ArrayList<>();
        Nodo<TKEY, VALUE> actual = inicio;
        while (actual != null) {
            valores.add(actual.getValor());
            actual = actual.getSiguiente();
        }
        return valores;
    }

    private Nodo<TKEY, VALUE> buscarNodo(TKEY key){
        Nodo<TKEY, VALUE> actual = inicio;
        while (actual != null) {
            if (comparador.equals(actual.getLlave(), key)) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo<TKEY, VALUE> actual = inicio;
        String separator = "";
        while (actual != null) {
            sb.append(separator).append(actual);
            actual = actual.getSiguiente();
            separator = ", ";
        }
        sb.append(']');
        return sb.toString();
    }

}
