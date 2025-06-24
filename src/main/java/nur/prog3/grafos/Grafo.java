package nur.prog3.grafos;

import nur.prog3.diccionarios.Diccionario;
import nur.prog3.diccionarios.DiccionarioLista;

import java.util.List;

public class Grafo<E> {
    private Diccionario<String,NodoGrafo<E>> nodos;

    public Grafo() {
        nodos = new DiccionarioLista<>();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<String> llaves = nodos.llaves();
        if (llaves.isEmpty())
            return "[GRAFO VACIO]";
        for(String id : llaves) {
            result.append(nodos.buscar(id).toString()).append("\n");
        }
        return result.toString();
    }

    public void insertarConexion(E n1, E n2) {
        NodoGrafo<E> ng1 = null;
        NodoGrafo<E> ng2 = null;
        if (!nodos.contiene(n1.toString())) {
            ng1 = new NodoGrafo<>(n1.toString(), n1);
            nodos.insertar(ng1.getId(), ng1);
        }
        if (!nodos.contiene(n2.toString())) {
            ng2 = new NodoGrafo<>(n2.toString(), n2);
            nodos.insertar(ng2.getId(), ng2);
        }

        Arista<E> conexion = new Arista<>(ng2, 1);
        ng1.getAdyacentes().insertar(conexion);
    }
}
