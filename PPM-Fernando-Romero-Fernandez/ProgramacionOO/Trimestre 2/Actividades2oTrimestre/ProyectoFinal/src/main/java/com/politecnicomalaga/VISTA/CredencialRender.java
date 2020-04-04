package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.ALGORITMOS.Algoritmos;
import com.politecnicomalaga.MODELO.Credencial;

import javax.swing.*;
import java.awt.*;

public class CredencialRender implements ListCellRenderer<Credencial> {
    private JPanel CredencialRender;
    private JPanel pnlNombreYPass, pnlValidación, pnlHash, pnlAlgoritmo;
    private JLabel lblNombre, lblContraseña;
    private JLabel lblImgValidacion;
    private JLabel lblHash;
    private JLabel lblAlgortimo;
    private Algoritmos algoritmos;

    public CredencialRender(){
        algoritmos = new Algoritmos();
    }

    private void ajustarImagen(ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(25, 25,  Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        if (image != null) {
            lblImgValidacion.setIcon(imageIcon);
            lblImgValidacion.setText("");
        }
    }

    public Component getListCellRendererComponent(JList<? extends Credencial> jList, Credencial credencial, int i, boolean isSelected, boolean cellHasFocus) {
        lblNombre.setText(credencial.getNombre());
        lblContraseña.setText(credencial.getContraseña());
        if(credencial.isValidado()){
            ImageIcon imageIcon = new ImageIcon("./images/ok.png"); // load the image to a imageIcon
            ajustarImagen(imageIcon);
        } else{
            ImageIcon imageIcon = new ImageIcon("./images/failure.png");
            ajustarImagen(imageIcon);
        }
        lblHash.setText(credencial.getHash());
        lblAlgortimo.setText(algoritmos.getAlgoritmoPorNumero(credencial.getAlgoritmoUsado()));

        Color fondoPanel = Color.WHITE;
        if (credencial.getAlgoritmoUsado() == Algoritmos.MD5)
            fondoPanel = new Color(51,153,255);
        else if (credencial.getAlgoritmoUsado() == Algoritmos.SHA_512)
            fondoPanel = new Color(255,0,0);
        else if (credencial.getAlgoritmoUsado() == Algoritmos.B_CRYPT)
            fondoPanel = new Color(54, 255, 49);

        CredencialRender.setBackground(fondoPanel);
        pnlNombreYPass.setBackground(fondoPanel);
        pnlValidación.setBackground(fondoPanel);
        pnlHash.setBackground(fondoPanel);
        pnlAlgoritmo.setBackground(fondoPanel);

        return CredencialRender;
    }


}
