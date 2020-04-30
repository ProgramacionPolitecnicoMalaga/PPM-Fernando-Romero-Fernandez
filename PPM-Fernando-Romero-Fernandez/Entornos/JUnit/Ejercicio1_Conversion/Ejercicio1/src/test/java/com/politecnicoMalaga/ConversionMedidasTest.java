package com.politecnicoMalaga;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionMedidasTest {

    ConversionMedidas conversionMedidas = new ConversionMedidas();

    @Test
    public void inchACm() {
        double resultadoEsperado = 2.54;
        double resultadoObtenido = conversionMedidas.inchACm(1);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);

        //--------------------------------------------------------------

        resultadoEsperado = 30.48;
        resultadoObtenido = conversionMedidas.inchACm(12);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);

        //--------------------------------------------------------------

        resultadoEsperado = 0;
        resultadoObtenido = conversionMedidas.inchACm(0);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);
    }


    @Test
    public void cmAInch() {
        double resultadoEsperado = 4.72441;
        double resultadoObtenido = conversionMedidas.cmAInch(12);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);

        //--------------------------------------------------------------

        resultadoEsperado = 0;
        resultadoObtenido = conversionMedidas.cmAInch(0);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);

        //--------------------------------------------------------------

        resultadoEsperado = 0.1968;
        resultadoObtenido = conversionMedidas.cmAInch(0.5);

        assertEquals(resultadoEsperado, resultadoObtenido,0.001);
    }
}