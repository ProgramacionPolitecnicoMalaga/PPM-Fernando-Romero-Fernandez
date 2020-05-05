package com.politecnicomalaga.COMPOSITE;

public interface Servicio {
    public final static int PAQUETE = 1;
    public final static int PRODUCTO = 2;

    public String getNombre();
    public int getPrecio();
    public String toString();
    public int getTipo();
}
