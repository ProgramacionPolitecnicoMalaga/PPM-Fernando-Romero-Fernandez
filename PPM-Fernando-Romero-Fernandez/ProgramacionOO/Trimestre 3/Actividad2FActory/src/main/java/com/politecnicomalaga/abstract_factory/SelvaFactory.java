package com.politecnicomalaga.abstract_factory;

import com.politecnicomalaga.elementos.jugador.Indiana;
import com.politecnicomalaga.elementos.jugador.Jugador;
import com.politecnicomalaga.elementos.obstaculo.Carcelero_Turco;
import com.politecnicomalaga.elementos.obstaculo.Obstaculo;
import com.politecnicomalaga.elementos.villano.Molaram;
import com.politecnicomalaga.elementos.villano.Villano;

public class SelvaFactory implements ElementosFactory {
    public Jugador crearJugador() {
        return new Indiana();
    }

    public Villano crearVillano() {
        return new Molaram();
    }

    public Obstaculo crearObstaculo() {
        return new Carcelero_Turco();
    }
}
