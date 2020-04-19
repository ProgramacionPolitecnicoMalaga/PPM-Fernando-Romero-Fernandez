package com.politecnicomalaga.MODELO;

public class Credencial {

    private String nombre, contraseña, hash, salt;
    private int algoritmoUsado, id;
    private boolean validado;

    public Credencial(String nombre, int algoritmoUsado){
        this.nombre = nombre;
        this.algoritmoUsado = algoritmoUsado;
    }

    public Credencial(String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public Credencial(int id, String nombre, int algoritmoUsado){
        this.id = id;
        this.nombre = nombre;
        this.algoritmoUsado = algoritmoUsado;
    }

    public Credencial(String nombre, String contraseña, int algoritmoUsado){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.algoritmoUsado = algoritmoUsado;
    }

    public Credencial(int id,String nombre, String hash, String salt, int algoritmoUsado){
        this.id = id;
        this.nombre = nombre;
        this.hash = hash;
        this.salt = salt;
        this.algoritmoUsado = algoritmoUsado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAlgoritmoUsado() {
        return algoritmoUsado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getHash() {
        return hash;
    }

    public String getSalt() {
        return salt;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
