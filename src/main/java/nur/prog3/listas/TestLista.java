package nur.prog3.listas;

public class TestLista {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        System.out.println(lista);
    }
}
