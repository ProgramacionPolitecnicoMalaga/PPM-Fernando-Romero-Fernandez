package com.politecnicomalaga.SENSORES;

import com.politecnicomalaga.CONSUMIDORES.ConsumidorDeTemperaturas;

public interface FuenteDeTemperaturas {
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas);
    public void informarAConsumidores();
}
