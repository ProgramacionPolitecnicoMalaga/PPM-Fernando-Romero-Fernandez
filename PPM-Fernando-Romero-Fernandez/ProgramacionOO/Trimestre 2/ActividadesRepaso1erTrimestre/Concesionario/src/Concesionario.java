import java.util.ArrayList;

public class Concesionario {

    int caja;
    ArrayList<Vehiculo> almacenVehiculos;
    ArrayList<Cliente> clientesAsociados;

    public Concesionario(){
        almacenVehiculos = new ArrayList<Vehiculo>();
        clientesAsociados = new ArrayList<Cliente>();
        caja = 0;
    }

    public void añadirVehiculo(Vehiculo vehiculo){
        almacenVehiculos.add(vehiculo);
    }

    public void añadirCliente(Cliente cliente){
        clientesAsociados.add(cliente);
    }

    public Vehiculo pedirVehiculoPorPos(int posicionVehiculo){
        Vehiculo vehiculoADar = almacenVehiculos.get(posicionVehiculo);
        almacenVehiculos.remove(posicionVehiculo);
        return vehiculoADar;
    }

    public Cliente pedirClienteUniversal(String identificacion){
        Cliente miCliente;
        for(int i = 0; i < clientesAsociados.size(); i++){
            miCliente = clientesAsociados.get(i);
            if(identificacion.equals(miCliente.getNombre())){
                return miCliente;
            } else if(identificacion.equals(miCliente.getApellidos())){
                return miCliente;
            } else if(identificacion.equals(miCliente.getNif())){
                return miCliente;
            }
        }
        miCliente = new Cliente("???","???","???");
        return miCliente;
    }
}
