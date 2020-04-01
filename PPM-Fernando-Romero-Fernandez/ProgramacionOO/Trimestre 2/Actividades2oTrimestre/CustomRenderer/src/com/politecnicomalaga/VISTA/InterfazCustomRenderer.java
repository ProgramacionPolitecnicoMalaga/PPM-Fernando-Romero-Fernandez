package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.DAO.ItemDAO;
import com.politecnicomalaga.MODELO.Item;
import com.politecnicomalaga.MODELO.ItemPanel;
import com.politecnicomalaga.MODELO.HerramientaFechas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class InterfazCustomRenderer {
    private JPanel pnlMain;
    private JButton btnEliminar;
    private JButton btnNuevo;
    private InterfazCustomRenderer estaVentana;
    private HerramientaFechas herramientaFechas;
    private JList lstItems;
    private DefaultListModel<Item> listModel;
    private ArrayList<Item> arrayListItems;
    private ItemDAO itemDAO;

    public InterfazCustomRenderer(){
        estaVentana = this;
        herramientaFechas = new HerramientaFechas();
        listModel = new DefaultListModel<>();
        itemDAO = new ItemDAO();
        arrayListItems = itemDAO.buscar();

        for(int i = 0; i < arrayListItems.size(); i++){
            listModel.addElement(arrayListItems.get(i));
        }

        /*Item item1 = new Item("Juan Morales",LocalDate.of(2020,3,13),"Aplicado el parche #1128 desde Jonatino/patch-1. Resultado aparentemente correcto","IT");
        Item item2 = new Item("José Muñoz",LocalDate.of(2020,3,14),"Los equipos del despacho A33 están esperando la recogida. El equipo de mantenimiento ya lo sabe","DESARROLLO");
        Item item3 = new Item("Juan Morales",LocalDate.of(2020,3,14),"El servidor de aplicaciones del DC-2 está haciendo dando servicio intermitente. ¿Problema de la red?","MANTENIMIENTO");
        Item item4 = new Item("Redes Admin",LocalDate.of(2020,3,15),"Problema con el switch P-2 solucionado. Módulo SFP cambiado. El servidor de aplicaciones debería ir bien ya","GENERAL");
        Item item5 = new Item("Juan Morales",LocalDate.of(2020,3,16),"Necesitamos un servidor de despliegue para la aplicación de mensajería.","IT");
        Item item6 = new Item("José Muñoz",LocalDate.of(2020,3,16),"¿Qué configuración debería tener el servidor de despliegue para la aplicación de mensajería? Enviar a admin@seragul.es","GENERAL");

        DefaultListModel<Item> lstModel = new DefaultListModel<>();
        lstModel.addElement(item1);
        lstModel.addElement(item2);
        lstModel.addElement(item3);
        lstModel.addElement(item4);
        lstModel.addElement(item5);
        lstModel.addElement(item6);*/


        lstItems.setModel(listModel);
        lstItems.setCellRenderer(new ItemPanel());

        lstItems.setFixedCellWidth(pnlMain.getWidth());

        lstItems.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Estiramos la celda a 1000 px de altura
                lstItems.setFixedCellHeight(1000);
                // Asignamos el valor -1 para que se recalcule la altura
                lstItems.setFixedCellHeight(-1);
            }
        });

        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DialogoCrearItem dialogoCrearItem = new DialogoCrearItem(estaVentana);
                dialogoCrearItem.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogoCrearItem.pack();
                dialogoCrearItem.setVisible(true);

                itemDAO = new ItemDAO();
                itemDAO.insertar(dialogoCrearItem.getTxtAutor(),dialogoCrearItem.getTxtTema(),dialogoCrearItem.getTxtTexto(),herramientaFechas.obtenerFechaString(dialogoCrearItem.getFecha()));

                Date date = dialogoCrearItem.getFecha();
                Item item = new Item(dialogoCrearItem.getTxtAutor(), herramientaFechas.obtenerLocalDate(date),dialogoCrearItem.getTxtTexto(),dialogoCrearItem.getTxtTema());
                listModel.addElement(item);
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = lstItems.getSelectedIndex();
                Item item = (Item) lstItems.getSelectedValue();

                listModel.removeElementAt(index);

                itemDAO = new ItemDAO();
                itemDAO.borrar(item);
            }
        });
    }

    public Container getPanel() {
        return pnlMain;
    }

}
