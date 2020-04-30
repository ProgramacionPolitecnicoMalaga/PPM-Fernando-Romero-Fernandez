package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PodaExtremosTest {

    private ArrayList<Integer> listaNumeros;

    @Before
    public void setUp(){
        listaNumeros = new ArrayList<>();
        //{1,21,55,1,5,8,13,3,2,34}
        listaNumeros.add(1);
        listaNumeros.add(21);
        listaNumeros.add(55);
        listaNumeros.add(1);
        listaNumeros.add(5);
        listaNumeros.add(8);
        listaNumeros.add(13);
        listaNumeros.add(3);
        listaNumeros.add(2);
        listaNumeros.add(34);
    }


    @Test
    public void podarMasProximo() {
        PodaExtremos podaExtremos = new PodaExtremos();
        //La poda del número más próximo a 9 elimina la celda con el numero "8" de la lista.
        int numero = podaExtremos.podarMasProximo(9,listaNumeros);
        assertEquals(numero,8);
    }

    @Test
    public void podarMasProximo2() {
        PodaExtremos podaExtremos = new PodaExtremos();
        //La poda del número más próximo a 49 elimina la celda con el número "55" de la lista.
        int numero = podaExtremos.podarMasProximo(49,listaNumeros);
        assertEquals(numero,55);
    }


    @Test
    public void podarMasLejano() {
        PodaExtremos podaExtremos = new PodaExtremos();
        //La poda del número más lejano a 10 elimina la celda con el número 55 de la lista
        int numero = podaExtremos.podarMasLejano(10,listaNumeros);
        assertEquals(numero,55);
    }

    @Test
    public void podarMasLejano2() {
        PodaExtremos podaExtremos = new PodaExtremos();
        //La poda del número más lejano a 30 elimina la celda con el número "1" de la lista
        int numero = podaExtremos.podarMasLejano(30,listaNumeros);
        assertEquals(numero,1);
    }

    @After
    public void tearDown(){
        listaNumeros.clear();
    }
}