import java.util.Scanner;

public class Interfaz {

    private int opcionElegida;

    public Interfaz(){

    }

    public void mostrarPreguntas(){
        System.out.println(
        "1. Empleados que vendieron un número de items\n" +
        "2. Obtener el promedio de ventas de cada uno\n" +
        "3. Averiguar quién han conseguido el mayor número de ventas en un día\n" +
        "4. Insertar un nuevo empleado y sus ventas");

        System.out.println("Selecciona una opción");
        Scanner lectorTeclado = new Scanner(System.in);
        opcionElegida = lectorTeclado.nextInt();
        seleccionarOpcion(opcionElegida);
    }

    public void seleccionarOpcion(int opcionElegida){
        Opcion opcion = new Opcion(opcionElegida);
    }
}
