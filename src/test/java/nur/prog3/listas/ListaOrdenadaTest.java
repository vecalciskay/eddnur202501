package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaOrdenadaTest {

    @Test
    void ordenar10ElementosTest() {
        ListaOrdenada<String> lista = new ListaOrdenada<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Daisy");
        lista.insertar("Maria");
        lista.insertar("Rolando");
        lista.insertar("Carlos");
        lista.insertar("Diego");

        // ordena
        String expected = "Carlos --> Daisy --> Diego --> Hugo --> Luis --> Maria --> Paco --> Rolando --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }


    @Test
    void ordenarPersonas() {
        // Arrange
        ListaOrdenada<PersonaParaLista> lista = new ListaOrdenada<>();
        PersonaParaLista p = new PersonaParaLista(
                "Jorge","Gonzales", "9093809SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Daniel","Morales", "9423889SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Diego","Perez", "2393809SC");
        lista.insertar(p);
        p = new PersonaParaLista(
                "Hugo","Morales", "962189SC");
        lista.insertar(p);

        // ACt
        lista.ordenar();

        // Assert
        String expected =
                "Gonzales, Jorge (9093809SC) --> " +
                        "Morales, Daniel (9423889SC) --> " +
                        "Morales, Hugo (962189SC) --> " +
                        "Perez, Diego (2393809SC) --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }

    @Test
    void ordenarPersonasNoComparables() {
        // Arrange
        ListaOrdenada<PersonaNoComparable> lista = new ListaOrdenada<>();
        PersonaNoComparable p = new PersonaNoComparable(
                "Jorge","Gonzales", "9093809SC");
        lista.insertar(p);
        p = new PersonaNoComparable(
                "Daniel","Morales", "9423889SC");
        lista.insertar(p);
        p = new PersonaNoComparable(
                "Diego","Perez", "2393809SC");
        lista.insertar(p);
        p = new PersonaNoComparable(
                "Hugo","Morales", "962189SC");
        lista.insertar(p);

        // ACt
        lista.ordenar();

        // Assert
        String expected =
                "Morales, Hugo (962189SC) --> " +
                        "Perez, Diego (2393809SC) --> " +
                        "Morales, Daniel (9423889SC) --> " +
                "Gonzales, Jorge (9093809SC) --> ";


        String result = lista.toString();

        assertEquals(expected, result);
    }
}
