package com.politecnicomalaga;

import com.politecnicomalaga.factory.*;

import java.util.Scanner;

public class App {

    private static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args){

        System.out.println("Introduce el tipo de pizza que quieres:\n" +
                "1. 4 Estaciones\n" +
                "2. Margarita\n" +
                "3. Prosciutto\n" +
                "4. Vegana\n" +
                "Opción: ");

        int tipoPizza = lectorTeclado.nextInt();

        GeneradorDePizzas generadorDePizzas = new GeneradorDePizzas();
        Interface_Pizza pizzaObtenida = generadorDePizzas.getPizzaPorNumero(tipoPizza);

        /*if (tipoPizza == Pizza.ESTACIONES)
            pizza = new Pizza4Estaciones();
        else if (tipoPizza == Pizza.MARGARITA)
            pizza = new PizzaMargarita();
        else if (tipoPizza == Pizza.PROSCIUTTO)
            pizza = new PizzaProsciutto();
        else if (tipoPizza == Pizza.VEGANA)
            pizza = new PizzaVegana();
        else
            pizza = new PizzaMargarita();
*/

        System.out.println("Pasos a seguir:");
        System.out.println(pizzaObtenida.preparar());
        System.out.println(pizzaObtenida.hornear());
        System.out.println(pizzaObtenida.cortar());
        System.out.println(pizzaObtenida.empaquetar());
    }
}
