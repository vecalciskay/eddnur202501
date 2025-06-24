package nur.prog3.grafos;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        grafo.insertarConexion("A","C");

        System.out.println(grafo);
    }
}
