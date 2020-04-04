package com.politecnicomalaga;

import com.politecnicomalaga.VISTA.InterfazPrincipal;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        System.out.println("¡Bienvenidos a nuestro sistema de validación de contraseñas!");
        JFrame frame = new JFrame("Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new InterfazPrincipal().getPanel());
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);
        System.out.println("¡Cargado correctamente! - Proyecto realizado por: Fernando Romero Fernández");

    }
}
