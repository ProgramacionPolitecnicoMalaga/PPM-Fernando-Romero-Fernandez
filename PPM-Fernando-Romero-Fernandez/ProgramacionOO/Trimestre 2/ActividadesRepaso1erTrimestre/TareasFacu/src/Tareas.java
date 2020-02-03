import java.util.ArrayList;

public class Tareas {

    private ArrayList<Tarea> listaTareas;

    public Tareas(){
        listaTareas = new ArrayList<Tarea>();
    }

    public ArrayList<Tarea> getListaTareas(){
        return listaTareas;
    }

    public void añadirNuevaTarea(Tarea tarea){
        listaTareas.add(tarea);
    }

    public String mostrarTareasPendientes(){
        String texto = "Tareas pendientes:\n";
        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getFechaLimite().compararConFechaActual(listaTareas.get(i).getFechaLimite().getFecha()) > 0){
                texto += listaTareas.get(i).getNombre() + listaTareas.get(i).getCategoria().getNombre() + "\n";
            }
        }
        return texto;
    }

    public String mostrarTareasCompletadas(){
        String texto = "Tareas completadas:\n";
        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getFechaLimite().compararConFechaActual(listaTareas.get(i).getFechaLimite().getFecha()) <= 0){
                texto += listaTareas.get(i).getNombre() + listaTareas.get(i).getCategoria().getNombre() + "\n";
            }
        }
        return texto;
    }

    public String consultarTareasDeUnaCategoria(String nombreCategoria){
        String texto = "Tareas de la categoría: " + nombreCategoria + "\n";
        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getCategoria().getNombre() == nombreCategoria){
                texto += listaTareas.get(i).getNombre() + "\n";
            }
        }
        return texto;
    }

    public String buscarTareasPorFecha(Fecha fecha){
        String texto = "Tareas en la fecha: " + fecha.getFechaFormateada() + "\n";
        for(int i = 0; i < listaTareas.size(); i++){
            if(listaTareas.get(i).getFechaLimite().getFechaFormateada().equals(fecha.getFechaFormateada())){
                texto += listaTareas.get(i).getNombre() + "\n";
            }
        }
        return texto;
    }

    public String consultarTareasEnTiempo(){
        String texto = "Tareas en tiempo:\n";
        for(int i = 0; i < listaTareas.size(); i++){

        }
        return texto;
    }

    public String consultarTareasRetrasadas(){
        String texto = "Tareas no entregadas a tiempo:\n";
        for(int i = 0; i < listaTareas.size(); i++){

        }
        return texto;
    }
}
