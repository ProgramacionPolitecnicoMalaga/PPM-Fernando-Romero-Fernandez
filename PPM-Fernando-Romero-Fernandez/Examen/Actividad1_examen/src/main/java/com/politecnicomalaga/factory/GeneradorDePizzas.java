package com.politecnicomalaga.factory;

public class GeneradorDePizzas {

    public Interface_Pizza getPizzaPorNumero(int numero_pizza){
        switch (numero_pizza){
            case Pizza.ESTACIONES:
                return new Pizza4Estaciones();
            case Pizza.MARGARITA:
                return new PizzaMargarita();
            case Pizza.PROSCIUTTO:
                return new PizzaProsciutto();
            case Pizza.VEGANA:
                return new PizzaVegana();
        }
        return new PizzaProsciutto();
    }
}
