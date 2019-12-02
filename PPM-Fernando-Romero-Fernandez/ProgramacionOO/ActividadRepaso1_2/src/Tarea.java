import java.util.LinkedList;

public class Tarea {

    private String descripcion;
    private int minutosEmpleados;
    private Proyecto proyecto;
    private Empleado empleado;

    public Tarea(String descripcion, int minutosEmpleados, Proyecto proyecto, Empleado empleado){
        this.descripcion = descripcion;
        this.minutosEmpleados = minutosEmpleados;
        this.proyecto = proyecto;
        this.empleado = empleado;
    }

    public void añadirTareaALista(Tarea tarea){
        LinkedList miLista = tarea.getEmpleado().getListaTareas();
        miLista.add(tarea);
        LinkedList miLista2 = tarea.getProyecto().getListaTareas();
        miLista2.add(tarea);

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMinutosEmpleados() {
        return minutosEmpleados;
    }

    public void setMinutosEmpleados(int minutosEmpleados) {
        this.minutosEmpleados = minutosEmpleados;
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
}
