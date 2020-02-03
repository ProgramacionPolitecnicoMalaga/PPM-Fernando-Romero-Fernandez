import java.util.ArrayList;

public class CalificacionIndicador {

    private Indicador indicador;
    private String comentario;
    private double nota;

    public CalificacionIndicador(Indicador indicador, String comentario, double nota){
        this.indicador = indicador;
        this.comentario = comentario;
        this.nota = nota;
    }

    public void añadirIndicadorCalificadoAlAlumno(CalificacionIndicador calificacionIndicador, Alumno alumno){
        alumno.getListaCalificaciones().add(calificacionIndicador);
        System.out.println("Se ha añadido con éxito la nota al alumno: " + alumno.getNombreAlumno());
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
