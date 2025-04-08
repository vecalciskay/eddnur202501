package nur.prog3.json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Anillo {
    private final int tamano;

    public Anillo(int n) {
        tamano = n;
    }

    public int getTamano() {
        return tamano;
    }

    public JsonObject getJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();

        builder.add("tamano", tamano);

        return builder.build();
    }
}
