package com.politecnicomalaga.abstract_factory;

import com.politecnicomalaga.elementos.jugador.Jugador;
import com.politecnicomalaga.elementos.obstaculo.Obstaculo;
import com.politecnicomalaga.elementos.villano.Villano;

public interface ElementosFactory {
    public Jugador crearJugador();
    public Villano crearVillano();
    public Obstaculo crearObstaculo();
}
