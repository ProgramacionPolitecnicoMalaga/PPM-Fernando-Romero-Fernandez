public class AppLibreta {

    public static void main(String[] args) {

        // Actividad 1: Crea cursos
        Curso cursoS11AW = new Curso("S11AW", "1º Desarrollo de Aplicaciones Web");
        Curso cursoASIR = new Curso("ASIR", "1º Administración de Sistemas y Redes");

        System.out.println("===========================================================================================");

        //Actividad 2: Añadir Asignatura a un Curso
        Asignatura asignaturaProg = new Asignatura("Prog","Programación");
        Asignatura asignaturaED = new Asignatura("ED","Entornos de Desarrollo");

        cursoS11AW.añadirAsignaturaACurso(asignaturaED);
        cursoS11AW.añadirAsignaturaACurso(asignaturaProg);
        cursoASIR.añadirAsignaturaACurso(asignaturaProg);

        System.out.println("===========================================================================================");

        //Actividad 3: Introducir un nuevo alumno y asignarlo a un curso.

        Alumno alumnoFernando = new Alumno("Fernando Romero Fernández");
        Alumno alumnoJorge = new Alumno("Jorge Ríos");
        Alumno alumnoFacundo = new Alumno("Facundo De Nardo");

        cursoS11AW.añadirAlumnoACurso(alumnoFernando);
        cursoS11AW.añadirAlumnoACurso(alumnoFacundo);
        cursoASIR.añadirAlumnoACurso(alumnoJorge);

        System.out.println("===========================================================================================");

        //Actividad 4: Matricular a un alumno en una asignatura de su curso.
        cursoS11AW.matricularAlumnoEnAsignatura(alumnoFernando,asignaturaProg);
        cursoS11AW.matricularAlumnoEnAsignatura(alumnoFernando,asignaturaED);

        cursoASIR.matricularAlumnoEnAsignatura(alumnoJorge,asignaturaED); // FALLO provocado Comprobacion de que no entra
        cursoASIR.matricularAlumnoEnAsignatura(alumnoJorge,asignaturaProg);
        cursoS11AW.matricularAlumnoEnAsignatura(alumnoFacundo,asignaturaProg);

        System.out.println("===========================================================================================");

        //Actividad 5: Definir un nuevo indicador para una asignatura, que puede ser un ejercicio, un examen o una nota de actitud. Un indicador se aplica a todos los alumnos de la asignatura.

        Indicador indExamenPROG = new Indicador("Examen","Tema 1 Programación");
        Indicador indEjercicioPROG = new Indicador("Ejercicio","Actividad 42");
        Indicador indEjercicioED = new Indicador("Ejercicio", "UML nos gusta");

        cursoS11AW.asignarIndicadorAAsignatura(indExamenPROG,asignaturaProg);
        cursoS11AW.asignarIndicadorAAsignatura(indEjercicioPROG,asignaturaProg);
        cursoS11AW.asignarIndicadorAAsignatura(indEjercicioED, asignaturaED);
        cursoASIR.asignarIndicadorAAsignatura(indExamenPROG,asignaturaProg);

        System.out.println("===========================================================================================");

        //Actividad 6: Asignar una nota a un indicador para una asignatura y un alumno determinado.

        CalificacionIndicador calificacionIndicador = new CalificacionIndicador(indExamenPROG,"Aprobó pero no se esforzó demasiado", 6.0);
        calificacionIndicador.añadirIndicadorCalificadoAlAlumno(calificacionIndicador,alumnoFacundo);

        CalificacionIndicador calificacionIndicador1 = new CalificacionIndicador(indEjercicioED, "Este ejercicio es de los alumnos de APWEB",9.0);
        calificacionIndicador1.añadirIndicadorCalificadoAlAlumno(calificacionIndicador1,alumnoJorge);

        System.out.println("===========================================================================================");

        //Actividad 7: Obtener un listado de asignaturas de un curso.

        cursoS11AW.mostrarAsignaturasDelCurso();
        cursoASIR.mostrarAsignaturasDelCurso();

        System.out.println("===========================================================================================");

        //Actividad 8: Obtener un listado de alumnos de una asignatura.

        cursoS11AW.mostrarAlumnosDeUnaAsignatura(asignaturaED);
        cursoS11AW.mostrarAlumnosDeUnaAsignatura(asignaturaProg);

        System.out.println("===========================================================================================");

        //Actividad 9: Obtener un listado de notas de un alumno.

        alumnoFernando.obtenerCalificacionesDelAlumno();
        alumnoFacundo.obtenerCalificacionesDelAlumno();
        alumnoJorge.obtenerCalificacionesDelAlumno();

        System.out.println("===========================================================================================");

        //Actividad 10: Exportar/leer los cursos a/desde un documento XML llamado "cursos.xml".
        //Actividad 11: Exportar/leer los alumnos de una asignatura y sus calificaciones a/desde un documento XML. Si la asignatura tiene el id prog y se imparte en el curso S11AW, el documento se llamará prog_S11AW.xml

    }
}
