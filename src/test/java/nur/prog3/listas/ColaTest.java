package nur.prog3.listas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColaTest {
    @Test
    void pushPull4Elementos() {
        Cola<String> cola = new Cola<>();
        cola.push("Hugo");
        cola.push("Paco");
        cola.push("Luis");
        cola.push("Daisy");

        String result = cola.pull();
        result = cola.pull();
        result = cola.pull();

        String expected =  "Luis";
        assertEquals(expected, result);
    }
}
