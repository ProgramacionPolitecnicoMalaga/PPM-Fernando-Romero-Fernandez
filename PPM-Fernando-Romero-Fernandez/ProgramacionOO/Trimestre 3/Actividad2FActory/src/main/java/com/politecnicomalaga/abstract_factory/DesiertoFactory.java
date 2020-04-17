package com.politecnicomalaga.abstract_factory;

import com.politecnicomalaga.elementos.jugador.Jugador;
import com.politecnicomalaga.elementos.jugador.Patton;
import com.politecnicomalaga.elementos.obstaculo.Obstaculo;
import com.politecnicomalaga.elementos.obstaculo.Tanques;
import com.politecnicomalaga.elementos.villano.Rommel;
import com.politecnicomalaga.elementos.villano.Villano;

public class DesiertoFactory implements ElementosFactory{
    public Jugador crearJugador() {
        return new Patton();
    }

    public Villano crearVillano() {
        return new Rommel();
    }

    public Obstaculo crearObstaculo() {
        return new Tanques();
    }
}
