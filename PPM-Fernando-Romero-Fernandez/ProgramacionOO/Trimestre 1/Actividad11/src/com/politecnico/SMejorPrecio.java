package com.politecnico;

public class SMejorPrecio implements SelectorDeMejorProducto{


    @Override
    public Producto elegirMejorProducto(LoteDeProductos lote) throws OutOfMaxProductsException {
        Producto productoMasBarato = null;
        double menorPrecio = Double.MAX_VALUE;

        for(int i= 0; i < lote.getTotalProductos(); i++){
            Producto productoActual = lote.getProductoEnPosicion(i);
            double precioActual = productoActual.getPrecio();

            if(precioActual < menorPrecio){
                menorPrecio = precioActual;
                productoMasBarato = productoActual;
            }

        }
        return productoMasBarato;
    }
}
