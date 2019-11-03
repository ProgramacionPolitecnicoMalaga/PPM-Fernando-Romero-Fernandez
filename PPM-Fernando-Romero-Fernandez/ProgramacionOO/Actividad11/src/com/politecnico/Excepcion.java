package com.politecnico;

public class Excepcion extends Exception{

    public Excepcion(String message){
        super(message);
        System.out.println("Esta es la excepción");
    }
}
