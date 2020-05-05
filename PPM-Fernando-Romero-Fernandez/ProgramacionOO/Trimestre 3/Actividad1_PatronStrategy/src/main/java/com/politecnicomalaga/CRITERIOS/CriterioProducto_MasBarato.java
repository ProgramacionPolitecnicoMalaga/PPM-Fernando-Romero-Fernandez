package com.politecnicomalaga.CRITERIOS;

import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

import java.util.ArrayList;

public class CriterioProducto_MasBarato implements SelectorDeMejorProducto {

    public Producto elegirMejorProducto(LoteDeProductos loteDeProductos) {
        Producto producto = null;
        double menorPrecio = 999999999;
        ArrayList<Producto> listaProductos = loteDeProductos.getListaProductos();
        for(int i = 0; i < listaProductos.size(); i++){
            if(listaProductos.get(i).getPrecio() < menorPrecio){
                producto = listaProductos.get(i);
                menorPrecio = listaProductos.get(i).getPrecio();
            }
        }
        return producto;
    }
}
