import java.util.Calendar;
import java.util.Date;

public class Tarea {

    private String nombre;
    private Categoria categoria;
    private Fecha fecha;

    public Tarea(String nombre, Categoria categoria, Fecha fecha){
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Fecha getFechaLimite() {
        return fecha;
    }


    @Override
    public String toString() {
        return nombre + categoria.getNombre() + fecha.getFechaFormateada();
    }
}
