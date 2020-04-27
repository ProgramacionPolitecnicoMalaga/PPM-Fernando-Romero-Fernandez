package com.politecnicomalaga;

public class PackDeluxeFamiliarBuilder implements PackBuilder{

    private Pack resultado;

    public PackDeluxeFamiliarBuilder(){
        resultado = new Pack();
    }

    public PackBuilder añadirHabitacion() {
        resultado.setHabitacion(3);
        return this;
    }

    public PackBuilder añadirCamaAdicional() {
        resultado.setCamaAdicional(true);
        return this;
    }

    public PackBuilder añadirDesayuno() {
        resultado.setDesayuno(true);
        return this;
    }

    public PackBuilder añadirAlmuerzo() {
        resultado.setAlmuerzo(true);
        return this;
    }

    public PackBuilder añadirCena() {
        resultado.setCena(true);
        return this;
    }

    public PackBuilder añadirParqueAtracciones() {
        resultado.setParqueDeAtracciones(true);
        return this;
    }

    public PackBuilder añadirCursoKiteSurf() {
        resultado.setCursoKiteSurf(true);
        return this;
    }

    public PackBuilder añadirActividadesInfantiles() {
        resultado.setActividadesInfantiles(true);
        return this;
    }

    public PackBuilder añadirCineEnLaPlaya() {
        resultado.setCineEnLaPlaya(true);
        return this;
    }

    public Pack getResultado() {
        return resultado;
    }
}
