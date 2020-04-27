package com.politecnicomalaga;

public interface PackBuilder {

    public PackBuilder añadirHabitacion();

    public PackBuilder añadirCamaAdicional();

    public PackBuilder añadirDesayuno();

    public PackBuilder añadirAlmuerzo();

    public PackBuilder añadirCena();

    public PackBuilder añadirParqueAtracciones();

    public PackBuilder añadirCursoKiteSurf();

    public PackBuilder añadirActividadesInfantiles();

    public PackBuilder añadirCineEnLaPlaya();

    public Pack getResultado();
}
