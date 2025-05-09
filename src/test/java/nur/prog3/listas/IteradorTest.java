package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteradorTest {
    @Test
    void iterador3ElementosString() {
        // Arrange
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        String result = "";
        Iterator<String> iter = lista.iterator();
        while(iter.hasNext()) {
            String elemento = iter.next();
            result += elemento;
        }

        // Assert
        String expected = "LuisPacoHugo";
        assertEquals(expected, result);
    }

    @Test
    void iterador3ElementosForString() {
        // Arrange
        Lista<String> lista = new Lista<>();
        lista.insertar("Hugo");
        lista.insertar("Paco");
        lista.insertar("Luis");

        // Act
        String result = "";
        for (String elemento : lista) {
            result += elemento;
        }

        // Assert
        String expected = "LuisPacoHugo";
        assertEquals(expected, result);
    }
}
