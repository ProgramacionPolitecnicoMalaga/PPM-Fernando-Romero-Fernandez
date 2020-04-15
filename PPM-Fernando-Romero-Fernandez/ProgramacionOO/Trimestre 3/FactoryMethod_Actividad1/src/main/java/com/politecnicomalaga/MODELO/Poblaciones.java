package com.politecnicomalaga.MODELO;

import com.politecnicomalaga.LECTOR.LectorXML;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class Poblaciones {

    private ArrayList<Poblacion> arrayPoblaciones;

    public Poblaciones(){
        arrayPoblaciones = new ArrayList<>();
    }

    public ArrayList<Poblacion> obtenerArrarListDePoblaciones(){
        LectorXML lectorXML = new LectorXML("files/poblaciones.xml","row");
        NodeList nodeList = lectorXML.obtenerListaDeNodos();
        ArrayList<Element> arrayElementos = lectorXML.obtenerArrayDeElementos(nodeList);
        for(int i = 0; i < arrayElementos.size(); i++){
            String año = arrayElementos.get(i).getAttribute("Año");
            String nacionalidad = arrayElementos.get(i).getAttribute("Nacionalidad");
            int numeroEmpadronados = Integer.valueOf(arrayElementos.get(i).getAttribute("Número_de_empadronados"));
            arrayPoblaciones.add(new Poblacion(año,nacionalidad,numeroEmpadronados));
        }
        return arrayPoblaciones;
    }
}
