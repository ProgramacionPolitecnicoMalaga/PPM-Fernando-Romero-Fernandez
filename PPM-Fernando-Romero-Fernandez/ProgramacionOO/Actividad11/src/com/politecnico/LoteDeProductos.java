package com.politecnico;

import java.util.concurrent.ExecutionException;

public class LoteDeProductos {
    private Producto[] productos;
    private final static int TAMANO = 100;
    private int totalProductos = 0;
    private SelectorDeMejorProducto selector;

    public LoteDeProductos(){
        productos = new Producto[TAMANO];
    }

    public void addProducto(Producto producto) throws Excepcion{
        if(totalProductos < productos.length){
            productos[totalProductos] = producto;
            totalProductos++;
        } else{
            throw new Excepcion("Has llegado al tamaño máximo");
        }
    }

    public int getTotalProductos(){
        return totalProductos;
    }

    public Producto getProductoEnPosicion(int i) throws Excepcion{
        if((i < totalProductos) && (i>=0)){
            return productos[i];
        } else{
            throw new Excepcion("No hay ningún elemento en esa posición");
        }
    }

    public void setSelector(SelectorDeMejorProducto selector){
        this.selector = selector;
    }

    public Producto getSellersChoice() throws Excepcion{
        if(selector != null){
            return selector.elegirMejorProducto(this);
        } else{
            throw new Excepcion("Ha habido un error al obtener la SellersChoice");
        }
    }

}
