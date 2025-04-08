package nur.prog3.json;

import javax.json.*;
import java.io.StringWriter;

public class Hanoi {
    private final Torre[] torres;

    public Hanoi(int n) {
        torres = new Torre[3];
        torres[0] = new Torre(n);
        torres[1] = new Torre();
        torres[2] = new Torre();
    }

    public JsonObject getJson() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        JsonObject torre1 = torres[0].getJson();
        JsonObject torre2 = torres[1].getJson();
        JsonObject torre3 = torres[2].getJson();

        arrayBuilder.add(torre1);
        arrayBuilder.add(torre2);
        arrayBuilder.add(torre3);
        JsonArray torresArray = arrayBuilder.build();

        builder.add("torres", torresArray);

        return builder.build();
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi(3);

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(stringWriter);
        jsonWriter.writeObject(h.getJson());
        jsonWriter.close();

        System.out.println(stringWriter.toString());
    }
}
