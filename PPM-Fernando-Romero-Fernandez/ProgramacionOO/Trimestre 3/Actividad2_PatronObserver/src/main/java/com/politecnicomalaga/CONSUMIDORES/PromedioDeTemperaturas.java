package com.politecnicomalaga.CONSUMIDORES;

import com.politecnicomalaga.REGISTRO.Registro;

import java.time.LocalTime;
import java.util.ArrayList;

public class PromedioDeTemperaturas implements ConsumidorDeTemperaturas{

    private ArrayList<Registro> registros;
    private int promedio;

    public PromedioDeTemperaturas(){
        registros = new ArrayList<>();
    }
    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        registros.add(new Registro(temperatura,hora));
        for(int i = 0; i < registros.size(); i++){
            promedio += registros.get(i).getTemperatura();
        }
        promedio = promedio/registros.size();
    }

    @Override
    public String toString() {
        return "El promedio de temperaturas es: " + promedio + " ºC";
    }
}
