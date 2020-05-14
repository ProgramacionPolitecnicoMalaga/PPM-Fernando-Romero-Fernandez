package com.politecnicomalaga.REGISTRO;

import java.time.LocalTime;

public class Registro {

    public int temperatura;
    public LocalTime hora;

    public Registro(int temperatura, LocalTime hora){
        this.temperatura = temperatura;
        this.hora = hora;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
