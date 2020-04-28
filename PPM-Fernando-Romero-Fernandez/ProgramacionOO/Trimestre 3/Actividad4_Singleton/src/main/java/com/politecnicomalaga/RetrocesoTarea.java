package com.politecnicomalaga;

public class RetrocesoTarea {

    Tareas tareas = Tareas.getInstance();

    public void retroceder(int numeroDeTareas){
        tareas.cambiarUltimaTareaRealizada(tareas.ultimaTareaRealizada-numeroDeTareas);
        mostrarUltimaTareaRealizada();
    }

    public void mostrarUltimaTareaRealizada(){
        System.out.println(tareas.getUltimaTareaRealizada());
    }
}
