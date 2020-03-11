package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class DialogoModificarEmpleado extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtID;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private InterfazCRUD interfazCRUD;

    public DialogoModificarEmpleado(InterfazCRUD interfazCRUD, String idValue, String nombreValue, String edadValue) {
        this.interfazCRUD = interfazCRUD;
        this.txtID.setText(idValue);
        this.txtNombre.setText(nombreValue);
        this.txtEdad.setText(edadValue);
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
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public String getTxtID(){
        return txtID.getText();
    }

    public String getTxtNombre(){
        return txtNombre.getText();
    }

    public String getTxtEdad(){
        return txtEdad.getText();
    }
}
