package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.CONFIGURACION.Propiedades;
import com.politecnicomalaga.CONTROLADOR.CambioVentana;
import com.politecnicomalaga.CONTROLADOR.OperadorInicioSesion;
import com.politecnicomalaga.MODELO.Credencial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Interfaz_InicioSesion {
    private JPanel Interfaz_InicioSesion;
    private JPanel panelInfo;
    private JTextField txtNombre;
    private JPanel panelInputs;
    private JPasswordField txtContraseña;
    private JButton btnValidar;
    private JLabel lblFalloInicioSesion;
    private JLabel lblNombre;
    private JLabel lblContraseña;
    private OperadorInicioSesion operadorInicioSesion;
    private Propiedades propiedades;

    public Interfaz_InicioSesion(JFrame frame) throws IOException {
        operadorInicioSesion = new OperadorInicioSesion();
        propiedades = new Propiedades();

        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String nombre = txtNombre.getText();
                String contraseña = "";
                char[] contraseñaChar = txtContraseña.getPassword();
                for(int i = 0; i < txtContraseña.getPassword().length; i++){
                    contraseña += contraseñaChar[i];
                }

                Credencial credencial = new Credencial(nombre,contraseña);
                if((credencial.getNombre() != null  && credencial.getContraseña() != null)){
                    Credencial credencialBBDD = operadorInicioSesion.validarCredencial(credencial);
                    if(credencialBBDD.isValidado()){
                        propiedades.setPropiedad("id",String.valueOf(credencialBBDD.getId()));
                        propiedades.setPropiedad("nombre",credencialBBDD.getNombre());
                        propiedades.setPropiedad("hash",credencialBBDD.getHash());
                        try {
                            propiedades.guardar();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        frame.dispose();
                        //Abrir ventanas de inicio de sesion
                        try {
                            CambioVentana cambioVentana = new CambioVentana();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else{
                        lblFalloInicioSesion.setText("Has fallado en el inicio de sesión");
                    }
                }
            }
        });
    }

    public Interfaz_InicioSesion(int algoSalioMal){

    }

    public void falloInicioSesion(){
        lblFalloInicioSesion.setText("Has introducido mal el usuario o la contraseña...");
    }

    public JPanel getPanel(){
        return Interfaz_InicioSesion;
    }
}
