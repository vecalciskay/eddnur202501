package nur.prog3.compleidad;

public class ComplejidadBasica {
    public static void main(String[] args) {
        System.out.println("La suma de 100 primeros numeros = "+
                ComplejidadBasica.suma(100));
    }

    public static int suma(int unvalor) {
        int resultado = 0;
        for(int i=0;i<=unvalor;i++) {
            resultado = resultado + i;
        }
        return resultado;
    }
}
