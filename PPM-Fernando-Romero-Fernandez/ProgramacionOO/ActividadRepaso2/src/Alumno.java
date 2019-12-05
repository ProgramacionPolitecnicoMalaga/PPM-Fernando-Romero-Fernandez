import java.util.ArrayList;

public class Alumno {

    private String nombreAlumno;
    private ArrayList<CalificacionIndicador> listaCalificaciones;

    public Alumno(String nombreAlumno){
        this.nombreAlumno = nombreAlumno;
        listaCalificaciones = new ArrayList<CalificacionIndicador>();
    }

    public void obtenerCalificacionesDelAlumno(){
        System.out.println("Notas del alumno: "+ this.getNombreAlumno() + "==================");
        for(int i = 0; i < listaCalificaciones.size(); i++){

            System.out.println(this.getListaCalificaciones().get(i).getIndicador().getTipoIndicador());
            System.out.println(this.getListaCalificaciones().get(i).getIndicador().getNombreIndicador());
            System.out.println(this.getListaCalificaciones().get(i).getNota());
            System.out.println(this.getListaCalificaciones().get(i).getComentario());


        }
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public ArrayList<CalificacionIndicador> getListaCalificaciones() {
        return listaCalificaciones;
    }

    public void setListaCalificaciones(ArrayList<CalificacionIndicador> listaCalificaciones) {
        this.listaCalificaciones = listaCalificaciones;
    }

    @Override
    public String toString() {
        return nombreAlumno;
    }
}
