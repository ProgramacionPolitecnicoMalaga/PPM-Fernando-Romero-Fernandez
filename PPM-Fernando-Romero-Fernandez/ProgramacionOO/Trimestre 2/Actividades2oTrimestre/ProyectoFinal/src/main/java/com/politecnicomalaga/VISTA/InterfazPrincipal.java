package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.CONTROLADOR.Operador;
import com.politecnicomalaga.MODELO.Credencial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazPrincipal {
    private JPanel InterfazPrincipal, panelBotones;
    private JScrollPane panelUsuarios, panelInfo;
    private JButton btnValidar, btnRegistrar, btnBorrar;
    private JList<String> JListUsuarios;
    private JList listRenderers;
    private DefaultListModel<Credencial> modeloCredencialesValidadas;
    private DefaultListModel<String> modelUsuariosPnlIzquierdo;
    private Operador operador;

    public InterfazPrincipal(int AlgoSalioMal){}

    public InterfazPrincipal(){
        operador = new Operador();

        modeloCredencialesValidadas = new DefaultListModel<>();
        modelUsuariosPnlIzquierdo = new DefaultListModel<>();

        modelUsuariosPnlIzquierdo = operador.llenarModelUsuarios(modelUsuariosPnlIzquierdo);
        JListUsuarios.setModel(modelUsuariosPnlIzquierdo);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataTransfer datos = new DataTransfer();
                DialogoRegistrarUsuario dialogoRegistrarUsuario = new DialogoRegistrarUsuario(datos);
                dialogoRegistrarUsuario.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogoRegistrarUsuario.pack();
                dialogoRegistrarUsuario.setVisible(true);

                Credencial credencial = DataTransferACredencial.transformarParaRegistro(datos);
                if(credencial.getNombre() != null && credencial.getContraseña() != null & credencial.getAlgoritmoUsado() != 0){
                    operador.registrarCredencial(credencial);
                    modelUsuariosPnlIzquierdo.addElement(credencial.getNombre());
                    JListUsuarios.setModel(modelUsuariosPnlIzquierdo);
                    JOptionPane.showMessageDialog(null, "¡Usuario añadido!");
                } else{
                    operacionIncorrecta();
                }

            }
        });
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataTransfer datos = new DataTransfer();
                DialogoValidarUsuario dialogoValidarUsuario = new DialogoValidarUsuario(datos);
                dialogoValidarUsuario.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogoValidarUsuario.pack();
                dialogoValidarUsuario.setVisible(true);

                Credencial credencial = DataTransferACredencial.transformarParaValidacion(datos);
                if((credencial.getNombre() != null  && credencial.getContraseña() != null)){
                    Credencial credencialBBDD = operador.validarCredencial(credencial);
                    modeloCredencialesValidadas.addElement(credencialBBDD);
                    listRenderers.setModel(modeloCredencialesValidadas);
                    listRenderers.setCellRenderer(new CredencialRender());
                } else if(credencial.getAlgoritmoUsado() == 0){
                    operacionIncorrecta();
                }
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String usuarioSeleccionado = JListUsuarios.getSelectedValue();
                int indexDelUsuarioSeleccionado = JListUsuarios.getSelectedIndex();
                if(usuarioSeleccionado != null){
                    operador.borrarUsuario(usuarioSeleccionado);
                    modelUsuariosPnlIzquierdo.removeElementAt(indexDelUsuarioSeleccionado);
                    JOptionPane.showMessageDialog(null, "¡Usuario borrado!");
                } else{
                    usuarioSinSeleccionar();
                }
            }
        });
    }

    public void usuarioSinSeleccionar(){
        JOptionPane.showMessageDialog(null, "¡Selecciona un usuario antes de darle al botón de borrar!",null,JOptionPane.ERROR_MESSAGE);
    }

    public void operacionIncorrecta(){
        JOptionPane.showMessageDialog(null, "¡Algo ha salido mal :(!",null,JOptionPane.ERROR_MESSAGE);
    }

    public JPanel getPanel(){
        return InterfazPrincipal;
    }

}
