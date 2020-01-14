import java.util.Scanner;

public class Interfaz {

    private int opcionElegida;
    private Empleados empleados;

    public Interfaz(){
        empleados = new Empleados();
    }

    public void mostrarPreguntas(){
        System.out.println(
        "1. Empleados que vendieron un número de items\n" +
        "2. Obtener el promedio de ventas de cada uno\n" +
        "3. Averiguar quién han conseguido el mayor número de ventas en un día\n" +
        "4. Insertar un nuevo empleado y sus ventas");

        System.out.println("Selecciona una opción");
        seleccionarOpcion();
    }

    public void seleccionarOpcion(){
        Scanner lectorTeclado = new Scanner(System.in);
        opcionElegida = lectorTeclado.nextInt();
        Opcion opcion = new Opcion(opcionElegida,empleados);
    }
}
