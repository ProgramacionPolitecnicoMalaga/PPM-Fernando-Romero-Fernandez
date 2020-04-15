package com.politecnicomalaga;

import com.politecnicomalaga.LECTOR.LectorENV;
import com.politecnicomalaga.VIEWERS.GeneradorDeViewers;
import com.politecnicomalaga.VIEWERS.Interface_DataViewer;

public class App {
    public static void main(String[] args) {
        LectorENV lectorENV = new LectorENV();
        GeneradorDeViewers generadorDeViewers = new GeneradorDeViewers();
        Interface_DataViewer dataViewer = generadorDeViewers.getViewerPorString(lectorENV.getDataType());
        System.out.println(dataViewer.mostrarContenido());
    }
}
