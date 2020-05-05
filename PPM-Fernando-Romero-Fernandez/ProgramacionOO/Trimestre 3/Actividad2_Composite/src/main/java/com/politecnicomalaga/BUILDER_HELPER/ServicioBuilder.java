package com.politecnicomalaga.BUILDER_HELPER;

import com.politecnicomalaga.COMPOSITE.Paquete;
import com.politecnicomalaga.COMPOSITE.Producto;
import com.politecnicomalaga.COMPOSITE.Servicio;

public class ServicioBuilder {
    private ServicioBuilder builderPadre;
    private Paquete paquete;

    public ServicioBuilder(String nombrePaquete, int precio){
        this.paquete = new Paquete(nombrePaquete,precio);
        builderPadre = null;
    }

    public ServicioBuilder(Paquete paquete, ServicioBuilder builderPadre){
        this.paquete = paquete;
        this.builderPadre = builderPadre;
    }

    public ServicioBuilder iniciarPaquete(String nombreNuevoPaquete, int precioNuevoPaquete){
        Paquete nuevoPaquete = new Paquete(nombreNuevoPaquete,precioNuevoPaquete);
        this.paquete.add(nuevoPaquete);
        return new ServicioBuilder(nuevoPaquete,this);
    }

    public ServicioBuilder finalizarPaquete(){
        return builderPadre;
    }

    public ServicioBuilder addProducto(String nombre, int precio){
        paquete.add(new Producto(nombre,precio));
        return this;
    }

    public Servicio getResultado(){
        return paquete;
    }
}
