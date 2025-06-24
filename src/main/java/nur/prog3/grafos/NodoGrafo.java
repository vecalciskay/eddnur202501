package nur.prog3.grafos;

import nur.prog3.listas.Lista;

public class NodoGrafo<E> {
    private Lista<Arista<E>> adyacentes;
    private String id;
    private E contenido;

    public NodoGrafo(String id, E o){
        this.id = id;
        contenido = o;
        adyacentes = new Lista<>();
    }

    public Lista<Arista<E>> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Lista<Arista<E>> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Arista<E> a : adyacentes) {
            result.append(id).append(a).append("\n");
        }
        return result.toString();
    }
}
