import java.util.*;

public class ListaEmpleadoTarea {

    TreeMap<Empleado, LinkedList<Tarea>> mapaEmpleadoTarea = new TreeMap<Empleado, LinkedList<Tarea>>(new Comparator<Empleado>() {
        @Override
        public int compare(Empleado empleado, Empleado t1) {
            return empleado.getDNI().compareTo(t1.getDNI());
        }
    });




    public ListaEmpleadoTarea(){

    }

}
