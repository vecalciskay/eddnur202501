package nur.prog3.diccionarios.main;


import nur.prog3.diccionarios.Diccionario;
import nur.prog3.diccionarios.DiccionarioTablaHash;

public class MainDiccionarTablaHash {

    public static void main(String[] args) {

        // Aquí puedes probar tu implementación de Diccionario y Comparador
        // Por ejemplo, crear un Diccionario y realizar algunas operaciones

        // Ejemplo de uso:
        Diccionario<String, Integer> diccionario = new DiccionarioTablaHash<>();
        diccionario.insertar("uno", 1);
        diccionario.insertar("dos", 2);
        diccionario.insertar("tres", 3);
        diccionario.insertar("cuatro", 4);
        diccionario.insertar("cinco", 5);


        System.out.println(diccionario);
        System.out.println("-----------------------------------");

        diccionario.insertar("seis", 6);
        diccionario.insertar("siete", 7);
        diccionario.insertar("ocho", 8);
        diccionario.insertar("nueve", 9);
        diccionario.insertar("diez", 10);
        diccionario.insertar("once", 11);
        diccionario.insertar("doce", 11);

        System.out.println(diccionario);

        System.out.println("Eliminado 'uno': " + diccionario.eliminar("uno"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println("Buscando el 'cinco': " + diccionario.buscar("cinco"));
    }
}