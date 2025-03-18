package nur.prog3.ordenarlistas;

public class OrdenarQuicksort {

    public static void main(String[] args) {
        int[] arreglo = OrdenarUtiles.nuevoArregloConNumerosAlAzar(50000);
        //System.out.println(OrdenarUtiles.toStringArray(arreglo));

        long start = System.currentTimeMillis();
        ordenarArreglo(arreglo);
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        System.out.println("Arreglo ordenado en " + elapsed + "ms");
        //System.out.println(OrdenarUtiles.toStringArray(arreglo));

        start = System.currentTimeMillis();
        ordenarArreglo(arreglo);
        end = System.currentTimeMillis();
        elapsed = end - start;
        System.out.println("Arreglo ordenado por segunda vez en " + elapsed + "ms");

    }

    public static void ordenarArreglo(int[] arreglo) {
        sortHelper(arreglo, 0, arreglo.length - 1);
    }

    // 5   7   3   5   4   8   9   5   6   1   5
    // Pivot = 5
    // Menores o iguales = 3   5   4   5   1   5
    // Mayores = 7   8   9   6
    // 3   5   4   5   1   5   5   7   8   9   6

    private static void sortHelper(int[] array, int p, int r) {
        if (p < r) {
            int q = doHoarePartitioning(array, p, r);
            sortHelper(array, p, q);
            sortHelper(array, q + 1, r);
        }
    }

    private static int doHoarePartitioning(int[] array, int p, int r) {
        int randomIndex = p + (int)(Math.random() * (r - p + 1));
        swap(array, p, randomIndex);  // Randomize pivot
        int pivot = array[p];
        int i = p - 1;
        int j = r + 1;

        while (true) {
            do { i++; } while (array[i] < pivot);
            do { j--; } while (array[j] > pivot);
            if (i < j) swap(array, i, j);
            else return j;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
