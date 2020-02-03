package com.politecnico;

public interface SelectorDeMejorProducto {

    public Producto elegirMejorProducto(LoteDeProductos lote) throws OutOfMaxProductsException;
}
