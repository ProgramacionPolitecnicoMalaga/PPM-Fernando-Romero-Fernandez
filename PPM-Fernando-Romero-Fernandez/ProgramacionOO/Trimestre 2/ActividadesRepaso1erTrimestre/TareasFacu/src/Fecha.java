import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {

    static Calendar fecha;

    public Fecha(String fechaEnString) {
        String[] partesFecha = fechaEnString.split("/");
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);
        fecha.set(año, mes,dia);
    }

    public Calendar getFecha() {
        return fecha;
    }

    public String fechaFormateada(Calendar fecha) {
        String dia = Integer.toString(fecha.get(Calendar.DATE));
        String mes = Integer.toString(fecha.get(Calendar.MONTH));
        String año = Integer.toString(fecha.get(Calendar.YEAR));
        String fechaFormateada = dia + "/" + mes + "/" + año;
        return fechaFormateada;
    }

    public String getFechaFormateada(){
        return fechaFormateada(fecha);
    }

    public int compararConFechaActual(Calendar fechaAComparar){
        Date tiempoInicio = fechaAComparar.getTime();
        Date tiempoFinal = fechaAComparar.getTime();
        long diferencia = tiempoFinal.getTime() - tiempoInicio.getTime();
        long diferenciaDias = diferencia / (1000 * 60 * 60 * 24);
        return (int)diferenciaDias;
    }

    @Override
    public String toString() {
        return getFechaFormateada();
    }
}
