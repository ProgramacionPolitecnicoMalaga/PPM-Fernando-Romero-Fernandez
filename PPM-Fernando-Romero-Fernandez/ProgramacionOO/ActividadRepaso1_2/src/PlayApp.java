public class PlayApp {

    public static void main(String[] args) {
        Listas listas = new Listas();

        //DEFINIR MIS EMPLEADOS

        Empleado empFernando = listas.listaEmpleados.get(0);
        Empleado empAlberto = listas.listaEmpleados.get(1);
        Empleado empFacundo = listas.listaEmpleados.get(2);
        Empleado empDavid = listas.listaEmpleados.get(3);
        Empleado empCelia = listas.listaEmpleados.get(4);

        //DEFINIR MIS PROYECTOS

        Proyecto proAlpahsec = listas.listaProyectos.get(0);
        Proyecto proAndroid = listas.listaProyectos.get(1);
        Proyecto proMotorola = listas.listaProyectos.get(2);
        Proyecto proApple = listas.listaProyectos.get(3);
        Proyecto proGoogle = listas.listaProyectos.get(4);

        //CREAR ALGUNAS TAREAS

        Tarea tarea1 = new Tarea("Esta es mi tarea 1 en Alphasec",60,proAlpahsec,empFernando);
        Tarea tarea2 = new Tarea("Esta es mi tarea 1 en Android",60,proAndroid,empFernando);
        Tarea tarea3 = new Tarea("Esta es mi tarea 2 en Android",60,proAndroid,empFernando);

        //AGREGAR TAREAS A SUS EMPLEADOS

        tarea1.añadirTareaALista(tarea1);
        tarea2.añadirTareaALista(tarea2);
        tarea3.añadirTareaALista(tarea3);

        //CREAR XML DE TAREAS POR EMPLEADO

        XMLTareasPorEmpleado xmlTareasPorEmpleado = new XMLTareasPorEmpleado(empFernando);
        XMLTareasPorProyecto xmlTareasPorProyecto = new XMLTareasPorProyecto(proAlpahsec);
        XMLTareasPorProyecto xmlTareasPorProyecto2 = new XMLTareasPorProyecto(proAndroid);



    }
}
