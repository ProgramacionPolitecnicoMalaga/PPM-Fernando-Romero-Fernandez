package com.politecnicomalaga.VISTA;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class DialogoCrearItem extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtAutor;
    private JTextField txtTexto;
    private JPanel calendario;
    private JComboBox cmbTema;
    private JDateChooser dateChoos1;
    private InterfazCustomRenderer ventanaPrincipal;

    public DialogoCrearItem(InterfazCustomRenderer ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        dateChoos1 = new JDateChooser();
        dateChoos1.setDateFormatString("YYYY-MM-dd");
        calendario.add(dateChoos1);

        cmbTema.addItem("MANTENIMIENTO");
        cmbTema.addItem("IT");
        cmbTema.addItem("GENERAL");
        cmbTema.addItem("DESARROLLO");

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

    public String getTxtAutor(){
        return txtAutor.getText();
    }

    public String getTxtTexto(){
        return txtTexto.getText();
    }

    public String getTxtTema(){
        return cmbTema.getSelectedItem().toString();
    }

    public Date getFecha(){
        return dateChoos1.getDate();
    }

}
