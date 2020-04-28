import com.politecnicomalaga.AvanceTarea;
import com.politecnicomalaga.RetrocesoTarea;
import com.politecnicomalaga.Tareas;

public class App {
    public static void main(String[] args) {
        Tareas tareas = Tareas.getInstance();
        tareas.addTarea("Crear base de datos");
        tareas.addTarea("Insert en base de datos");
        tareas.addTarea("Update en base de datos");
        tareas.addTarea("Delete en base de datos");
        tareas.addTarea("Borrar base de datos");
        tareas.addTarea("Hacer deberes");
        tareas.addTarea("Actualizar pc");
        tareas.addTarea("Cambiar nombre");

        AvanceTarea avanceTarea = new AvanceTarea();

        avanceTarea.avanzar(2);
        avanceTarea.avanzar(3);

        RetrocesoTarea retrocesoTarea = new RetrocesoTarea();

        retrocesoTarea.retroceder(3);
        retrocesoTarea.retroceder(1);

        System.out.println("---------------------------------");
        System.out.println(tareas.getUltimaTareaRealizada());

    }
}
