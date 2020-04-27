package com.politecnicomalaga;

public class PackRomanceBuilder implements PackBuilder{

    private Pack resultado;

    public PackRomanceBuilder(){
        resultado = new Pack();
    }

    public PackBuilder añadirHabitacion() {
        resultado.setHabitacion(2);
        return this;
    }

    public PackBuilder añadirCamaAdicional() {
        resultado.setCamaAdicional(false);
        return this;
    }

    public PackBuilder añadirDesayuno() {
        resultado.setDesayuno(false);
        return this;
    }

    public PackBuilder añadirAlmuerzo() {
        resultado.setAlmuerzo(false);
        return this;
    }

    public PackBuilder añadirCena() {
        resultado.setCena(true);
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
