package com.politecnico;

public class LoteDeProductos {
    private Producto[] productos;
    private final static int TAMANO = 3;
    private int totalProductos = 0;
    private SelectorDeMejorProducto selector;

    public LoteDeProductos(){
        productos = new Producto[TAMANO];
    }

    public void addProducto(Producto producto) throws NullProductException, OutOfMaxProductsException{
        if(producto == null){
            throw new NullProductException("No se permiten valores nulos");
        }

        if(totalProductos < productos.length){
            productos[totalProductos] = producto;
            totalProductos++;
        } else{
            throw new OutOfMaxProductsException("Has llegado al tamaño máximo");
        }
    }

    public int getTotalProductos(){
        return totalProductos;
    }

    public Producto getProductoEnPosicion(int i) throws ProductPositionException{
        if((i < totalProductos) && (i>=0)){
            return productos[i];
        } else{
            throw new ProductPositionException("No hay ningún elemento en esa posición: ", i);
        }
    }

    public void setSelector(SelectorDeMejorProducto selector){
        this.selector = selector;
    }

    public Producto getSellersChoice() throws OutOfMaxProductsException {
        if(selector != null){
            return selector.elegirMejorProducto(this);
        } else{
            throw new OutOfMaxProductsException("Ha habido un error al obtener la SellersChoice");
        }
    }

}
