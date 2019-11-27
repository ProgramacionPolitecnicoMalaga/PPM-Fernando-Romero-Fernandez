import java.util.Comparator;

public class Urgencia {

    private String descripcion;
    private int especialidad;
    private boolean grave;

    public Urgencia(int especialidad, String descripcion, boolean grave){
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.grave = false;
    }

    public static final Comparator<Urgencia> COMPARATOR_ESPECIALIDAD = new Comparator<Urgencia>() {
        @Override
        public int compare(Urgencia urgencia, Urgencia urgencia2) {
            return urgencia.getEspecialidad() - urgencia2.getEspecialidad();
        }
    };

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isGrave() {
        return grave;
    }

    public void setGrave(boolean grave) {
        this.grave = grave;
    }
}
