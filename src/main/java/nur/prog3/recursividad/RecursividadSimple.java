package nur.prog3.recursividad;

public class RecursividadSimple {
    public static void main(String[] args) {
        RecursividadSimple obj = new RecursividadSimple();

        int suma = obj.sumaRecursiva(15050);
        System.out.println("Suma de 5 primeros numeros: " + suma);
    }

    /**
     * SUmatoria de los primeros n numeros naturales
     * @param n Numero mayor que 0
     * @return 1+ 2 + 3 + .. + n
     */
    public int sumaRecursiva(int n) {
        if (n == 1)
            return n;
        return n + sumaRecursiva(n-1);
    }
}
