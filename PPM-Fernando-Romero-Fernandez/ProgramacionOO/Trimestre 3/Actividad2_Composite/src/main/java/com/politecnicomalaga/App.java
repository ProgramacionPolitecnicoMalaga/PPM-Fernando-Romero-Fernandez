package com.politecnicomalaga;

import com.politecnicomalaga.BUILDER_HELPER.ServicioBuilder;
import com.politecnicomalaga.COMPOSITE.Paquete;
import com.politecnicomalaga.COMPOSITE.Servicio;

public class App {
    public static void main(String[] args) {
        ServicioBuilder builder = new ServicioBuilder("iLink1",30);
            builder.iniciarPaquete("iLink1.1",30)
                        .iniciarPaquete("Rack1",20)
                            .addProducto("Servidor1.1",25)
                            .addProducto("Servidor1.2",25)
                        .finalizarPaquete()
                        .iniciarPaquete("Rack2",20)
                            .addProducto("Servidor2.1",25)
                        .finalizarPaquete()
                    .finalizarPaquete()
                    .iniciarPaquete("CloudSolutions",15)
                        .iniciarPaquete("VPS1",20)
                            .iniciarPaquete("Rack3.1",20)
                                .addProducto("VPS4.1",20)
                                .addProducto("VPS4.2",20)
                            .finalizarPaquete()
                        .finalizarPaquete()
                    .finalizarPaquete()
                .finalizarPaquete();

        //NO ESTOY SEGURO SI CLOUDSOLUTIONS EL PAQUETE CLOUDSOLUTIONS ERA ASÍ:
        //CLOUDSOLUTIONS[VPS[RACK[VPS,VPS]]]
        //O ASÍ:
        //CLOUDSOLUTIONSVPS[RACK[VPS,VPS]]
        //LO HICE DE LA PRIMERA FORMA, CREO QUE EN LA IMAGEN DEL GITHUB FALTA UN RECTÁNGULO QUIZÁS?

        Servicio servicio = builder.getResultado();
        System.out.println(servicio.toString());

        //Precio total de Rack1

        Servicio rack1 = ((Paquete) servicio).getServicioPorNombre("Rack1");
        System.out.println("El precio a pagar por el paquete " + rack1.getNombre() + " es = " + rack1.getPrecio());

        //Precio total de iLink1.1

        Servicio iLink11 = ((Paquete) servicio).getServicioPorNombre("iLink1.1");
        System.out.println("El precio a pagar por el paquete " + iLink11.getNombre() + " es = " + iLink11.getPrecio());

        //Precio total de iLink1

        Servicio iLink1 = ((Paquete) servicio).getServicioPorNombre("iLink1");
        System.out.println("El precio a pagar por el paquete " + iLink1.getNombre() + " es = " + iLink1.getPrecio());

        //Precio total de CloudSolutions

        Servicio cloudSolutions = ((Paquete) servicio).getServicioPorNombre("CloudSolutions");
        System.out.println("El precio a pagar por el paquete " + cloudSolutions.getNombre() + " es = " + cloudSolutions.getPrecio());
    }

}
