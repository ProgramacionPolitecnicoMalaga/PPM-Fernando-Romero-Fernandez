package com.politecnicomalaga.FACTORY_CRITERIOS;

import com.politecnicomalaga.CRITERIOS.CriterioProducto_MasBarato;
import com.politecnicomalaga.CRITERIOS.CriterioProducto_MejorRelacionValoracionPrecio;
import com.politecnicomalaga.CRITERIOS.CriterioProducto_MejorValorado;
import com.politecnicomalaga.CRITERIOS.SelectorDeMejorProducto;

public class Criterios_Factory {
    public static SelectorDeMejorProducto asignarCriterio(int criterio){
        switch (criterio){
            case SelectorDeMejorProducto.CRITERIO_PRODUCTO_MEJOR_VALORADO:
                return new CriterioProducto_MejorValorado();
            case SelectorDeMejorProducto.CRITERIO_PRODUCTO_MAS_BARATO:
                return new CriterioProducto_MasBarato();
            case SelectorDeMejorProducto.CRITERIO_PRODUCTO_MEJOR_RELACION_VALORACION_PRECIO:
                return new CriterioProducto_MejorRelacionValoracionPrecio();
            default:
                return new CriterioProducto_MejorValorado();
        }
    }
}
