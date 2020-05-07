package com.politecnicomalaga;

import org.mockito.ArgumentMatcher;

public class GrupoSensores implements ArgumentMatcher<Integer> {

    private int estadoSensor;

    public GrupoSensores(int estadoSensor){
        this.estadoSensor = estadoSensor;
    }

    @Override
    public boolean matches(Integer numeroSensor) {
        switch (estadoSensor){
            case Sensor.NO_INICIADO:
                return (numeroSensor >= 0) && (numeroSensor <= 9);
            case Sensor.ESTADO_VACIO:
                return (numeroSensor >= 10) && (numeroSensor <= 19);
            case Sensor.ESTADO_CASI_VACIO:
                return (numeroSensor >= 20) && (numeroSensor <= 29);
            case Sensor.ESTADO_MITAD:
                return (numeroSensor >= 30) && (numeroSensor <= 39);
            case Sensor.ESTADO_CASI_LLENO:
                return (numeroSensor >= 40) && (numeroSensor <= 49);
            case Sensor.ESTADO_LLENO:
                return (numeroSensor >= 50) && (numeroSensor <= 59);
            default:
                return false;
        }
    }
}
