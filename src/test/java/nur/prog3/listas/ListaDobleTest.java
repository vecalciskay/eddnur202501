package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListaDobleTest {
    @Test
    void getListaLargaMenosDeLaMitad() {
        // Arrange
        ListaDoble<String> lista = new ListaDoble<>();
        for (int i = 0; i < 10000; i++) {
            lista.adicionar("M" + i);
        }

        // Act
        String result =  lista.get(50);

        // Assert
        String expected = "M50";
        assertEquals(expected, result);
    }

    @Test
    void getListaLargaMasDeLaMitad() {
// Arrange
        ListaDoble<String> lista = new ListaDoble<>();
        for (int i = 0; i < 10000; i++) {
            lista.adicionar("M" + i);
        }

        // Act
        String result =  lista.get(8500);

        // Assert
        String expected = "M8500";
        assertEquals(expected, result);
    }

    @Test
    void Insertar3ObjetosEnListaTest() {
        ListaDoble<String> lista = new ListaDoble<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        String expected = "Luis --> Paco --> Hugo --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }

    @Test
    void Adicionar3ObjetosEnListaTest() {
        ListaDoble<String> lista = new ListaDoble<>();
        lista.adicionar("Hugo");
        lista.adicionar("Paco");
        lista.adicionar("Luis");

        String expected = "Hugo --> Paco --> Luis --> ";
        String result = lista.toString();

        assertEquals(expected, result);
    }
}
