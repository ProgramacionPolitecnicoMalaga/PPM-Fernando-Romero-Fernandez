package com.politecnicomalaga;

public class AvanceTarea {

    Tareas tareas = Tareas.getInstance();

    public void avanzar(int numeroDeTareas){
        tareas.cambiarUltimaTareaRealizada(tareas.ultimaTareaRealizada+numeroDeTareas);
        mostrarUltimaTareaRealizada();
    }

    public void mostrarUltimaTareaRealizada(){
        System.out.println(tareas.getUltimaTareaRealizada());
    }
}
