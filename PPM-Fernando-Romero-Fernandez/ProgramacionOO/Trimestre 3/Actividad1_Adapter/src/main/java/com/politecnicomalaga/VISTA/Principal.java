package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.MODELO.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class Principal {
    private JPanel pnlMain;
    private JButton btnInsertar;
    private JButton btnImprimir;
    private JButton btnBorrar;
    private JTable tablaPersonas;
    PersonasTableModel personasTableModel;
    List<Persona> listaPersonas;

    public Principal(List<Persona> listaPersonas){
        this.listaPersonas = listaPersonas;
        personasTableModel = new PersonasTableModel(listaPersonas);
        tablaPersonas.setModel(personasTableModel);

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personasTableModel.addRow();
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personasTableModel.removeRow(tablaPersonas.getSelectedRow());
            }
        });
        btnImprimir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(listaPersonas);
            }
        });

        tablaPersonas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE){
                    tablaPersonas.getCellEditor().stopCellEditing();
                    personasTableModel.removeRow(tablaPersonas.getSelectedRow());
                }
            }
        });
    }

    public JPanel getPanel() {
        return pnlMain;
    }
}
