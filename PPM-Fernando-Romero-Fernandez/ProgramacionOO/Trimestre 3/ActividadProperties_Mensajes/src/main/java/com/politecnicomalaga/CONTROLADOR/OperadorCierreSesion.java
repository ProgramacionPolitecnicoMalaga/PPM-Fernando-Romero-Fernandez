package com.politecnicomalaga.CONTROLADOR;

import com.politecnicomalaga.CONFIGURACION.Propiedades;

import java.io.IOException;

public class OperadorCierreSesion {

    private Propiedades propiedades;

    public OperadorCierreSesion() throws IOException {
        propiedades = new Propiedades();
    }

    public void cerrarSesion() throws IOException {
        propiedades.setPropiedad("id","");
        propiedades.setPropiedad("nombre","");
        propiedades.setPropiedad("hash","");
        propiedades.guardar();
        System.exit(0);
    }
}
