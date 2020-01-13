import java.util.ArrayList;

public class Empleados {

    private ArrayList<Empleado> empleados;

    public Empleados(){
        empleados = new ArrayList<Empleado>();
        Empleado isabel = new Empleado("Isabel");
        int ventasIsabel[] = {7,7,10,6,4};
        isabel.setVentas(ventasIsabel);
        empleados.add(isabel);

        Empleado vicente = new Empleado("Vicente");
        int ventasVicente[] = {4,7,5,4,5};
        vicente.setVentas(ventasVicente);
        empleados.add(vicente);
    }

    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public String getEmpleadoPorNumeroVentasEnUnDia(int numeroVentas){
        String mensaje = "";
        System.out.println(empleados);
        for(int i = 0; i < empleados.size(); i++){
            boolean entrado = false;
            for(int j = 0; j < empleados.get(i).getVentas().length; j++){
                if(empleados.get(i).getVentas()[j] == numeroVentas){
                    entrado = true;
                }
            }
            if(entrado == true){
                mensaje = mensaje + empleados.get(i).getNombre() + "\n";
            }
        }
        return mensaje;
    }

    public String getPromedioVentasDeLosEmpleados(){
        String mensaje = "";
        for(int i = 0; i < empleados.size(); i++){
            int total = 0;
            for(int j = 0; j < empleados.get(i).getVentas().length; j++){
                total += empleados.get(i).getVentas()[j];
            }
            double promedio;
            promedio = total/empleados.get(i).getVentas().length;
            mensaje = mensaje + empleados.get(i).getNombre() + ":" + promedio + "\n";
        }
        return mensaje;
    }

    public String getMejorVendedor(){
        String mejorVendedor = "";
        int mejorVenta = 0;
        for(int i = 0; i < empleados.size(); i++){
            for(int j = 0; j < empleados.get(i).getVentas().length; j++){
                if(mejorVenta < empleados.get(i).getVentas()[j]){
                    mejorVenta = empleados.get(i).getVentas()[j];
                    mejorVendedor = empleados.get(i).getNombre();
                }
            }
        }
        String mensaje = mejorVendedor + " es el/la vendedor/a de la semana con " + mejorVenta + " items en un día";
        return mensaje;
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "empleados=" + empleados +
                '}';
    }
}
