package nur.prog3.listas;

import java.util.Comparator;

public class ListaOrdenada<E> extends Lista<E> {

    private Comparator<E> comparator;
    @Override
    public void ordenar() {
        return;
    }

    @Override
    public E buscar(E o) {
        return busquedaDicotomica(0,tamano - 1, o);
    }

    private E busquedaDicotomica(int primero, int ultimo, E o) {
        if (primero == ultimo)
            return null;

        if (ultimo - primero == 1) {
            Comparable comparablePrimero = (Comparable) get(primero);
            if (comparablePrimero.compareTo(o) == 0)
                return get(primero);
            Comparable comparableUltimo = (Comparable) get(ultimo);
            if (comparableUltimo.compareTo(o) == 0)
                return get(ultimo);
            return null;
        }


        int mitad = (ultimo + primero) / 2;
        Comparable objMitad = (Comparable)get(mitad);
        if (objMitad.compareTo(o) < 0) {
            return busquedaDicotomica(mitad, ultimo, o);
        } else if(objMitad.compareTo(o) > 0) {
            return busquedaDicotomica(primero, mitad, o);
        } else {
            return get(mitad);
        }
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
