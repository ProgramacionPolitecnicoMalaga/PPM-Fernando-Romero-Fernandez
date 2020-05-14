package com.politecnicomalaga.CONSUMIDORES;


import com.politecnicomalaga.REGISTRO.Registro;

import java.time.LocalTime;
import java.util.ArrayList;

public class DiarioDeTemperaturas implements ConsumidorDeTemperaturas{

    private ArrayList<Registro> arrayTemperaturasPorHoras;

    public DiarioDeTemperaturas(){
        arrayTemperaturasPorHoras = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        arrayTemperaturasPorHoras.add(new Registro(temperatura,hora));
    }

    @Override
    public String toString() {
        String cadena;
            cadena = "Hoy tuvimos estas temperaturas:\n";
            for(int i = 0; i < arrayTemperaturasPorHoras.size(); i++){
                cadena += arrayTemperaturasPorHoras.get(i).getHora() + " - " + arrayTemperaturasPorHoras.get(i).getTemperatura() + "ºC\n";
            }
        return cadena;
    }
}
