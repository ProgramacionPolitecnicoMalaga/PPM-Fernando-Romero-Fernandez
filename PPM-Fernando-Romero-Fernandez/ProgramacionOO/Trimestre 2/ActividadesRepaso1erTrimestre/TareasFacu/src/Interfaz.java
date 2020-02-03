import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Interfaz {

    Scanner lectorTeclado = new Scanner(System.in);
    private Tareas tareas;
    private Categorias categorias;

    public Interfaz() throws ParseException {
        tareas = new Tareas();
        categorias = new Categorias();
        categorias.añadirNuevaCategoria("Deberes");
        categorias.añadirNuevaCategoria("Ocio");
        introducirOpcion();
    }

    public void mostrarMenu(){
        System.out.println("" +
            "1.Crear una nueva categoría.\n" +
            "2.Mostrar las categorías existentes.\n" +
            "3.Crear una nueva tarea.\n" +
            "4.Consultar las tareas pendientes.\n" +
            "5.Eliminar una tarea (completada).\n" +
            "6.Consultar las tareas de una categoría.\n" +
            "7.Consultar las tareas en una fecha.\n" +
            "8.Consultar las tareas en tiempo.\n" +
            "9.Consultar las tareas retrasadas.\n");
    }

    public void introducirOpcion() throws ParseException {
        mostrarMenu();
        System.out.println("Selecciona una opción");
        int opcionElegida = lectorTeclado.nextInt();
        escogerOpcion(opcionElegida);
    }

    public void escogerOpcion(int opcion) throws ParseException {
            switch (opcion){
                case 1:
                    System.out.println("Introduce el nombre de la categoría");
                    String nombreCategoria = lectorTeclado.next();
                    categorias.añadirNuevaCategoria(nombreCategoria);
                    System.out.println("Categoría añadida a la Lista!");
                    introducirOpcion();
                    break;
                case 2:
                    System.out.println("Estas son las categorías existentes");
                    System.out.println(categorias.mostrarCategorias());
                    introducirOpcion();
                    break;
                case 3:
                    System.out.println("Introduce el nombre de la Tarea");
                    String nombreTarea = lectorTeclado.next();
                    System.out.println("Introduce el nombre de una categoría");
                    System.out.println(categorias.mostrarCategorias());
                    nombreCategoria = lectorTeclado.next();
                    Categoria categoria = categorias.getCategoriaPorNombre(nombreCategoria);
                    System.out.println("Introduce una fecha límite (Formato DD/MM/YYYY)");
                    String fechaEnString = lectorTeclado.next();
                    Fecha fechaTarea = new Fecha(fechaEnString);
                    Tarea nuevaTarea = new Tarea(nombreTarea,categoria,fechaTarea);
                    tareas.añadirNuevaTarea(nuevaTarea);
                    System.out.println(nuevaTarea);
                    introducirOpcion();
                    break;
                case 4:
                    System.out.println(tareas.mostrarTareasPendientes());
                    break;
                case 5:
                    System.out.println(tareas.mostrarTareasCompletadas());
                    break;
                case 6:
                    System.out.println("Introduce el nombre de una categoría");
                    nombreCategoria = lectorTeclado.next();
                    System.out.println(tareas.consultarTareasDeUnaCategoria(nombreCategoria));
                    break;
                case 7:
                    System.out.println("Introduce una fecha en la que buscar tareas");
                    fechaEnString = lectorTeclado.next();
                    fechaTarea = new Fecha(fechaEnString);
                    System.out.println(tareas.buscarTareasPorFecha(fechaTarea));
                    break;
                case 8:
                    System.out.println("Tareas en tiempo");
                    System.out.println(tareas.consultarTareasEnTiempo());
                    break;
                case 9:

                    break;
            }
    }
}
