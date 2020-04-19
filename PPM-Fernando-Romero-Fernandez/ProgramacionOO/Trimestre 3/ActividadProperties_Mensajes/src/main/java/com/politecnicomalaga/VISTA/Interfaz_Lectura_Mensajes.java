package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.CONTROLADOR.OperadorMensajes;
import com.politecnicomalaga.MODELO.Mensaje;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Interfaz_Lectura_Mensajes {
    private JPanel InterfazLecturaMensajes;
    private JPanel panelRemitentes;
    private JPanel panelMensajes;
    private JTextField txtTitulo;
    private JTextArea txtMensaje;
    private JList<Mensaje> jListMensajes;
    private DefaultListModel<Mensaje> modelMensajes;
    private OperadorMensajes operadorMensajes;

    public Interfaz_Lectura_Mensajes() throws IOException {
        operadorMensajes = new OperadorMensajes();
        modelMensajes = new DefaultListModel<>();
        modelMensajes = operadorMensajes.llenarModelMensajes(modelMensajes);

        jListMensajes.setModel(modelMensajes);

        jListMensajes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    Mensaje mensaje = jListMensajes.getSelectedValue();
                    txtTitulo.setText(mensaje.getTitulo());
                    txtMensaje.setText(mensaje.getCuerpo());
                }
            }
        });
    }

    public JPanel getPanel(){
        return InterfazLecturaMensajes;
    }
}
