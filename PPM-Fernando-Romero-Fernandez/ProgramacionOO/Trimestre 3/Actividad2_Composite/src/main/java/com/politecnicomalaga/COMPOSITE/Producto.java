package com.politecnicomalaga.COMPOSITE;

public class Producto implements Servicio{

    private String nombre;
    private int precio;

    public Producto(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getTipo() {
        return Servicio.PRODUCTO;
    }

    @Override
    public String toString() {
        return nombre + " " + precio;
    }
}
