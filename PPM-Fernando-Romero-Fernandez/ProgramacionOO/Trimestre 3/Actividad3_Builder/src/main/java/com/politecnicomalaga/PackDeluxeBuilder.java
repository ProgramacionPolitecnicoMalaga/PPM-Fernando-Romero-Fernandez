package com.politecnicomalaga;

public class PackDeluxeBuilder implements PackBuilder{

    private Pack resultado;

    public PackDeluxeBuilder(){
        resultado = new Pack();
    }

    public PackBuilder añadirHabitacion() {
        resultado.setHabitacion(3);
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
        resultado.setAlmuerzo(true);
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
        resultado.setCursoKiteSurf(true);
        return this;
    }

    public PackBuilder añadirActividadesInfantiles() {
        resultado.setActividadesInfantiles(false);
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
