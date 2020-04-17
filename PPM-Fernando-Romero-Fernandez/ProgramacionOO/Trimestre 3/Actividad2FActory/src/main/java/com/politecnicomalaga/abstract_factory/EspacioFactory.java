package com.politecnicomalaga.abstract_factory;

import com.politecnicomalaga.elementos.jugador.Jugador;
import com.politecnicomalaga.elementos.jugador.USS_Enterpise;
import com.politecnicomalaga.elementos.obstaculo.Naves_Klingon;
import com.politecnicomalaga.elementos.obstaculo.Obstaculo;
import com.politecnicomalaga.elementos.villano.Khan;
import com.politecnicomalaga.elementos.villano.Villano;

public class EspacioFactory implements ElementosFactory {
    public Jugador crearJugador() {
        return new USS_Enterpise();
    }

    public Villano crearVillano() {
        return new Khan();
    }

    public Obstaculo crearObstaculo() {
        return new Naves_Klingon();
    }
}
