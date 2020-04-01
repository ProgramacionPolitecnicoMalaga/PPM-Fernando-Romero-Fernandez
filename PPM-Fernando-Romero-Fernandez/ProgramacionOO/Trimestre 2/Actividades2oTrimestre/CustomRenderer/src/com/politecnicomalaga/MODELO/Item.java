package com.politecnicomalaga.MODELO;

import java.time.LocalDate;

public class Item {
    private int id;
    private String autor, texto, tema;
    private LocalDate fecha;

    public Item(String autor, LocalDate fecha, String texto, String tema) {
        this.autor = autor;
        this.fecha = fecha;
        this.tema = tema;
        this.texto = texto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTema(){
        return tema;
    }

    public void setTema(String tema){
        this.tema = tema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
