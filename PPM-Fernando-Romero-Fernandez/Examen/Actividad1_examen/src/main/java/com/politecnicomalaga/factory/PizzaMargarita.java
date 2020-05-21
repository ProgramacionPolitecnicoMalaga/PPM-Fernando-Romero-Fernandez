package com.politecnicomalaga.factory;

public class PizzaMargarita extends Pizza implements Interface_Pizza{
    @Override
    public String preparar() {
        return "Extender masa\n" +
                "Agregar salsa de tomate\n" +
                "Agregar mozzarella";
    }
}
