package com.politecnicomalaga.MODELO;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ItemPanel extends JPanel implements ListCellRenderer<Item> {

    private JLabel lblAutor;
    private JLabel lblFecha;
    private JLabel lblTema;
    private JTextArea txtAreaTexto;
    public ItemPanel(){
        //setMinimumSize(new Dimension(100,100));
        setLayout(new BorderLayout(10,10));

        lblAutor = new JLabel();
        lblFecha = new JLabel();
        lblTema = new JLabel();
        txtAreaTexto = new JTextArea();
        txtAreaTexto.setWrapStyleWord(true);
        txtAreaTexto.setLineWrap(true);

        Border margenAutorFecha = new EmptyBorder(10,10,0,10);
        Border margenTema = new EmptyBorder(10,20,0,20);
        Border margenTexto = new EmptyBorder(0,10,20,10);
        lblAutor.setBorder(margenAutorFecha);
        lblFecha.setBorder(margenAutorFecha);
        lblTema.setBorder(margenTema);
        txtAreaTexto.setBorder(margenTexto);


        add(lblAutor, BorderLayout.WEST);
        add(lblTema, BorderLayout.CENTER);
        add(lblFecha, BorderLayout.EAST);
        add(txtAreaTexto, BorderLayout.SOUTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Item> jList, Item item, int i, boolean isSelected, boolean cellHasFocus) {

        lblAutor.setText(item.getAutor());
        lblTema.setText(item.getTema());
        lblFecha.setText(item.getFecha().toString());
        txtAreaTexto.setText(item.getTexto());
        txtAreaTexto.setSize(jList.getWidth(),Short.MAX_VALUE);

        SelectorColorLabel selectorColorLabel = new SelectorColorLabel();
        lblTema.setForeground(selectorColorLabel.seleccionarColorPorContenido(lblTema.getText().toUpperCase()));

        if (isSelected){
            setBackground(Color.LIGHT_GRAY);
        } else {
            setBackground(Color.WHITE);
        }

        if (cellHasFocus){
            txtAreaTexto.setFont(new Font("SansSerif",Font.BOLD,14));
        } else {
            txtAreaTexto.setFont(new Font("SansSerif",Font.PLAIN,10));
        }

        return this;
    }
}
