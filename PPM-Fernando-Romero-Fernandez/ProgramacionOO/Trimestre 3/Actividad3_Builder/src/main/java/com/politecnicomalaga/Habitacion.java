package com.politecnicomalaga;

public class Habitacion {
    public final static int HABITACION_SIMPLE = 1;
    public final static int HABITACION_DOBLE = 2;
    public final static int HABITACION_SUITE = 3;

    private String tipo;

    public Habitacion(int tipoHab){
        if(tipoHab == 1){
            this.tipo = "Simple";
        } else if(tipoHab == 2){
            this.tipo = "Doble";
        } else if(tipoHab == 3){
            this.tipo = "Suite";
        }
    }

    @Override
    public String toString() {
        return tipo;
    }
}
