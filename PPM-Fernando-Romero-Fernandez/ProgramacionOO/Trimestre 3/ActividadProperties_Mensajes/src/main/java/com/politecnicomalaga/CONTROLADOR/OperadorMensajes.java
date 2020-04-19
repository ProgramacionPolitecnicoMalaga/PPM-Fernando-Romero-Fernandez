package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.CONFIGURACION.Propiedades;
import com.politecnicomalaga.DAO.MensajeDAO;
import com.politecnicomalaga.MODELO.Mensaje;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class OperadorMensajes {

    private MensajeDAO mensajeDAO;
    private Propiedades propiedades;

    public OperadorMensajes() throws IOException {
        mensajeDAO = new MensajeDAO();
        propiedades = new Propiedades();
    }

    public DefaultListModel llenarModelMensajes(DefaultListModel modelMensajes){
        int id = Integer.parseInt(propiedades.getPropiedad("id"));
        System.out.println(id);
        ArrayList<Mensaje> arrayMensajes = mensajeDAO.obtenerListaMensajesDeUnUsuarios(id);
        for(int i = 0; i < arrayMensajes.size(); i++){
            modelMensajes.addElement(arrayMensajes.get(i));
        }
        return modelMensajes;
    }


}
