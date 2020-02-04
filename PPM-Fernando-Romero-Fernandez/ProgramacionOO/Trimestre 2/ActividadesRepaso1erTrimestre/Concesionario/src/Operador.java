public class Operador {

    private static Vista vista;
    private Concesionario concesionario;
    private Tasador tasador;
    public int opcion = -1;

    public Operador(){
        concesionario = new Concesionario();
        vista = new Vista();
        tasador = new Tasador();
    }

    public void iniciar(){
        opcion = vista.mostrarMenu();
        while(opcion != Vista.TERMINAR){
            switch (opcion){
                case Vista.AÑADIR_VEHICULO: //Añadir un vehículo al concesionario
                    String marca = vista.pedirMarcaVehiculo();
                    String modelo = vista.pedirModeloVehiculo();
                    String color = vista.pedirColorVehiculo();
                    int añoFabricacion = vista.pedirAñoFabricacionVehiculo();
                    String combusiton = vista.pedirCombustionVehiculo();
                    boolean esNuevo = vista.pedirEsNuevoElCoche();
                    Vehiculo vehiculo = new Vehiculo(modelo,marca,color,añoFabricacion,combusiton,esNuevo);
                    tasador.tasarVehiculo(vehiculo);
                    concesionario.añadirVehiculo(vehiculo);
                    iniciar();
                    break;
                case Vista.AÑADIR_CLIENTE:
                    String nombre = vista.pedirNombreCliente();
                    String apellidos = vista.pedirApellidosCliente();
                    String nif = vista.pedirNifCliente();
                    concesionario.añadirCliente(new Cliente(nombre,apellidos,nif));
                    iniciar();
                    break;
                case Vista.LISTAR_VEHICULOS_DEL_CONCESIONARIO:
                    vista.mostrarVehiculos(concesionario);
                    iniciar();
                    break;
                case Vista.LISTAR_VEHICULOS_DE_UN_CLIENTE:
                    String identificacionCliente = vista.solicitarIdentificacion();
                    Cliente cliente = concesionario.pedirClienteUniversal(identificacionCliente);
                    vista.mostrarVehiculos(cliente);
                    iniciar();
                    break;
                case Vista.VENDER_COCHE_A_CLIENTE:
                    String identificacionComprador = vista.solicitarIdentificacion();
                    Cliente comprador = concesionario.pedirClienteUniversal(identificacionComprador);
                    vista.mostrarVehiculos(concesionario);
                    int posVehiculoSolicitado = vista.pedirPos();
                    Vehiculo vehiculoAVender = concesionario.pedirVehiculoPorPos(posVehiculoSolicitado);
                    comprador.añadirVehiculoAlCliente(vehiculoAVender);
                    System.out.println(vehiculoAVender.getPrecio());
                    concesionario.caja += vehiculoAVender.getPrecio();
                    iniciar();
                    break;
                case Vista.COMPRAR_COCHE_A_CLIENTE:
                    String identificacionVendedor = vista.solicitarIdentificacion();
                    Cliente vendedor = concesionario.pedirClienteUniversal(identificacionVendedor);
                    vista.mostrarVehiculos(vendedor);
                    int posVehiculoDelCliente = vista.pedirPos();
                    Vehiculo vehiculoAComprar = vendedor.pedirVehiculoPorPos(posVehiculoDelCliente);
                    concesionario.añadirVehiculo(vehiculoAComprar);
                    concesionario.caja -= vehiculoAComprar.getPrecio();
                    iniciar();
                    break;
                case Vista.OBTENER_BALANCE:
                    vista.mostrarBalance(concesionario);
                    iniciar();
                    break;
            }
        }
    }
}
