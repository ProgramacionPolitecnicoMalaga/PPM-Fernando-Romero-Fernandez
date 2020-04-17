package com.politecnicomalaga;

import com.politecnicomalaga.abstract_factory.DesiertoFactory;
import com.politecnicomalaga.abstract_factory.ElementosFactory;
import com.politecnicomalaga.abstract_factory.EspacioFactory;
import com.politecnicomalaga.abstract_factory.SelvaFactory;
import com.politecnicomalaga.elementos.jugador.Jugador;
import com.politecnicomalaga.elementos.obstaculo.Obstaculo;
import com.politecnicomalaga.elementos.villano.Villano;

import java.util.Scanner;

public class SelectorJuego {
    public static ElementosFactory elementosFactory;

    public static void main(String[] args) {
        inicializar();
        Jugador jugador = elementosFactory.crearJugador();
        Villano villano = elementosFactory.crearVillano();
        Obstaculo obstaculo = elementosFactory.crearObstaculo();

        System.out.println("Se ha generado el jugador: "+ jugador.getNombreJugador());
        System.out.println("Se ha generado el villano: "+ villano.getNombreVillano());
        System.out.println("Se ha generado el jugador: "+ obstaculo.getNombreObstaculo());
    }


    private static void inicializar(){
        Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Selecciona un escenario: 1)SELVA, 2)DESIERTO O 3)ESPACIO (Inserta número)");
        int escenarioElegido = lectorTeclado.nextInt();

        switch (escenarioElegido){
            case 1:
                elementosFactory = new DesiertoFactory();
                break;
            case 2:
                elementosFactory = new SelvaFactory();
                break;
            case 3:
                elementosFactory = new EspacioFactory();
                break;
            default:
                throw new IllegalArgumentException("No existe ese escenario");
        }
    }
}
