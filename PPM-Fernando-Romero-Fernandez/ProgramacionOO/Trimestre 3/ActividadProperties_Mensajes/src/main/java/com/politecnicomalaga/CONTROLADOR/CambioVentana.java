package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.CONFIGURACION.Propiedades;
import com.politecnicomalaga.VISTA.InterfazPrincipal;
import com.politecnicomalaga.VISTA.Interfaz_InicioSesion;

import javax.swing.*;
import java.io.IOException;

public class CambioVentana {

    private Propiedades propiedades;
    JFrame frame;

    public CambioVentana() throws IOException {
        propiedades = new Propiedades();
        System.out.println("¡Bienvenidos a nuestro sistema de mensajes!");
        System.out.println("Para seleccionar el contenido de un mensaje haz doble click sobre el remitente!");
        inicializar();
    }

    public void inicializar() throws IOException {
        frame = new JFrame("Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(!propiedades.getPropiedad("nombre").isEmpty() && !propiedades.getPropiedad("hash").isEmpty()){
            frame.setContentPane(new InterfazPrincipal().getPanel());
            frame.pack();
            frame.setSize(600, 600);
            frame.setVisible(true);
            System.out.println("¡Cargado correctamente! - Proyecto realizado por: Fernando Romero Fernández");
        } else{
            frame.setContentPane(new Interfaz_InicioSesion(frame).getPanel());
            frame.pack();
            frame.setSize(600, 600);
            frame.setVisible(true);
            System.out.println("¡Cargado correctamente! - Proyecto realizado por: Fernando Romero Fernández");
        }
    }

    public JFrame getFrame(){
        return frame;
    }

}
