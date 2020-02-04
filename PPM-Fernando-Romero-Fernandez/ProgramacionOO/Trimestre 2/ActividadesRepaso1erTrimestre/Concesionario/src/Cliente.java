import java.util.ArrayList;

public class Cliente {

    private String nombre, apellidos, nif;
    ArrayList<Vehiculo> vehiculosDelCliente;

    public Cliente(String nombre, String apellidos, String nif){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
        vehiculosDelCliente = new ArrayList<Vehiculo>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void añadirVehiculoAlCliente(Vehiculo vehiculo){
        vehiculosDelCliente.add(vehiculo);
    }

    public Vehiculo pedirVehiculoPorPos(int posVehiculoDelCliente) {
        Vehiculo vehiculoADar = vehiculosDelCliente.get(posVehiculoDelCliente);
        vehiculosDelCliente.remove(posVehiculoDelCliente);
        return vehiculoADar;
    }
}
