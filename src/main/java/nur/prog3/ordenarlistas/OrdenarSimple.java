package nur.prog3.ordenarlistas;

public class OrdenarSimple {
    public static void main(String[] args) {
        int[] arreglo = OrdenarUtiles.nuevoArregloConNumerosAlAzar(50000);
        //System.out.println(OrdenarUtiles.toStringArray(arreglo));

        long start = System.currentTimeMillis();
        ordenarArreglo(arreglo);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Arreglo ordenado en " + elapsed + "ms");


        start = System.currentTimeMillis();
        ordenarArreglo(arreglo);
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("Arreglo ordenado por segunda vez en " + elapsed + "ms");

        //System.out.println(OrdenarUtiles.toStringArray(arreglo));
    }

    public static void ordenarArreglo(int[] arreglo) {
        // 5   8   2   1   7   9   3
        // 5   2   8   1   7   9   3
        // 5   2   1   8   7   9   3
        // 5   2   1   7   8   9   3
        // 5   2   1   7   8   3   9

        // 5   2   1   7   8   3   9
        // 2   5   1   7   8   3   9
        // 2   1   5   7   8   3   9
        // 2   1   5   7   3   8   9

        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 1; j < arreglo.length; j++) {
                if (arreglo[j-1] <= arreglo[j])
                    continue;
                int aux = arreglo[j-1];
                arreglo[j-1] = arreglo[j];
                arreglo[j] = aux;
            }
        }
    }
}
