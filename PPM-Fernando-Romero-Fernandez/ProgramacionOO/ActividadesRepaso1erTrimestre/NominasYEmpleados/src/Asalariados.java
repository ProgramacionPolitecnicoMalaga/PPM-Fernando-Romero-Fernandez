public class Asalariados extends Empleado implements EmpleadoInterface {

    private final static double SUELDO_BASE = 850.00;

    public Asalariados(String nombre, String apellidos) {
        super("Asalariados: "+nombre, apellidos);
    }

    @Override
    public double calcularSueldo() {
        return SUELDO_BASE;
    }
}
