package com.politecnicomalaga.modelo;

public class Empleado {

    private String nombre;
    private int edad, id;

    public Empleado(int id, String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
        this.id = id;
    }

    public Empleado(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
