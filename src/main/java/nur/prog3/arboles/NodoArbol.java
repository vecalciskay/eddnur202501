package nur.prog3.arboles;

import nur.prog3.listas.Lista;

public class NodoArbol<E extends Identificable> {

    private E valor;
    private Lista<NodoArbol<E>> hijos;
    private NodoArbol<E> padre;

    private int tamano;

    public NodoArbol(E valor) {
        this.valor = valor;
        this.hijos = new Lista<>();
        this.tamano = 0; // Initialize tamano if needed
    }

    public E getValor() {
        return valor;
    }

    public Lista<NodoArbol<E>> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoArbol<E> hijo) {
        this.hijos.insertar(hijo);
        hijo.setPadre(this);
    }

    @Override
    public String toString() {
        return this.getValor().toString();
    }

    public NodoArbol<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol<E> padre) {
        this.padre = padre;
    }


    public int getTamano() {
        return tamano;
    }
}
