public class Aditivo {

    private String peligrosidad, nombre, comentario;

    public Aditivo(String peligrosidad, String nombre, String comentario){
        this.peligrosidad = peligrosidad;
        this.nombre = nombre;
        this.comentario = comentario;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public void setPeligrosidad(String peligrosidad) {
        this.peligrosidad = peligrosidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Aditivo{" +
                "peligrosidad='" + peligrosidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
