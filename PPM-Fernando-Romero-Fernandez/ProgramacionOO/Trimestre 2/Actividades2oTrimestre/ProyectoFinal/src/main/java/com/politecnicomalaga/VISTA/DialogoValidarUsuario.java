package com.politecnicomalaga.VISTA;

import javax.swing.*;
import java.awt.event.*;

public class DialogoValidarUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JPasswordField txtContraseña;
    private DataTransfer datos;

    public DialogoValidarUsuario(DataTransfer datos) {
        this.datos = datos;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        datos.put("nombre",txtNombre.getText());

        String contraseña = "";
        char[] contraseñaChar = txtContraseña.getPassword();
        for(int i = 0; i < txtContraseña.getPassword().length; i++){
            contraseña += contraseñaChar[i];
        }

        datos.put("contraseña",contraseña);
        datos.put("algoritmoUsado",0);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

}
