import java.util.LinkedList;

public class Proyecto {

    private String nombre, descripcion, departamento;
    private double factorProduccion;
    private LinkedList<Tarea> listaTareas = new LinkedList<>();

    public Proyecto(String nombre, String descripcion, String departamento, double factorProduccion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.departamento = departamento;
        this.factorProduccion = factorProduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getFactorProduccion() {
        return factorProduccion;
    }

    public void setFactorProduccion(double factorProduccion) {
        this.factorProduccion = factorProduccion;
    }

    public LinkedList<Tarea> getListaTareas() {
        return listaTareas;
    }
}
