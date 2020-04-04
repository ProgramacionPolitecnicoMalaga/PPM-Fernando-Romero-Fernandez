package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.MODELO.Credencial;

public class DataTransferACredencial {
    public static Credencial transformarParaRegistro(DataTransfer datos) {
        String nombre = (String) datos.get("nombre");
        String contraseña = (String) datos.get("contraseña");
        int algoritmoUsado = 0;
        try{
            algoritmoUsado = (Integer) datos.get("algoritmoUsado");

        } catch (NullPointerException e){

        }

        return new Credencial(nombre,contraseña,algoritmoUsado);

    }

    public static Credencial transformarParaValidacion(DataTransfer datos) {
        String nombre = (String) datos.get("nombre");
        String contraseña = (String) datos.get("contraseña");

        return new Credencial(nombre,contraseña);

    }
}
