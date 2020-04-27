package com.politecnicomalaga;

public class Pack {

    private Habitacion habitacion;
    private boolean camaAdicional;
    private boolean desayuno;
    private boolean almuerzo;
    private boolean cena;
    private boolean parqueDeAtracciones;
    private boolean cursoKiteSurf;
    private boolean actividadesInfantiles;
    private boolean cineEnLaPlaya;

    public Pack(){
    }

    public void setHabitacion(int tipoHabitacion){
        this.habitacion = new Habitacion(tipoHabitacion);
    }

    public void setCamaAdicional(boolean camaAdicional){
        this.camaAdicional = camaAdicional;
    }

    public void setDesayuno(boolean desayuno){
        this.desayuno = desayuno;
    }

    public void setAlmuerzo(boolean almuerzo){
        this.almuerzo = almuerzo;
    }

    public void setCena(boolean cena){
        this.cena = cena;
    }

    public void setParqueDeAtracciones(boolean parqueDeAtracciones) {
        this.parqueDeAtracciones = parqueDeAtracciones;
    }

    public void setCursoKiteSurf(boolean cursoKiteSurf) {
        this.cursoKiteSurf = cursoKiteSurf;
    }

    public void setActividadesInfantiles(boolean actividadesInfantiles) {
        this.actividadesInfantiles = actividadesInfantiles;
    }

    public void setCineEnLaPlaya(boolean cineEnLaPlaya) {
        this.cineEnLaPlaya = cineEnLaPlaya;
    }

    @Override
    public String toString() {
        return "Pack{" + "\n" +
                "habitacion=" + habitacion + "\n" +
                ", camaAdicional=" + camaAdicional + "\n" +
                ", desayuno=" + desayuno + "\n" +
                ", almuerzo=" + almuerzo + "\n" +
                ", cena=" + cena + "\n" +
                ", parqueDeAtracciones=" + parqueDeAtracciones + "\n" +
                ", cursoKiteSurf=" + cursoKiteSurf + "\n" +
                ", actividadesInfantiles=" + actividadesInfantiles + "\n" +
                ", cineEnLaPlaya=" + cineEnLaPlaya + "\n" +
                '}';
    }
}
