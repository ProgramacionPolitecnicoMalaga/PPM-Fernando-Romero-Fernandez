import java.util.Calendar;

public class Tasador {

    public Tasador(){

    }

    public int tasarCombustion(Vehiculo vehiculo){
        int precioCombustion = 0;
        if(vehiculo.getCombustion().equals("Eléctrico")){
            precioCombustion = 5000;
        } else if(vehiculo.getCombustion().equals("Híbrido")){
            precioCombustion = 3000;
        } else if(vehiculo.getCombustion().equals("Diesel")){
            precioCombustion = 1500;
        }
        return precioCombustion;
    }

    public int tasarAñoDeFabricacion(Vehiculo vehiculo){
        Calendar calendar = Calendar.getInstance();
        int añoActual = calendar.get(Calendar.YEAR);
        int añosDiferencia = añoActual - vehiculo.getAñoFabricacion();
        int precioAños = añosDiferencia * 100;

        return precioAños;
    }

    public int tasarColor(Vehiculo vehiculo){
        int precioColor = 100;
        String colorVehiculo = vehiculo.getColor();
        if(colorVehiculo.toLowerCase().equals("blanco") || colorVehiculo.toLowerCase().equals("negro")){
            precioColor += 200;
        }

        return precioColor;
    }

    public int tasarNuevo(Vehiculo vehiculo){
        int precioNuevo = 500;
        boolean nuevo = vehiculo.isNuevo();
        if(nuevo == true){
            precioNuevo += 500;
        }

        return precioNuevo;
    }

    public void tasarVehiculo(Vehiculo vehiculo){
        int precioTotal = 0;
        precioTotal += tasarCombustion(vehiculo);
        precioTotal += tasarAñoDeFabricacion(vehiculo);
        precioTotal += tasarColor(vehiculo);
        precioTotal += tasarNuevo(vehiculo);

        vehiculo.setPrecio(precioTotal);
    }
}
