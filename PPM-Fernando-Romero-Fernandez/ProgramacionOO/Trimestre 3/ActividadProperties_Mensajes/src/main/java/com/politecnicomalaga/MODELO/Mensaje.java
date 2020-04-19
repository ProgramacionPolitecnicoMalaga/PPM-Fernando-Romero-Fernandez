package com.politecnicomalaga.MODELO;

public class Mensaje {

    private String titulo, mensaje, nombre;
    private int idOrigen, idDestinatario;

    public Mensaje(int idOrigen, int idDestinatario, String titulo, String mensaje){
        this.idOrigen = idOrigen;
        this.idDestinatario = idDestinatario;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public Mensaje(int idOrigen, String nombre, String titulo, String mensaje){
        this.nombre = nombre;
        this.idOrigen = idOrigen;
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCuerpo() {
        return mensaje;
    }

    public int getIdOrigen() {
        return idOrigen;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
