package nur.prog3.diccionarios.main;


import nur.prog3.diccionarios.Diccionario;
import nur.prog3.diccionarios.DiccionarioLista;

public class MainDiccionarioLista {

    public static void main(String[] args) {

        // Aquí puedes probar tu implementación de Diccionario y Comparador
        // Por ejemplo, crear un Diccionario y realizar algunas operaciones

        // Ejemplo de uso:
        Diccionario<String, Integer> diccionario = new DiccionarioLista<>();
        diccionario.insertar("uno", 1);
        diccionario.insertar("dos", 2);
        diccionario.insertar("tres", 3);
        diccionario.insertar("cuatro", 4);
        diccionario.insertar("cinco", 5);

        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println(diccionario.eliminar("uno"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println(diccionario.eliminar("cinco"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println(diccionario.eliminar("tres"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println(diccionario.eliminar("dos"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
        System.out.println(diccionario.eliminar("cuatro"));
        System.out.println(diccionario);
        System.out.println("-----------------------------------");
    }
}
