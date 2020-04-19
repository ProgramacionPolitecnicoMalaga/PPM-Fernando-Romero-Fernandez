package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.DAO.CredencialDAO;
import com.politecnicomalaga.DAO.MensajeDAO;
import com.politecnicomalaga.MODELO.Credencial;
import com.politecnicomalaga.MODELO.Mensaje;

import javax.swing.*;
import java.util.ArrayList;

public class OperadorEscrituraMensajes {

    private CredencialDAO credencialDAO;
    private MensajeDAO mensajeDAO;

    public OperadorEscrituraMensajes(){
        credencialDAO = new CredencialDAO();
        mensajeDAO = new MensajeDAO();
    }

    public void enviarMensaje(Mensaje mensaje){
        mensajeDAO.registrarMensaje(mensaje.getIdOrigen(),mensaje.getIdDestinatario(),mensaje.getTitulo(),mensaje.getCuerpo());
    }

    public DefaultComboBoxModel obtenerModelComboBox(){
        DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
        ArrayList<Credencial> arrayCredenciales = credencialDAO.buscar();
        defaultComboBoxModel.addAll(arrayCredenciales);
        return defaultComboBoxModel;
    }

}
