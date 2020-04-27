package com.politecnicomalaga;

public class DirectorPack {

    private PackBuilder builder;

    public DirectorPack(PackBuilder builder){
        this.builder = builder;
    }

    public Pack crearPackBasico(){
        return builder.añadirHabitacion()
                    .añadirDesayuno()
                    .getResultado();
    }

    public Pack crearPackRomance(){
        return builder.añadirHabitacion()
                    .añadirCena()
                    .getResultado();
    }

    public Pack crearPackFamiliar(){
        return builder.añadirHabitacion()
                    .añadirCamaAdicional()
                    .añadirDesayuno()
                    .añadirAlmuerzo()
                    .añadirCena()
                    .añadirParqueAtracciones()
                    .añadirActividadesInfantiles()
                    .añadirCineEnLaPlaya()
                    .getResultado();
    }

    public Pack crearPackPadresRelajados(){
        return builder.añadirHabitacion()
                    .añadirCamaAdicional()
                    .añadirDesayuno()
                    .añadirAlmuerzo()
                    .añadirCena()
                    .añadirActividadesInfantiles()
                    .añadirCursoKiteSurf()
                    .añadirCineEnLaPlaya()
                    .getResultado();
    }

    public Pack crearPackDeluxe(){
        return builder.añadirHabitacion()
                    .añadirDesayuno()
                    .añadirAlmuerzo()
                    .añadirCena()
                    .añadirCursoKiteSurf()
                    .añadirCineEnLaPlaya()
                    .getResultado();
    }

    public Pack crearPackDeluxeFamiliar(){
        return builder.añadirHabitacion()
                    .añadirCamaAdicional()
                    .añadirDesayuno()
                    .añadirAlmuerzo()
                    .añadirCena()
                    .añadirParqueAtracciones()
                    .añadirCursoKiteSurf()
                    .añadirActividadesInfantiles()
                    .añadirCineEnLaPlaya()
                    .getResultado();
    }

}
