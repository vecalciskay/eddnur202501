package nur.prog3.arboles.main;

import nur.prog3.arboles.Arbol;
import nur.prog3.arboles.PersonaParaArbol;
import nur.prog3.listas.PersonaParaLista;

public class MainArbol {



    public static void main(String[] args) {

        Arbol<PersonaParaArbol> arbol = new Arbol<>();

        PersonaParaArbol p1 = new PersonaParaArbol("Jorge", "Gonzales", "A");
        arbol.insertar(p1);

        PersonaParaArbol p2 = new PersonaParaArbol("Daniel", "Morales", "B");
        arbol.insertar(p2, "A");

        PersonaParaArbol p3 = new PersonaParaArbol("Diego", "Perez", "C");
        arbol.insertar(p3, "A");

        PersonaParaArbol p4 = new PersonaParaArbol("Hugo", "Morales", "D");
        arbol.insertar(p4, "C");

        PersonaParaArbol p5 = new PersonaParaArbol("Lucas", "Morales", "E");
        arbol.insertar(p4, "A");

        System.out.println(arbol.recorrerPostOrden());
    }
}
