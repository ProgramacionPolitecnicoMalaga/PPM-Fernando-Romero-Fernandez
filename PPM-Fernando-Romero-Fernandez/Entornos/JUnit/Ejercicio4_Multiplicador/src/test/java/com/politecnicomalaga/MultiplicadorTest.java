package com.politecnicomalaga;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicadorTest{

    Multiplicador multiplicador = new Multiplicador();

    @Test
    public void multiplicar() {

        int operadorX = 6;
        int operadorY = 5;

        int resultadoEsperado = 30;
        int resultadoObtenido = multiplicador.multiplicar(operadorX,operadorY);

        assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excepcionXMayorQue999() {
        multiplicador.multiplicar(1000,1);
    }
}