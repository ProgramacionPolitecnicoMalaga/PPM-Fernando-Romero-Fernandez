import java.util.Scanner;

public class Vista {

    public final static int AÑADIR_VEHICULO = 1;
    public final static int AÑADIR_CLIENTE = 2;
    public final static int LISTAR_VEHICULOS_DEL_CONCESIONARIO = 3;
    public final static int LISTAR_VEHICULOS_DE_UN_CLIENTE = 4;
    public final static int VENDER_COCHE_A_CLIENTE = 5;
    public final static int COMPRAR_COCHE_A_CLIENTE = 6;
    public final static int OBTENER_BALANCE = 7;
    public final static int TERMINAR = 8;
    private Scanner lectorTeclado;

    public Vista(){
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu(){
        System.out.println("Opciones:\n" +
                "1. Introducir un nuevo vehículo.\n" +
                "2. Introducir un nuevo cliente.\n" +
                "3. Mostrar vehículos del concesionario.\n" +
                "4. Mostrar vehículos de un cliente.\n" +
                "5. Realizar una venta a un cliente.\n" +
                "6. Realizar una compra a un cliente.\n" +
                "7. Obtener el saldo total de un cliente que ha realizado ventas/compras en el concesionario.\n" +
                "8. Terminar programa.\n" +
                "Seleccione una opción.");
        return lectorTeclado.nextInt();
    }

    public void mostrarVehiculos(Concesionario concesionario){
        System.out.println("Estos son nuestros vehiculos");
        for(int i = 0; i < concesionario.almacenVehiculos.size(); i++){
            Vehiculo vehiculo = concesionario.almacenVehiculos.get(i);
            System.out.println("Vehículo número: " + i +
                    " Marca: " + vehiculo.getMarca() +
                    " Modelo: "+ vehiculo.getModelo() +
                    " Color: " + vehiculo.getColor() +
                    " Año Fab: " + vehiculo.getAñoFabricacion() +
                    " Combustión: " + vehiculo.getCombustion() +
                    " ¿Es nuevo?: " + vehiculo.isNuevo() +
                    " Precio: " + vehiculo.getPrecio());
        }
    }

    public void mostrarVehiculos(Cliente cliente){
        System.out.println("Estos son los vehículos del cliente: " + cliente.getNombre());
        for(int i = 0; i < cliente.vehiculosDelCliente.size(); i++){
            Vehiculo vehiculo = cliente.vehiculosDelCliente.get(i);
            System.out.println("Vehículo número: " + i +
                    " Marca: " + vehiculo.getMarca() +
                    " Modelo: "+ vehiculo.getModelo() +
                    " Color: " + vehiculo.getColor() +
                    " Año Fab: " + vehiculo.getAñoFabricacion() +
                    " Combustión: " + vehiculo.getCombustion() +
                    " ¿Es nuevo?: " + vehiculo.isNuevo() +
                    " Precio: " + vehiculo.getPrecio());
        }
    }

    public void mostrarBalance(Concesionario concesionario){
        System.out.println(concesionario.caja);
    }

    public String pedirModeloVehiculo() {
        System.out.println("Introduce el modelo del vehículo");
        return lectorTeclado.next();
    }

    public String pedirMarcaVehiculo() {
        System.out.println("Introduce la marca del vehículo");
        return lectorTeclado.next();
    }

    public String pedirColorVehiculo() {
        System.out.println("Introduce el color del vehículo");
        return lectorTeclado.next();
    }

    public int pedirAñoFabricacionVehiculo() {
        System.out.println("Introduce el año de fabricación del vehículo");
        return lectorTeclado.nextInt();
    }

    public String pedirCombustionVehiculo() {
        System.out.println("Introduce la combustión del vehículo (Eléctrico/Híbrido/Diesel)");
        String combustion = lectorTeclado.next();
        if(combustion.toLowerCase().equals("eléctrico")  ||  combustion.toLowerCase().equals("híbrido") || combustion.toLowerCase().equals("diesel")){
            return combustion;
        } else {
            System.out.println("No has introducido bien la combustión");
            return pedirCombustionVehiculo();
        }
    }

    public boolean pedirEsNuevoElCoche() {
        System.out.println("Si el coche es nuevo introduce TRUE, si es seminuevo introduce FALSE");
        String esNuevo = lectorTeclado.next();
        if(esNuevo.toLowerCase().equals("true") || esNuevo.toLowerCase().equals("false")){
            if(esNuevo.toLowerCase().equals("true")){
                return true;
            } else{
                return false;
            }
        } else{
            System.out.println("No has introducido bien si es nuevo o no");
            return pedirEsNuevoElCoche();
        }
    }

    public String pedirNombreCliente(){
        System.out.println("Introduce el nombre del cliente");
        return lectorTeclado.next();
    }

    public String pedirApellidosCliente(){
        System.out.println("Introduce los apellidos del cliente:");
        return lectorTeclado.next();
    }

    public String pedirNifCliente(){
        System.out.println("Introduce el NIF del cliente");
        return lectorTeclado.next();
    }

    public String solicitarIdentificacion(){
        System.out.println("¡Hola! ¡Puedes identificarte con tu NIF o tu nombre o incluso tus apellidos! ¡Elige uno!");
        String tipoId = lectorTeclado.next();
        if(!tipoId.toLowerCase().equals("nif")  &&  !tipoId.toLowerCase().equals("nombre") && !tipoId.toLowerCase().equals("apellidos")){
            System.out.println("No has introducido bien el tipo de identificación");
            return solicitarIdentificacion();
        } else if(tipoId.toLowerCase().equals("nif")){
            return pedirNifCliente();
        } else if(tipoId.toLowerCase().equals("nombre")){
            return pedirNombreCliente();
        } else if(tipoId.toLowerCase().equals("apellidos")){
            return pedirApellidosCliente();
        }
        return "No ha funcionado";
    }

    public int pedirPos(){
        System.out.println("Seleccione un coche, un número de vehículo");
        return lectorTeclado.nextInt();
    }
}
