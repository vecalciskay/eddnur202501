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
        quickSort(arreglo, 0, arreglo.length - 1);
    }

    // 5   7   3   5   4   8   9   5   6   1   5
    // Pivot = 5
    // Menores o iguales = 3   5   4   5   1   5
    // Mayores = 7   8   9   6
    // 3   5   4   5   1   5   5   7   8   9   6
// method to find the partition position
    static int partition(int array[], int low, int high) {

        // choose the rightmost element as pivot
        int pivot = array[high];

        // pointer for greater element
        int i = (low - 1);

        // traverse through all elements
        // compare each element with pivot
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {

                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }

        }

        // swap the pivot element with the greater element specified by i
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // return the position from where partition is done
        return (i + 1);
    }

    static void quickSort(int array[], int low, int high) {
        if (low < high) {

            // find pivot element such that
            // elements smaller than pivot are on the left
            // elements greater than pivot are on the right
            int pi = partition(array, low, high);

            // recursive call on the left of pivot
            quickSort(array, low, pi - 1);

            // recursive call on the right of pivot
            quickSort(array, pi + 1, high);
        }
    }
}
