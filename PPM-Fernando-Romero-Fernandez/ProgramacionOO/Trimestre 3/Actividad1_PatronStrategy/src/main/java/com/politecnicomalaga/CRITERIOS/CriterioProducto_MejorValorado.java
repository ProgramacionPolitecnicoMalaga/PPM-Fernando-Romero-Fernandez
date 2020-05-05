package com.politecnicomalaga.CRITERIOS;

import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

import java.util.ArrayList;

public class CriterioProducto_MejorValorado implements SelectorDeMejorProducto {

    public Producto elegirMejorProducto(LoteDeProductos loteDeProductos) {
        Producto producto = null;
        int mejorValoracion = 0;
        ArrayList<Producto> listaProductos = loteDeProductos.getListaProductos();
        for(int i = 0; i < listaProductos.size(); i++){
            if(listaProductos.get(i).getValoracion() > mejorValoracion){
                producto = listaProductos.get(i);
                mejorValoracion = listaProductos.get(i).getValoracion();
            }
        }
        return producto;
    }
}
