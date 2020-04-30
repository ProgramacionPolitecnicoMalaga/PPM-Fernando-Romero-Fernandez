package com.politecnicomalga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarreraTest {

    Carrera carrera;

    @Before
    public void setUp(){
        carrera = new Carrera();
    }

    @Test
    public void listadoParticipantesEsNull_NoContieneParticipantes() {
        //1. Sin participantes la lista es null.
        assertNull(carrera.listaParticipantes);
    }

    @Test
    public void listadoParticipantesNoEsNull_DespuesDeAñadirUnParticipante() {
        //2. Después de añadir un participante la lista no es null
        carrera.añadirParticipante("Fernando");
        assertNotNull(carrera.listaParticipantes);
    }

    @Test
    public void listadoParticipantesPermiteAñadir_4ParticipantesDistintos() {
        //3. Insertar 4 participantes diferentes
        carrera.añadirParticipante("Fernando");
        carrera.añadirParticipante("Juan");
        carrera.añadirParticipante("Alberto");
        carrera.añadirParticipante("Alex");
        assertEquals(4,carrera.obtenerTotalParticipantes());
    }

    @Test
    public void insertarParticipanteRepetido() {
        //4.Insertar 1 participante repetido BDD
        //given
        carrera.añadirParticipante("Fernando");
        carrera.añadirParticipante("Juan");
        carrera.añadirParticipante("Alberto");
        carrera.añadirParticipante("Alex");

        //then
        assertFalse(carrera.añadirParticipante("Fernando"));
        assertEquals(4,carrera.obtenerTotalParticipantes());
    }

    @Test
    public void objetosIguales() {
        //5.wick y el participante insertado es el mismo.
        //given
        String fernando = "Fernando";
        carrera.añadirParticipante(fernando);
        String wick = "John Wick";

        //when
        carrera.setPosicion("John Wick",1);

        //then
        assertEquals(wick,carrera.getParticipantePorPosicion(1));
    }

    @Test
    public void cloneCarrera() {
        //6. obtenerListadoParticipantes y clone carrera son distintos
        //No sé porque dice que es el mismo objeto si le estoy haciendo la copia
        //given
        carrera.añadirParticipante("Fernando");
        List<String> listaOriginal = carrera.obtenerListadoParticipantes();
        List<String> listaCopia = carrera.cloneCarrera();

        System.out.println(listaCopia.hashCode());
        System.out.println(listaOriginal.hashCode());
        //then
        assertNotEquals(listaCopia.hashCode(),listaOriginal.hashCode());
    }

    @Test
    public void carreraTieneElMismoArray_AlPrincipioY_AlFinalDeLaCarrera(){
        //7.
        //given
        carrera.añadirParticipante("Fernando");
        carrera.añadirParticipante("Juan");
        carrera.añadirParticipante("Alberto");
        carrera.añadirParticipante("Alex");
        List<String> listaAntesDe = carrera.obtenerListadoParticipantes();

        //when
        carrera.setPosicion("Alex",0);
        carrera.setPosicion("Juan",2);
        List<String> listaDespuesDe = carrera.obtenerListadoParticipantes();


        //then
        assertArrayEquals(listaAntesDe.toArray(),listaDespuesDe.toArray());
    }

}