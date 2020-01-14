import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Curso {

    private String idCurso, nombreCurso;
    private Cursos cursos;
    private ArrayList<Asignatura> listaAsignaturas;
    private ArrayList<Alumno> listaAlumnos;
    private HashMap<Alumno, Asignatura> mapaMatriculaciones;

    public Curso(String idCurso, String nombreCurso){
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        listaAsignaturas = new ArrayList<Asignatura>();
        listaAlumnos = new ArrayList<Alumno>();
        mapaMatriculaciones = new HashMap<Alumno, Asignatura>();

        cursos = new Cursos();
        cursos.añadirCursoAListaCursos(this);
    }



    public void añadirAsignaturaACurso(Asignatura asignatura){
        listaAsignaturas.add(asignatura);
        System.out.println("Asignatura: "+ asignatura.getNombreAsignatura() +" añadida correctamente al curso: " + this.getNombreCurso());
    }

    public void añadirAlumnoACurso(Alumno alumno){
        listaAlumnos.add(alumno);
        System.out.println("Alumno: " + alumno.getNombreAlumno() + " matriculado en el curso: " + this.getNombreCurso());
    }

    public void matricularAlumnoEnAsignatura(Alumno alumno, Asignatura asignatura){
        for(int i = 0; i < listaAsignaturas.size(); i++){
            if (asignatura.getNombreAsignatura() == listaAsignaturas.get(i).getNombreAsignatura()) {

                for(int j = 0; j < listaAlumnos.size(); j++){
                    if(alumno.getNombreAlumno() == listaAlumnos.get(j).getNombreAlumno()){
                        mapaMatriculaciones.put(alumno,asignatura);
                        System.out.println(mapaMatriculaciones);
                        System.out.println("Alumno: " + alumno.getNombreAlumno() + " matriculado en la asignatura: " + asignatura.getNombreAsignatura());
                    }
                }
            }
        }
    }

    public void asignarIndicadorAAsignatura(Indicador indicador, Asignatura asignatura){
        for(int i = 0; i < listaAsignaturas.size();i++){
            if(listaAsignaturas.get(i).getNombreAsignatura() == asignatura.getNombreAsignatura()){
                asignatura.añadirIndicador(indicador);
                System.out.println("Indicador añadido con éxito a la asignatura: " + asignatura.getNombreAsignatura() + " del curso: " + this.getNombreCurso() );
            }
        }
    }

    public void mostrarAsignaturasDelCurso(){
        System.out.println("Lista de Asignaturas del curso: " + this.getNombreCurso() + "====================");
        for(int i = 0; i < listaAsignaturas.size();i++){
            System.out.println(listaAsignaturas.get(i));
        }
    }

    public void mostrarAlumnosDeUnaAsignatura(Asignatura asignatura){
        System.out.println("Lista de Alumnos de la asignatura:" + asignatura.getNombreAsignatura());
        for (Map.Entry<Alumno, Asignatura> alumnoAsignaturaEntry : mapaMatriculaciones.entrySet()){
            if(asignatura.getNombreAsignatura() == alumnoAsignaturaEntry.getValue().getNombreAsignatura()){
                System.out.println(alumnoAsignaturaEntry.getKey());
            }
        }
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public ArrayList<Asignatura> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public HashMap<Alumno, Asignatura> getMapaMatriculaciones() {
        return mapaMatriculaciones;
    }

    public void setMapaMatriculaciones(HashMap<Alumno, Asignatura> mapaMatriculaciones) {
        this.mapaMatriculaciones = mapaMatriculaciones;
    }

    @Override
    public String toString() {
        return nombreCurso;
    }
}
