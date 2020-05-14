package com.politecnicomalaga.SENSORES;

import com.politecnicomalaga.CONSUMIDORES.ConsumidorDeTemperaturas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTemperaturas{
    private int sensor;
    private Random aleatorio;
    private Instant inicio;
    private Instant ahora;
    private ArrayList<ConsumidorDeTemperaturas> consumidoresSuscritos;

    public SensorTemperatura(){
        aleatorio = new Random();
        inicio = Instant.now();
        consumidoresSuscritos = new ArrayList<>();
    }

    public void nuevaLectura(){
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        ahora = Instant.now();
        Duration period = Duration.between(inicio,ahora);
        informarAConsumidores();

        System.out.println("Lectura de temperatura: " + sensor +  "ºC (" + period.getSeconds() + " segundos desde el inicio)");
        for(int i = 0; i < consumidoresSuscritos.size(); i++){
            System.out.println(consumidoresSuscritos.get(i));
        }
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        consumidoresSuscritos.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for(int i = 0; i < consumidoresSuscritos.size(); i++){
            consumidoresSuscritos.get(i).setNuevaTemperatura(sensor,LocalTime.now());
        }
    }
}

