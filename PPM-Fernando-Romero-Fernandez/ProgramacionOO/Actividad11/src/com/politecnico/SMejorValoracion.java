package com.politecnico;

public class SMejorValoracion implements SelectorDeMejorProducto{

    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        Producto productoMejorValorado = null;
        double mejorValoracion = Double.MIN_VALUE;

        for (int i = 0; i < lote.getTotalProductos(); i++) {
            Producto productoActual = lote.getProductoEnPosicion(i);
            double valoracionActual = productoActual.getIndiceDeValoracion();

            if (valoracionActual > mejorValoracion) {
                mejorValoracion = valoracionActual;
                productoMejorValorado = productoActual;
            }

        }
        return productoMejorValorado;
    }
}
