package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.ALGORITMOS.GeneradorDeAlgoritmos;
import com.politecnicomalaga.ALGORITMOS.InterfazAlgoritmoConSalt;
import com.politecnicomalaga.DAO.CredencialDAO;
import com.politecnicomalaga.MODELO.Credencial;
import com.politecnicomalaga.VISTA.Interfaz_InicioSesion;

import java.security.NoSuchAlgorithmException;

public class OperadorInicioSesion {

    private GeneradorDeAlgoritmos generadorDeAlgoritmos;
    private CredencialDAO credencialDAO;
    private Interfaz_InicioSesion interfaz_inicioSesion;

    public OperadorInicioSesion(){
        credencialDAO = new CredencialDAO();
        interfaz_inicioSesion = new Interfaz_InicioSesion(0);
    }

    public Credencial validarCredencial(Credencial credencial){
        String nombre = credencial.getNombre();
        String contraseña = credencial.getContraseña();
        Credencial credencialBBDD = null;
        if(nombre != null && contraseña != null){
            credencialBBDD = credencialDAO.obtenerParaValidar(nombre);
        } else{
            interfaz_inicioSesion.falloInicioSesion();
        }
        String hashBBDD = credencialBBDD.getHash();
        String saltBBDD = credencialBBDD.getSalt();
        int algoritmoUsadoBBDD = credencialBBDD.getAlgoritmoUsado();
        credencialBBDD.setContraseña(contraseña);

        generadorDeAlgoritmos = new GeneradorDeAlgoritmos();

        try {
            InterfazAlgoritmoConSalt instanciaAlgoritmoAUsar = generadorDeAlgoritmos.getAlgoritmoByNumero(algoritmoUsadoBBDD);

            boolean validado = instanciaAlgoritmoAUsar.verificarSaltedPassword(contraseña,saltBBDD,hashBBDD);
            credencialBBDD.setValidado(validado);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return credencialBBDD;
    }
}
