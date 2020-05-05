package Suma;

import Logging.MiLogger;

import java.io.IOException;
import java.util.logging.Level;

public class Suma {

    public int sumar(int a, int b) throws IOException {
        //Logger parametros a sumar
        MiLogger.milogger.log(Level.INFO, "a = " + a + "; b = " + b);

        return a + b;
    }
}
