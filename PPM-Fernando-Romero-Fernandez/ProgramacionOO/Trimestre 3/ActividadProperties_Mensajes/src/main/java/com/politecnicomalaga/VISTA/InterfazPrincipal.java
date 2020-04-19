package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.CONFIGURACION.Propiedades;
import com.politecnicomalaga.CONTROLADOR.OperadorCierreSesion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InterfazPrincipal {
    private JPanel panelIntercambio;
    private JMenu menuAcciones;
    private JMenuItem menuItemVerMensajes;
    private JMenuItem menuItemEscribirMensajes;
    private JMenuItem menuItemCerrarSesion;
    private JPanel InterfazPrincipal;
    private JLabel lblUsuarioActual;
    private OperadorCierreSesion operadorCierreSesion;
    private Propiedades propiedades;

    public InterfazPrincipal() throws IOException {

        propiedades = new Propiedades();
        lblUsuarioActual.setText(propiedades.getPropiedad("nombre"));

        operadorCierreSesion = new OperadorCierreSesion();

        Interfaz_Lectura_Mensajes panel1 = new Interfaz_Lectura_Mensajes();
        Interfaz_Escritura_Mensajes panel2 = new Interfaz_Escritura_Mensajes();

        panelIntercambio.add(panel1.getPanel(),"Lectura");
        panelIntercambio.add(panel2.getPanel(),"Escritura");


        menuItemVerMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pulsado Item Lectura");
                CardLayout layout = (CardLayout) panelIntercambio.getLayout();
                layout.show(panelIntercambio,"Lectura");
            }
        });

        menuItemEscribirMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pulsado Item Escritura");
                CardLayout layout = (CardLayout) panelIntercambio.getLayout();
                layout.show(panelIntercambio,"Escritura");
            }
        });

        menuItemCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Pulsado Item CerrarSesion");
                try {
                    operadorCierreSesion.cerrarSesion();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JPanel getPanel(){
        return InterfazPrincipal;
    }
}
