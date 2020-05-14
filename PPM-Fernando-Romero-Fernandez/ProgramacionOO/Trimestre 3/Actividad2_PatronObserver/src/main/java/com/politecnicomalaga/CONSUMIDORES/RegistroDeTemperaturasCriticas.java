package com.politecnicomalaga.CONSUMIDORES;

import com.politecnicomalaga.REGISTRO.Registro;

import java.time.LocalTime;
import java.util.ArrayList;

public class RegistroDeTemperaturasCriticas implements ConsumidorDeTemperaturas {

    private ArrayList<Registro> arrayTemperaturasCriticas;

    public RegistroDeTemperaturasCriticas(){
        arrayTemperaturasCriticas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        if(temperatura > 90){
            arrayTemperaturasCriticas.add(new Registro(temperatura,hora));
        }
    }

    @Override
    public String toString() {
        String cadena;
        cadena = "Temperaturas críticas:\n";
        for(int i = 0; i < arrayTemperaturasCriticas.size(); i++){
            cadena += arrayTemperaturasCriticas.get(i).getHora() + " - " + arrayTemperaturasCriticas.get(i).getTemperatura() + "ºC\n";
        }
        return cadena;
    }
}
