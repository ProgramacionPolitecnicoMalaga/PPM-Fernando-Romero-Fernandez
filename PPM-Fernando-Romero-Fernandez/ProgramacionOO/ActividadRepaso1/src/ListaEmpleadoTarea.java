import java.util.Comparator;
import java.util.TreeMap;

public class ListaEmpleadoTarea {

    TreeMap<Empleado,Tarea> mapaEmpleadoTarea = new TreeMap<Empleado,Tarea>(new Comparator<Empleado>() {
        @Override
        public int compare(Empleado empleado, Empleado t1) {
            return empleado.getDNI().compareTo(t1.getDNI());
        }
    });




    public ListaEmpleadoTarea(){

    }

}
