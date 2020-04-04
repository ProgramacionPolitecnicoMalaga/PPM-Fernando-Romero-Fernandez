package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.ALGORITMOS.Algoritmos;

import javax.swing.*;
import java.awt.event.*;

public class DialogoRegistrarUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JPasswordField txtContraseña;
    private JComboBox cmbAlgoritmos;
    private DataTransfer datos;

    public DialogoRegistrarUsuario(DataTransfer datos) {
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

        if (cmbAlgoritmos.getSelectedItem().toString().equals("MD5"))
            datos.put("algoritmoUsado", Algoritmos.MD5);
        else if (cmbAlgoritmos.getSelectedItem().toString().equals("SHA_512"))
            datos.put("algoritmoUsado", Algoritmos.SHA_512);
        else if (cmbAlgoritmos.getSelectedItem().toString().equals("B_CRYPT"))
            datos.put("algoritmoUsado", Algoritmos.B_CRYPT);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void createUIComponents(){
        cmbAlgoritmos = new JComboBox();
        cmbAlgoritmos.addItem("MD5");
        cmbAlgoritmos.addItem("SHA_512");
        cmbAlgoritmos.addItem("B_CRYPT");
    }
}
