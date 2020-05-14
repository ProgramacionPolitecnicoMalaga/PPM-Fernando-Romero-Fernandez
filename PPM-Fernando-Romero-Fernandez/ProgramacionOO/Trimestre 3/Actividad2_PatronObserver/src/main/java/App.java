import com.politecnicomalaga.CONSUMIDORES.DiarioDeTemperaturas;
import com.politecnicomalaga.CONSUMIDORES.PromedioDeTemperaturas;
import com.politecnicomalaga.CONSUMIDORES.RegistroDeTemperaturasCriticas;
import com.politecnicomalaga.SENSORES.SensorTemperatura;

import java.util.Timer;

public class App
{
    public static void main( String[] args )
    {
        DiarioDeTemperaturas diarioDeTemperaturas = new DiarioDeTemperaturas();
        PromedioDeTemperaturas promedioDeTemperaturas = new PromedioDeTemperaturas();
        RegistroDeTemperaturasCriticas registroDeTemperaturasCriticas = new RegistroDeTemperaturasCriticas();
        SensorTemperatura sensor = new SensorTemperatura();
        sensor.registrarConsumidor(diarioDeTemperaturas);
        sensor.registrarConsumidor(promedioDeTemperaturas);
        sensor.registrarConsumidor(registroDeTemperaturasCriticas);
        Timer temporizador = new Timer();
        temporizador.schedule(sensor,0,5000);
    }
}
