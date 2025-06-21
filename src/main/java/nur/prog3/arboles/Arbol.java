package nur.prog3.arboles;

import nur.prog3.diccionarios.Diccionario;
import nur.prog3.diccionarios.DiccionarioTablaHash;
import nur.prog3.listas.Lista;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Arbol<E extends Identificable> {

    private NodoArbol<E> raiz;
    private Diccionario<String, NodoArbol<E>> nodos;

    public Arbol() {
        nodos = new DiccionarioTablaHash<>();
    }

    public void insertar(E valor) {
        insertar(valor, null);
    }

    public void insertar(E valor, String idPadre) {
        if(raiz == null) {
            raiz = new NodoArbol<>(valor);
            nodos.insertar(valor.getId(), raiz);
            return;
        }

        NodoArbol<E> nuevoNodo = new NodoArbol<>(valor);
        NodoArbol<E> padre = nodos.buscar(idPadre);
        padre.agregarHijo(nuevoNodo);

        nodos.insertar(valor.getId(), nuevoNodo);
    }

    public String recorrerPostOrden() {
        return recorrerPostOrden(raiz);
    }

    private String recorrerPostOrden(NodoArbol<E> raizSubArbol) {
        if (raizSubArbol == null) {
            return "[ARBOL VACIO]";
        }
        String separadorPrincipal = "";
        StringBuilder sb = new StringBuilder();
        if (raizSubArbol.getHijos().getTamano() > 0) {
            String separador = "";
            for (NodoArbol<E> hijo : raizSubArbol.getHijos()) {
                sb.append(separador).append(recorrerPostOrden(hijo));
                separador = ",";
            }
            separadorPrincipal = separador;
        }
        sb.append(separadorPrincipal).append(raizSubArbol.getValor().getId());
        return sb.toString();
    }

    public Lista<E> recorridoPorNiveles(){
        Queue<NodoArbol<E>> fila = new LinkedList<>();
        fila.add(raiz);

        Lista<E> lista = new Lista<>();
        while(!fila.isEmpty()) {
            NodoArbol<E> nodoAVisitar = fila.poll();

            lista.insertar(nodoAVisitar.getValor());

            for(NodoArbol<E> hijo : nodoAVisitar.getHijos()) {
                fila.add(hijo);
            }
        }
        return lista;
    }

    public Lista<E> recorridoEnProfundidad(){
        Stack<NodoArbol<E>> fila = new Stack<>();
        fila.push(raiz);
        Lista<E> lista = new Lista<>();
        while(!fila.isEmpty()) {
            NodoArbol<E> nodoAVisitar = fila.pop();
            lista.insertar(nodoAVisitar.getValor());

            for(NodoArbol<E> hijo : nodoAVisitar.getHijos()) {
                fila.add(hijo);
            }
        }
        return lista;
    }
    public NodoArbol<E> getRaiz() {
        return raiz;
    }



}
