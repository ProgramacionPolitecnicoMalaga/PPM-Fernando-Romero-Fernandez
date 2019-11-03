package com.politecnico;

public class SMejorRelacion implements SelectorDeMejorProducto{

    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) {
        Producto productoMejorRelacion = null;
        double mejorRelacion = Double.MIN_VALUE;

        for (int i = 0; i < lote.getTotalProductos(); i++) {
            Producto productoActual = lote.getProductoEnPosicion(i);
            double precioActual = productoActual.getPrecio();
            double valoracionActual = productoActual.getIndiceDeValoracion();
            double relacionActual = productoActual.getPrecio()/productoActual.getIndiceDeValoracion();

            if (relacionActual > mejorRelacion) {
                mejorRelacion = relacionActual;
                productoMejorRelacion = productoActual;
            }

        }
        return productoMejorRelacion;
    }
}
