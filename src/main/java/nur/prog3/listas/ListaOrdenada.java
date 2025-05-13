package nur.prog3.listas;

public class ListaOrdenada<E> extends Lista<E> {
    @Override
    public void ordenar() {
        return;
    }

    @Override
    public void insertar(E o) {
        if (tamano == 0 ||
                !(o instanceof Comparable)) {
            super.insertar(o);
            return;
        }
        Nodo<E> actual = inicio;
        Comparable objetoComparable = (Comparable)o;
        if (objetoComparable.compareTo(actual.getContenido()) <= 0) {
            super.insertar(o);
            return;
        }

        // Aqui el objeto va en algun lugar despues del primer elemento
        //
        //           [Nodo con objeto o]
        //
        //      [actual]  ------------>  [siguiente de actual]
        //
        // Si nodo con objeto va antes de siguiente de actual
        //
        //  [actual]  ----> [Nodo con objeto o] ---->  [siguiente de actual]
        //
        while(actual.getSiguiente() != null) {
            E siguienteDeActual = actual.getSiguiente().getContenido();

            if (objetoComparable.compareTo(siguienteDeActual) <= 0) {
                Nodo<E> nuevo = new Nodo(o);
                nuevo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevo);
                tamano++;
                return;
            }

            actual = actual.getSiguiente();
        }

        // Pongo de ultimo
        Nodo<E> nuevo = new Nodo(o);
        actual.setSiguiente(nuevo);
        tamano++;
    }
}
