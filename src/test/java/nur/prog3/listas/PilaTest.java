package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PilaTest {
    @Test
    void pushPop4Elementos() {
        Pila<String> pila = new Pila<>();
        pila.push("Hugo");
        pila.push("Paco");
        pila.push("Luis");
        pila.push("Daisy");

        String result = pila.pop();
        result = pila.pop();
        result = pila.pop();

        String expected =  "Paco";
        assertEquals(expected, result);
    }
}
