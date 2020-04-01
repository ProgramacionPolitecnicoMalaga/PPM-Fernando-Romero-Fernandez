package com.politecnicomalaga.MODELO;

import java.awt.*;

public class SelectorColorLabel {

    public SelectorColorLabel(){}

    public Color seleccionarColorPorContenido(String contenidoLabel){
        switch (contenidoLabel){
            case "DESARROLLO": return Color.BLUE;
            case "IT": return Color.GREEN;
            case "GENERAL": return Color.GRAY;
            case "MANTENIMIENTO": return Color.ORANGE;
        }
        return null;
    }
}
