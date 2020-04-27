package com.politecnicomalaga;

public class PackBasicoBuilder implements PackBuilder {

    private Pack resultado;

    public PackBasicoBuilder(){
        resultado = new Pack();
    }

    public PackBuilder añadirHabitacion() {
        resultado.setHabitacion(1);
        return this;
    }

    public PackBuilder añadirCamaAdicional() {
        resultado.setCamaAdicional(false);
        return this;
    }

    public PackBuilder añadirDesayuno() {
        resultado.setDesayuno(true);
        return this;
    }

    public PackBuilder añadirAlmuerzo() {
        resultado.setAlmuerzo(false);
        return this;
    }

    public PackBuilder añadirCena() {
        resultado.setCena(false);
        return this;
    }

    public PackBuilder añadirParqueAtracciones() {
        resultado.setParqueDeAtracciones(false);
        return this;
    }

    public PackBuilder añadirCursoKiteSurf() {
        resultado.setCursoKiteSurf(false);
        return this;
    }

    public PackBuilder añadirActividadesInfantiles() {
        resultado.setActividadesInfantiles(false);
        return this;
    }

    public PackBuilder añadirCineEnLaPlaya() {
        resultado.setCineEnLaPlaya(false);
        return this;
    }

    public Pack getResultado() {
        return resultado;
    }
}
