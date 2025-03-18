package nur.prog3.ordenarlistas;

public class OrdenarUtiles {

    public static final int MAX_NUMERO = 999999;

    public static int[] nuevoArregloConNumerosAlAzar(int tamano) {
        if (tamano <= 0)
            throw new IllegalArgumentException("Tamano debe ser mayor a 0");

        int[] resultado = new int[tamano];

        for (int i = 0; i < tamano; i++) {
            resultado[i] = (int)(Math.random() * MAX_NUMERO);
        }
        return resultado;
    }

    public static String toStringArray(int[] arreglo) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < arreglo.length; i++) {
            if (i > 0 && i % 15 == 0)
                resultado.append("\n");
            String numero = String.valueOf(arreglo[i]);
            numero = padLeft(numero,6);
            resultado.append(numero).append(" ");
        }
        return resultado.toString();
    }

    public static String padLeft(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append(' ');
        }
        sb.append(inputString);

        return sb.toString();
    }
}
