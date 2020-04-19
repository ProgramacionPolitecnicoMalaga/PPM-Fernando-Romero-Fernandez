package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.CONFIGURACION.Propiedades;
import com.politecnicomalaga.CONTROLADOR.OperadorEscrituraMensajes;
import com.politecnicomalaga.MODELO.Credencial;
import com.politecnicomalaga.MODELO.Mensaje;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Interfaz_Escritura_Mensajes {
    private JPanel InterfazEscrituraMensajes;
    private JTextField txtTitulo;
    private JTextArea txtCuerpoMensaje;
    private JButton btnEnviar;
    private JComboBox cmbDestinatarios;
    private DefaultComboBoxModel comboBoxModel;
    private JPanel panelControl;
    private OperadorEscrituraMensajes operadorEscrituraMensajes;
    private Propiedades propiedades;

    public Interfaz_Escritura_Mensajes() throws IOException {
        propiedades = new Propiedades();
        operadorEscrituraMensajes = new OperadorEscrituraMensajes();
        comboBoxModel = operadorEscrituraMensajes.obtenerModelComboBox();
        llenarComboBox();

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Credencial credencial = (Credencial) cmbDestinatarios.getSelectedItem();
                int idOrigen = Integer.parseInt(propiedades.getPropiedad("id"));
                int idDestinatario = credencial.getId();
                String titulo = txtTitulo.getText();
                String cuerpo = txtCuerpoMensaje.getText();
                Mensaje mensaje = new Mensaje(idOrigen, idDestinatario,titulo,cuerpo);
                operadorEscrituraMensajes.enviarMensaje(mensaje);
            }
        });
    }

    public JPanel getPanel(){
        return InterfazEscrituraMensajes;
    }

    public void llenarComboBox(){
        cmbDestinatarios.setModel(comboBoxModel);
    }

    private void createUIComponents() {
        cmbDestinatarios = new JComboBox();
    }
}
