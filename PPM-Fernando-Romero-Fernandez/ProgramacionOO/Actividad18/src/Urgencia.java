import java.util.Comparator;

public class Urgencia {

    private String descripcion;
    private int especialidad;
    private boolean grave;
    private Paciente paciente;

    public Urgencia(int especialidad, String descripcion, boolean grave, Paciente paciente){
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.grave = false;
        this.paciente = paciente;
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
        if(grave){
            return true;
        }else{
            return false;
        }
    }

    public void setGrave(boolean grave) {
        this.grave = grave;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
