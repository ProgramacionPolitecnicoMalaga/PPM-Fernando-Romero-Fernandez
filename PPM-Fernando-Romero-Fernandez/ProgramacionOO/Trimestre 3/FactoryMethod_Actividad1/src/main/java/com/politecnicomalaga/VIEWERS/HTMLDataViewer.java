package com.politecnicomalaga.VIEWERS;

import com.politecnicomalaga.MODELO.Poblacion;
import com.politecnicomalaga.MODELO.Poblaciones;

import java.util.ArrayList;

public class HTMLDataViewer implements Interface_DataViewer {
    @Override
    public String mostrarContenido() {
        Poblaciones poblaciones = new Poblaciones();
        ArrayList<Poblacion> arrayPoblaciones = poblaciones.obtenerArrarListDePoblaciones();
        String html;
        html = "<table>\n";
        html += "    <tr>\n";
        html += "       <th>Nacionalidad</th><th>Año</th><th>Total</th>\n";
        html += "    </tr>\n";
        for(int i = 0; i < arrayPoblaciones.size(); i++){
            html += "    <tr>\n";
            html += "       <td>"+ arrayPoblaciones.get(i).getNacionalidad() +"</td><td>"+ arrayPoblaciones.get(i).getAño() +"</td><td>"+ arrayPoblaciones.get(i).getNumeroEmpadronados() +"</td>\n";
            html += "    </tr>\n";
        }
        html += "</table>\n";

        return html;
    }
}
