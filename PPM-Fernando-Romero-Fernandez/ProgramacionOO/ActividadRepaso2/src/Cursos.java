import java.util.ArrayList;

public class Cursos {

    private ArrayList<Curso> listacursos;

    public Cursos(){
        listacursos = new ArrayList<Curso>();
    }

    public void añadirCursoAListaCursos(Curso curso){
        listacursos.add(curso);
        System.out.println("Nuevo curso añadido a la lista! " + curso.getNombreCurso());
    }

    public ArrayList<Curso> getCursos() {
        return listacursos;
    }

    @Override
    public String toString() {
        return "Cursos{" +
                "listacursos=" + listacursos +
                '}';
    }
}
