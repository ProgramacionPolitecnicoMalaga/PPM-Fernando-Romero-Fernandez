package com.politecnicomalaga;

import com.politecnicomalaga.MODELO.Persona;
import com.politecnicomalaga.VISTA.Principal;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Persona> listaPersonas = crearLista();
        JFrame frame = new JFrame("Personas");
        frame.setContentPane(new Principal(listaPersonas).getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static List<Persona> crearLista() {
        List<Persona> listaPersonas = new ArrayList<>(){
            @Override
            public String toString() {
                String resultado = "\n-----------------------------------";
                resultado += "\nEstado de la lista";
                for (Persona persona: this)
                    resultado += "\n" + persona.toString();
                return resultado;

            }
        };

        listaPersonas.add(new Persona("Fernando","Romero",20));
        listaPersonas.add(new Persona("Juan","Gomez",23));
        listaPersonas.add(new Persona("Raul","Pacheco",19));
        return listaPersonas;
    }
}
