import java.util.Arrays;

public class Empleado {

    private String nombre;
    private int[] ventas;

    public Empleado(String nombre){
        this.nombre = nombre;
    }

    public int[] ventasAArray(String ventasString){
        String[] digitosTexto = ventasString.split(",");
        int tamañoArray = digitosTexto.length;
        ventas = new int[tamañoArray];
        for(int i = 0; i < digitosTexto.length; i++){
            ventas[i] = Integer.parseInt(digitosTexto[i]);
        }
        return ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getVentas() {
        return ventas;
    }

    public void setVentas(int[] ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", ventas=" + Arrays.toString(ventas) +
                '}';
    }
}
