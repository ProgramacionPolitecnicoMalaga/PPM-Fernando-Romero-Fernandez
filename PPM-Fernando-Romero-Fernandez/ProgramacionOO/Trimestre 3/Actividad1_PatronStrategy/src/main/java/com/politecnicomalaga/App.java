package com.politecnicomalaga;

import com.politecnicomalaga.CRITERIOS.Criterio;
import com.politecnicomalaga.CRITERIOS.SelectorDeMejorProducto;
import com.politecnicomalaga.FACTORY_CRITERIOS.Criterios_Factory;
import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

import java.util.Scanner;

public class App {
    static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        LoteDeProductos loteDeProductos = new LoteDeProductos();

        Producto producto = new Producto("Comba",1.50,2);
        Producto producto2 = new Producto("Pelota",10.50,4);
        Producto producto3 = new Producto("Raqueta",15.50,5);

        loteDeProductos.addProducto(producto);
        loteDeProductos.addProducto(producto2);
        loteDeProductos.addProducto(producto3);

        System.out.println("Seleccione un tipo de criterio de mejor producto");
        System.out.println("--------------------------------");
        System.out.println("1. Mejor Valorado\n");
        System.out.println("2. Más barato\n");
        System.out.println("3. Mejor en Relación Calidad Precio\n");

        int opcionSeleccionada = lectorTeclado.nextInt();
        SelectorDeMejorProducto selectorDeMejorProducto = Criterios_Factory.asignarCriterio(opcionSeleccionada);
        Criterio generadorCriterio = new Criterio();
        generadorCriterio.setCriterio(selectorDeMejorProducto);
        System.out.println(generadorCriterio.getMejorProducto(loteDeProductos));

    }
}
