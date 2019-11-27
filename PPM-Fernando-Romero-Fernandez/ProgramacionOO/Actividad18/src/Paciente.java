import java.util.Comparator;

public class Paciente {

    private String nombre;
    private int edad;
    private Urgencia urgencia;

    public Paciente(String nombre, int edad, Urgencia urgencia){
        this.nombre = nombre;
        this.edad = edad;
        this.urgencia = urgencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
