package nur.prog3.listas;

import java.util.Comparator;

public class TestLista {
    public static void main(String[] args) {
        Lista<String> lista = new Lista<>();
        lista.insertar("Paco");
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Paco");

        System.out.println(lista);

        Comparator<String> comparador = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.contains(o2) ? 0 : o1.compareTo(o2);
            }
        };

        String criterio = "aco";
        String paco = lista.buscar(criterio, comparador);
        if (paco != null) {
            System.out.println("Encontrado: " + paco);
        } else {
            System.out.println("No encontrado");
        }



    }
}
