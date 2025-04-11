package nur.prog3.estaticas;

public class EstructuraEstatica {
    public static void main(String[] args) {
        int[] a = { 4, 7, 2, 8, 9};

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // Como hacemos para eliminar el 8 que esta en la 4ta posicion
        // a sea { 4, 7, 2, 9 }
        int[] b = new int[a.length - 1];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i != 3) {
                b[j] = a[i];
                j++;
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
