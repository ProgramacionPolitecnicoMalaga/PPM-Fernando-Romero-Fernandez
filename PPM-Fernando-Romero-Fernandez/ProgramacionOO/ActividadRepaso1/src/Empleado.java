public class Empleado {

    private String nombre, apellidos, DNI;
    private double productividad;
    private Categoria categoria;
    private Tarea tarea;

    public Empleado(String nombre, String apellidos, String DNI, double productividad, Categoria categoria){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.productividad = productividad;
        this.categoria = categoria;
        this.tarea = tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public double getProductividad() {
        return productividad;
    }

    public void setProductividad(double productividad) {
        this.productividad = productividad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
