package com.politecnico;

public class Producto {

    private String nombre;
    private double precio;
    private double indiceDeValoracion;

    public Producto(String nombre, double precio, double indiceDeValoracion){
        this.nombre = nombre;
        this.precio = precio;
        this.indiceDeValoracion = indiceDeValoracion;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio = precio;
    }

    public double getIndiceDeValoracion(){
        return indiceDeValoracion;
    }

    public void setIndiceDeValoracion(){
        this.indiceDeValoracion = indiceDeValoracion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + '\n' +
                "Precio: " + precio + '\n' +
                "Indice de Valoracion: " + indiceDeValoracion + '\n' +
                "=============================================";
    }
}
