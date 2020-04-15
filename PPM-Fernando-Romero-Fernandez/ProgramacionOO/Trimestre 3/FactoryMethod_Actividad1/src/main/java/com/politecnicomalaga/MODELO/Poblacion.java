package com.politecnicomalaga.MODELO;

public class Poblacion {

    private String año, nacionalidad;
    private int numeroEmpadronados;

    public Poblacion(String año, String nacionalidad, int numeroEmpadronados){
        this.año = año;
        this.nacionalidad = nacionalidad;
        this.numeroEmpadronados = numeroEmpadronados;
    }

    public String getAño() {
        return año;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getNumeroEmpadronados() {
        return numeroEmpadronados;
    }
}
