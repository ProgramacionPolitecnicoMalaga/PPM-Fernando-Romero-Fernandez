package com.politecnicomalaga;

import java.util.ArrayList;

public class Tareas {

    private static Tareas instanciaTareas = null;

    int ultimaTareaRealizada = 0;
    private ArrayList<String> tareas;

    public Tareas(){
        tareas = new ArrayList<>();
    }

    public static Tareas getInstance(){
        if (instanciaTareas == null)
            instanciaTareas = new Tareas();
        return instanciaTareas;
    }

    public void addTarea(String nuevaTarea){
        tareas.add(nuevaTarea);
    }

    public String getUltimaTareaRealizada(){
        return tareas.get(ultimaTareaRealizada);
    }

    public void cambiarUltimaTareaRealizada(int posicionNuevaUltimaTarea){
        ultimaTareaRealizada = posicionNuevaUltimaTarea;
    }

    public ArrayList<String> getListaTareas(){
        return tareas;
    }

}
