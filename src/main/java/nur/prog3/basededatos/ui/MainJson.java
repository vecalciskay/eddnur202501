package nur.prog3.basededatos.ui;

import nur.prog3.basededatos.model.Persona;

import javax.json.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainJson {

    public static void main(String[] args) {
        Persona persona1 = new Persona(1,"Juan", 18);
        Persona persona2 = new Persona(2,"Luis", 20);

        JSONObject json1 = new JSONObject(persona1);
        JSONObject json2 = new JSONObject(persona2);


        JSONArray jsonArray = new JSONArray();
        jsonArray.put(json1);
        jsonArray.put(json2);

        System.out.println(jsonArray);
    }
}
