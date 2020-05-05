package com.politecnicomalaga.CRITERIOS;

import com.politecnicomalaga.MODELO.LoteDeProductos;
import com.politecnicomalaga.MODELO.Producto;

public interface SelectorDeMejorProducto {

    public final static int CRITERIO_PRODUCTO_MEJOR_VALORADO = 1;
    public final static int CRITERIO_PRODUCTO_MAS_BARATO = 2;
    public final static int CRITERIO_PRODUCTO_MEJOR_RELACION_VALORACION_PRECIO = 3;

    public Producto elegirMejorProducto(LoteDeProductos loteDeProductos);
}
