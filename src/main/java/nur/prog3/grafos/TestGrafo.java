package nur.prog3.grafos;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        grafo.insertarConexion("A","C");
        grafo.insertarConexion("A","B", 2);
        grafo.insertarConexion("A","D");

        grafo.insertarConexion("C","E", 3);
        grafo.insertarConexion("E","H", 2);
        grafo.insertarConexion("E","G");
        grafo.insertarConexion("H","G", 4);
        grafo.insertarConexion("E","A",2);
        grafo.insertarConexion("D","I");
        grafo.insertarConexion("I","J", 2);
        grafo.insertarConexion("B","J",1);
        grafo.insertarConexion("J","E",1);
        grafo.insertarConexion("G","D",2);

        System.out.println(grafo);
    }
}
