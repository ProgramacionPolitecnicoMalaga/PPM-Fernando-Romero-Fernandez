public class PorHoras extends Empleado implements EmpleadoInterface{

    private final static double DINERO_POR_HORA = 60.50;
    private double horasTrabajadas;

    public PorHoras(String nombre, String apellidos, double horasTrabajadas) {
        super("PorHoras: "+nombre, apellidos);
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularSueldo() {
        return DINERO_POR_HORA * horasTrabajadas;
    }
}