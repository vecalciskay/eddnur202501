package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaTest {
    @Test
    void Insertar3ObjetosEnListaTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = "Luis --> Paco --> Hugo --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }
    @Test
    void Get0Test() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = "Luis";
        String result = lista.get(0);

        assertEquals(expected, result);
    }
    @Test
    void Get2Test() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = "Hugo";
        String result = lista.get(2);

        assertEquals(expected, result);
    }

    @Test
    void GetOutOfBoundsTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = null;
        String result = lista.get(5);

        assertEquals(expected, result);
    }

    @Test
    void GetOutOfBoundsNegativeTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = null;
        String result = lista.get(-5);

        assertEquals(expected, result);
    }

    @Test
    void Eliminar0Test() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = "Paco --> Hugo --> ";
        lista.eliminar(0);
        String result = lista.toString();

        assertEquals(expected, result);
    }

    @Test
    void EliminarYTamanoCorrectoTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Daisy");

        int expected = 2;
        lista.eliminar(1);
        lista.eliminar(2);
        int result = lista.getTamano();

        assertEquals(expected, result);
    }

    @Test
    void IntercambiarTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Daisy");

        // intercambia Daisy con Paco
        lista.intercambiar(0,2);
        String expected = "Paco --> Luis --> Daisy --> Hugo --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }

    @Test
    void ordenar10ElementosTest() {
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");
        lista.insertar("Daisy");
        lista.insertar("Maria");
        lista.insertar("Rolando");
        lista.insertar("Carlos");
        lista.insertar("Diego");

        // ordena
        lista.ordenar();
        String expected = "Carlos --> Daisy --> Diego --> Hugo --> Luis --> Maria --> Paco --> Rolando --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }

    @Test
    void ordenarPersonas() {
        // Arrange
        Lista<PersonaParaLista> lista = new Lista<>();
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
}
