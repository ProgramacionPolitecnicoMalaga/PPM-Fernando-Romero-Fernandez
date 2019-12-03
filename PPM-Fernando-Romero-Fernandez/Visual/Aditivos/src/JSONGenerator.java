import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSONGenerator{

    private String ruta;

    public JSONGenerator(String ruta) {
        this.ruta = ruta;
    }

    public ArrayList<Aditivo> cargarJSON() throws IOException {

        BufferedReader Lector = null;

        try {
            Lector = new BufferedReader(new FileReader(ruta));
            JsonParser parser = new JsonParser();
            JsonArray jsonArray1 = parser.parse(Lector).getAsJsonArray();
            ArrayList<Aditivo> listaAditivos = new ArrayList<>();
            for(JsonElement obj : jsonArray1){
                JsonObject miObjetoActual = obj.getAsJsonObject();
                String peligrosidad = miObjetoActual.get("peligrosidad").getAsString();
                String nombre = miObjetoActual.get("name").getAsString();
                String comentario = miObjetoActual.get("comentario").getAsString();

                Aditivo aditivoActual = new Aditivo(peligrosidad,nombre,comentario);
                listaAditivos.add(aditivoActual);
            }
            return listaAditivos;

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}