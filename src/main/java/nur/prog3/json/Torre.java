package nur.prog3.json;

import javax.json.*;
import java.util.Stack;

public class Torre {
    private final Stack<Anillo> anillos;

    public Torre(int n) {
        anillos = new Stack<Anillo>();
        for (int i = n; i > 0; i--) {
            anillos.push(new Anillo(i));
        }
    }

    public Torre() {
        anillos = new Stack<Anillo>();
    }

    public Stack<Anillo> getAnillos() {
        return anillos;
    }

    public JsonObject getJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        for (Anillo a : anillos) {
            arrayBuilder.add(a.getJson());
        }
        JsonArray anillosArray = arrayBuilder.build();
        builder.add("anillos", anillosArray);

        return builder.build();
    }
}
