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
}
