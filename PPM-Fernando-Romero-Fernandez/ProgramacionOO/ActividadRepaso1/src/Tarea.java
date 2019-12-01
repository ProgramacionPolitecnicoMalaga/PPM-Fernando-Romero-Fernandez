import java.util.Comparator;
import java.util.List;

public class Tarea {

    private String nombreTarea, descripcion;
    private double horasEmpleadas;
    private Proyecto proyecto;
    private Empleado empleado;

    public Tarea(String nombreTarea,String descripcion, double horasEmpleadas, Empleado empleado, Proyecto proyecto){
        this.nombreTarea = nombreTarea;
        this.descripcion = descripcion;
        this.horasEmpleadas = horasEmpleadas;
        this.proyecto = proyecto;
        this.empleado = empleado;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public double getHorasEmpleadas() {
        return horasEmpleadas;
    }

    public void setHorasEmpleadas(double horasEmpleadas) {
        this.horasEmpleadas = horasEmpleadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return nombreTarea;
    }
}
