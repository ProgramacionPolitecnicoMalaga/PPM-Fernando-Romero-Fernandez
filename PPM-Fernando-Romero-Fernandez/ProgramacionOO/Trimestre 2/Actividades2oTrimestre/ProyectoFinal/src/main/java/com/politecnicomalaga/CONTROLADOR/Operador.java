package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.ALGORITMOS.GeneradorDeAlgoritmos;
import com.politecnicomalaga.ALGORITMOS.InterfazAlgoritmoConSalt;
import com.politecnicomalaga.DAO.CredencialDAO;
import com.politecnicomalaga.MODELO.Credencial;
import com.politecnicomalaga.VISTA.InterfazPrincipal;

import javax.swing.*;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;

public class Operador {

    private GeneradorDeAlgoritmos generadorDeAlgoritmos;
    private CredencialDAO credencialDAO;
    private InterfazPrincipal interfazPrincipal;

    public Operador(){
        credencialDAO = new CredencialDAO();
        interfazPrincipal = new InterfazPrincipal(0);
    }

    public void registrarCredencial(Credencial credencial){
        String nombre = credencial.getNombre();
        String contraseña = credencial.getContraseña();
        int algoritmoUsado = credencial.getAlgoritmoUsado();

        generadorDeAlgoritmos = new GeneradorDeAlgoritmos();

        try {
            InterfazAlgoritmoConSalt instanciaAlgoritmoAUsar = generadorDeAlgoritmos.getAlgoritmoByNumero(algoritmoUsado);
            String miSaltGenerada = instanciaAlgoritmoAUsar.getSalt();
            String hashSalted = instanciaAlgoritmoAUsar.getSaltedPasswordHash(contraseña,miSaltGenerada);

            credencialDAO.registrar(nombre,algoritmoUsado,hashSalted,miSaltGenerada);

        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }

    public Credencial validarCredencial(Credencial credencial){
        String nombre = credencial.getNombre();
        String contraseña = credencial.getContraseña();
        Credencial credencialBBDD = null;
        if(nombre != null && contraseña != null){
            credencialBBDD = credencialDAO.obtenerParaValidar(nombre);
        } else{
            interfazPrincipal.operacionIncorrecta();
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

    public void borrarUsuario(String nombreDeUsuario){
        credencialDAO.borrarUsuario(nombreDeUsuario);
    }

    public DefaultListModel llenarModelUsuarios(DefaultListModel modelUsuarios){
        ArrayList<Credencial> arrayUsuarios;
        arrayUsuarios = credencialDAO.buscar();
        for(int i = 0; i < arrayUsuarios.size(); i++){
            modelUsuarios.addElement(arrayUsuarios.get(i).getNombre());
        }
        return modelUsuarios;
    }
}
