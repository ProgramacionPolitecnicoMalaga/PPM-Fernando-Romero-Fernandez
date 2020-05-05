package com.politecnicomalaga.COMPOSITE;

import java.util.ArrayList;
import java.util.List;

public class Paquete implements Servicio{

    private String nombre;
    private int precio;
    private ArrayList<Servicio> listaServicios;

    public Paquete(String nombre, int precio){
        this.nombre = nombre;
        this.precio = precio;
        listaServicios = new ArrayList<Servicio>();
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPrecio() {
        int precioTotal = precio;
        for (Servicio servicio : listaServicios) {
            precioTotal += servicio.getPrecio();
        }
        return precioTotal;
    }

    public void add(Servicio servicio){
        listaServicios.add(servicio);
    }

    public Servicio getServicioPorNombre(String nombre){
        if (this.nombre == nombre)
            return this;
        else for (Servicio servicio : listaServicios) {
            if (servicio.getTipo() == Servicio.PAQUETE){
                Paquete paquete = (Paquete) servicio;
                Servicio subServicio = ((Paquete) servicio).getServicioPorNombre(nombre);
                if ((subServicio != null) && (subServicio.getNombre() == nombre))
                    return subServicio;
            } else if (servicio.getTipo() == Servicio.PRODUCTO)
                if (servicio.getNombre() == nombre)
                    return servicio;
        }
        return null;
    }

    public String toString(){
        String resultado = nombre + " " +precio +" [";
        for (int i=0; i <listaServicios.size()-1; i++) {
            resultado += listaServicios.get(i).toString() + ",";
        }
        if (listaServicios.size()>0)
            resultado += listaServicios.get(listaServicios.size()-1);
        resultado += "]";
        return resultado;
    }

    public int getTipo() {
        return Servicio.PAQUETE;
    }
}
