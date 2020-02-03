package com.politecnico;

public class ProductPositionException extends ArrayIndexOutOfBoundsException {

    public ProductPositionException(String message, int posicionIntroducida){
        super(message);
        System.out.println(message + posicionIntroducida);
    }
}