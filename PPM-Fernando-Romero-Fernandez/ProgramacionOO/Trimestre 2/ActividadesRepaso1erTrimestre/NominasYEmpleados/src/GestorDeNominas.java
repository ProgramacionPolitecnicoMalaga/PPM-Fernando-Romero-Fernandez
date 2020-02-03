public class GestorDeNominas {

    public String calcularNomina(Empleado empleado){
        return "El sueldo del empleado " +empleado.getNombre() + " es: " + empleado.calcularSueldo();
    }
}
