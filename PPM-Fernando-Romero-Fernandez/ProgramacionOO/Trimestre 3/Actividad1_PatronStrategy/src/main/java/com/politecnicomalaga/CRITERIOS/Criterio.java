package com.politecnicomalaga.CRITERIOS;

import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

public class Criterio {
    private SelectorDeMejorProducto criterioSeleccionado;

    public void setCriterio(SelectorDeMejorProducto criterioSeleccionado){
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public Producto getMejorProducto(LoteDeProductos loteDeProductos){
        return criterioSeleccionado.elegirMejorProducto(loteDeProductos);
    }
}
