public class Nomina {

    private Empleado empleado;
    private double complementos, sueldoTotal;

    public Nomina(Empleado empleado, double complementos, double sueldoTotal){
        this.complementos = complementos;
        this.sueldoTotal = sueldoTotal;
        this.empleado = empleado;
    }


    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getComplementos() {
        return complementos;
    }

    public void setComplementos(double complementos) {
        this.complementos = complementos;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }
}
