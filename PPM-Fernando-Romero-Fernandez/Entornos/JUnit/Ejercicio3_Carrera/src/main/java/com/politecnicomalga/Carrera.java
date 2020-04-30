package com.politecnicomalga;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    ArrayList<String> listaParticipantes;

    public boolean añadirParticipante(String nombreParticipante){
        if(listaParticipantes == null){
            listaParticipantes = new ArrayList<>();
        }
        if(!listaParticipantes.contains(nombreParticipante)){
            return listaParticipantes.add(nombreParticipante);
        }
        return false;
    }

    public List<String> obtenerListadoParticipantes(){
        if(!listaParticipantes.isEmpty()){
            return listaParticipantes;
        }
        return null;
    }

    public int obtenerTotalParticipantes(){
        return listaParticipantes.size();
    }

    public List<String> cloneCarrera(){
        ArrayList<String> listaClonada = (ArrayList<String>) listaParticipantes.clone();

        return listaClonada;
    }

    public boolean setPosicion(String nombreParticipante, int posicionDestino){
        if(listaParticipantes.contains(nombreParticipante)){
            listaParticipantes.remove(nombreParticipante);
            listaParticipantes.add(posicionDestino,nombreParticipante);
            return true;
            }


        if(!listaParticipantes.contains(nombreParticipante)){
            listaParticipantes.add(posicionDestino,nombreParticipante);
            return true;
        }
        return false;
    }

    public String getParticipantePorPosicion(int posicion){
        return listaParticipantes.get(posicion);
    }

}
