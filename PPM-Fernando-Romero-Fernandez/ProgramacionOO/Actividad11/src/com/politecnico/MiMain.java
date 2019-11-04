package com.politecnico;

public class MiMain {
    public static void main(String[] args) throws OutOfMaxProductsException {

        LoteDeProductos loteDeProductos = new LoteDeProductos();

        Producto pd1 = new Producto("Peine",2.50,3.3);
        Producto pd2 = new Producto("Secador",50,5);
        Producto pd3 = new Producto("Toalla",30,2.9);
        //Producto pd4 = new Producto("Toalla2",30,2.9);



        loteDeProductos.addProducto(pd1);
        loteDeProductos.addProducto(pd2);
        //loteDeProductos.addProducto(pd3);
        //loteDeProductos.addProducto(pd4);
        loteDeProductos.addProducto(null);


        SMejorPrecio criterioPrecio = new SMejorPrecio();
        loteDeProductos.setSelector(criterioPrecio);
        System.out.println(loteDeProductos.getSellersChoice());

        SMejorValoracion criterioValor = new SMejorValoracion();
        loteDeProductos.setSelector(criterioValor);
        System.out.println(loteDeProductos.getSellersChoice());

        SMejorRelacion criterioRelacion = new SMejorRelacion();
        loteDeProductos.setSelector(criterioRelacion);
        System.out.println(loteDeProductos.getSellersChoice());

        //loteDeProductos.getProductoEnPosicion(1000);

    }
}
