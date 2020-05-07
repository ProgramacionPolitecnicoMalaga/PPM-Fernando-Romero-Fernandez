package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.intThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccionSensorTest {
    private static MatrizSensores matrizSensores;

    @Before
    public void setUp() throws Exception {
        matrizSensores = mock(MatrizSensores.class);
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.NO_INICIADO)))).thenThrow(new IllegalStateException("Error"));
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.ESTADO_VACIO)))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.ESTADO_CASI_VACIO)))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.ESTADO_MITAD)))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.ESTADO_CASI_LLENO)))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(new GrupoSensores(Sensor.ESTADO_LLENO)))).thenReturn(Sensor.ESTADO_LLENO);
    }

    @Test
    public void evaluarSensoresEnDemandaBaja(){
        //given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_BAJA);

        //when numeroSensor (0-9) devuelve ACCION_REVISION
        int resultadoEsperado = getAccionEsperada(5,AccionSensor.DEMANDA_BAJA);
        int resultadoObtenido = AccionSensor.ACCION_REVISION;

        //then
        assertEquals(resultadoEsperado, resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (10-19) (ESTADO_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(12,AccionSensor.DEMANDA_BAJA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (20-29) (ESTADO_CASI_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(23,AccionSensor.DEMANDA_BAJA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (30-60) devuelve ACCION_INNECESARIA
        resultadoEsperado = getAccionEsperada(50,AccionSensor.DEMANDA_BAJA);
        resultadoObtenido = AccionSensor.ACCION_INNECESARIA;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void evaluarSensoresEnDemandaMedia(){
        //given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_MEDIA);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (0-9) (ESTADO_NO_INICIADO) devuelve ACCION_REVISION
        int resultadoEsperado = getAccionEsperada(6,AccionSensor.DEMANDA_MEDIA);
        int resultadoObtenido = AccionSensor.ACCION_REVISION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (10-19) (ESTADO_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(12,AccionSensor.DEMANDA_MEDIA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (20-29) (ESTADO_CASI_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(23,AccionSensor.DEMANDA_MEDIA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (30-39) (ESTADO_MEDIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(33,AccionSensor.DEMANDA_MEDIA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (40-59) (ESTADO_CASI_LLENO) devuelve ACCION_INNECESARIA
        resultadoEsperado = getAccionEsperada(50,AccionSensor.DEMANDA_MEDIA);
        resultadoObtenido = AccionSensor.ACCION_INNECESARIA;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);
    }

    @Test
    public void evaluarSensoresEnDemandaAlta(){
        //given
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_ALTA);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (0-9) (ESTADO_NO_INICIADO) devuelve ACCION_REVISION
        int resultadoEsperado = getAccionEsperada(6,AccionSensor.DEMANDA_ALTA);
        int resultadoObtenido = AccionSensor.ACCION_REVISION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (10-19) (ESTADO_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(12,AccionSensor.DEMANDA_ALTA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (20-29) (ESTADO_CASI_VACIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(23,AccionSensor.DEMANDA_ALTA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (30-39) (ESTADO MEDIO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(33,AccionSensor.DEMANDA_ALTA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (40-49) (ESTADO CASI LLENO) devuelve ACCION_REPOSICION
        resultadoEsperado = getAccionEsperada(43,AccionSensor.DEMANDA_ALTA);
        resultadoObtenido = AccionSensor.ACCION_REPOSICION;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);

        //-----------------------------------------------------------------------------------

        //when numero_sensor (50-59) devuelve ACCION_INNECESARIA
        resultadoEsperado = getAccionEsperada(52,AccionSensor.DEMANDA_ALTA);
        resultadoObtenido = AccionSensor.ACCION_INNECESARIA;

        //then
        assertEquals(resultadoEsperado,resultadoObtenido);
    }

    public int getAccionEsperada(int numeroSensor, int nivelDemanda){
        try{
            int estadoSensor = matrizSensores.getEstadoSensor(numeroSensor);

            if (nivelDemanda == AccionSensor.DEMANDA_BAJA) {
                switch (estadoSensor) {
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                        return AccionSensor.ACCION_REPOSICION;
                    default:
                        return AccionSensor.ACCION_INNECESARIA;
                }
            } else if (nivelDemanda == AccionSensor.DEMANDA_MEDIA){
                switch (estadoSensor){
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                    case Sensor.ESTADO_MITAD:
                        return AccionSensor.ACCION_REPOSICION;
                    default:
                        return AccionSensor.ACCION_INNECESARIA;
                }
            } else if (nivelDemanda == AccionSensor.DEMANDA_ALTA){
                switch (estadoSensor){
                    case Sensor.ESTADO_VACIO:
                    case Sensor.ESTADO_CASI_VACIO:
                    case Sensor.ESTADO_MITAD:
                    case Sensor.ESTADO_CASI_LLENO:
                        return AccionSensor.ACCION_REPOSICION;
                    default:
                        return AccionSensor.ACCION_INNECESARIA;
                }
            }

        } catch (IllegalStateException e) {
            // El sensor no se ha iniciado (y se generó una excepción)
            return AccionSensor.ACCION_REVISION;
        }
        // Cualquier otro caso no especificado
        return AccionSensor.ACCION_REVISION;
    }
}
