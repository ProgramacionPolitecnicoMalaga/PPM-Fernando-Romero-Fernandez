public class Comisionados extends Empleado implements EmpleadoInterface{

    private final static double SUELDO_BASE = 350.00;
    private int ventasRealizadas;

    public Comisionados(String nombre, String apellidos, int ventasRealizadas) {
        super("Comisionados: " + nombre, apellidos);
        this.ventasRealizadas = ventasRealizadas;
    }

    @Override
    public double calcularSueldo() {
        return SUELDO_BASE + (50*ventasRealizadas);
    }
}
