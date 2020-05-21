package Concatenacion;

import java.util.List;

public class Concatenacion {

    public String concatenar(List<String> palabras){
        String palabrasConcatenadas = "";
        for(int i = 0; i < palabras.size(); i++){
            palabrasConcatenadas += palabras.get(i);
        }
        return palabrasConcatenadas;
    }
}
