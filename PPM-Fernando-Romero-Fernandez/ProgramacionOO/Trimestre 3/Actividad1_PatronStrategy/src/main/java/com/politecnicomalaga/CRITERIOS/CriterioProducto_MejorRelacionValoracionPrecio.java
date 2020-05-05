package com.politecnicomalaga.CRITERIOS;

import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

import java.util.ArrayList;

public class CriterioProducto_MejorRelacionValoracionPrecio implements SelectorDeMejorProducto {

    public Producto elegirMejorProducto(LoteDeProductos loteDeProductos) {
        Producto producto = null;
        double mejorRelacion = 0;
        ArrayList<Producto> listaProductos = loteDeProductos.getListaProductos();
        for(int i = 0; i < listaProductos.size(); i++){
            double relacion = listaProductos.get(i).getPrecio() / listaProductos.get(i).getValoracion();
            if(mejorRelacion < relacion){
                producto = listaProductos.get(i);
                mejorRelacion = relacion;
            }
        }
        return producto;
    }
}
