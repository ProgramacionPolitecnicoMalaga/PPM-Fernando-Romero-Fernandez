package com.politecnicomalaga.VIEWERS;

import com.politecnicomalaga.MODELO.Poblacion;
import com.politecnicomalaga.MODELO.Poblaciones;

import java.util.ArrayList;

public class TextDataViewer implements Interface_DataViewer{
    @Override
    public String mostrarContenido() {
        Poblaciones poblaciones = new Poblaciones();
        ArrayList<Poblacion> arrayPoblaciones = poblaciones.obtenerArrarListDePoblaciones();
        String text;
        text = "Listado de empadronamientos:\n";
        for(int i = 0; i < arrayPoblaciones.size(); i++){
            text += "\n";
            text += "    El total de empadronados en " + arrayPoblaciones.get(i).getAño() +" procedentes de " + arrayPoblaciones.get(i).getNacionalidad() + " fue de " + arrayPoblaciones.get(i).getNumeroEmpadronados()+ " personas.\n";
            text += "\n";
        }

        return text;
    }
}
