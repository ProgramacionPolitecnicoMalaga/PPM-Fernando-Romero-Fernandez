package com.politecnicomalaga.factory;

public class GeneradorDePizzas {

    public Interface_Pizza getPizzaPorString(int pizza){
        switch (pizza){
            case Pizza.ESTACIONES:
                return new PizzaProsciutto();
            case Pizza.MARGARITA:
                return new Pizza4Estaciones();
            case Pizza.PROSCIUTTO:
                return new PizzaMargarita();
            case Pizza.VEGANA:
                return new PizzaVegana();
        }
        return new PizzaProsciutto();
    }
}
