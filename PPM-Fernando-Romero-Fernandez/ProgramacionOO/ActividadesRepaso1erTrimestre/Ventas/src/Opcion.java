import java.util.Arrays;
import java.util.Scanner;

public class Opcion {

    public static final int OPCION_1 = 1;
    public static final int OPCION_2 = 2;
    public static final int OPCION_3 = 3;
    public static final int OPCION_4 = 4;

    public Opcion(int opcionElegida, Empleados empleados){
        Scanner lectorTeclado = new Scanner(System.in);
        switch (opcionElegida){
            case OPCION_1:
                int numeroItems;
                System.out.println("Introduce un número de items");
                numeroItems = lectorTeclado.nextInt();
                System.out.println("Los empleados que vendieron " + numeroItems + " fueron:");
                System.out.println(empleados.getEmpleadoPorNumeroVentasEnUnDia(numeroItems));
                break;
            case OPCION_2:
                System.out.println("El promedio de ventas es:");
                System.out.println(empleados.getPromedioVentasDeLosEmpleados());
                break;
            case OPCION_3:
                System.out.println(empleados.getMejorVendedor());
                break;
            case OPCION_4:
                System.out.println("Introduce el nombre de tu Vendedor Nuevo");
                String nombreEmpleado = lectorTeclado.nextLine();
                System.out.println("Introduce las ventas del Vendedor (separadas por coma)");
                String ventasTexto = lectorTeclado.nextLine();
                Empleado empleado = new Empleado(nombreEmpleado);
                empleado.setVentas(empleado.ventasAArray(ventasTexto));
                empleados.addEmpleado(empleado);
                System.out.println("Listo añadido, a la lista de empleados!");
                break;

        }
    }
}
