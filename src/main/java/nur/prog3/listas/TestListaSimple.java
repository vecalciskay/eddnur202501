package nur.prog3.listas;

public class TestListaSimple {
    public static void main(String[] args) {
        ListaSimple a = new ListaSimple();
        a.insertar("Hugo");
        a.insertar("Paco");
        a.insertar("Luis");
        a.insertar("Daisy");

        System.out.println(a);
    }
}
