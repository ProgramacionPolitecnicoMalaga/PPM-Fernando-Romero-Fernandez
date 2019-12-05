import java.util.ArrayList;

public class Asignatura {

    private String idAsignatura, nombreAsignatura;
    private ArrayList<Indicador> listaIndicadores;

    public Asignatura(String idAsignatura, String nombreAsignatura){
        this.idAsignatura = idAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        listaIndicadores = new ArrayList<Indicador>();
    }

    public void añadirIndicador(Indicador indicador){
        listaIndicadores.add(indicador);
    }


    public Indicador getIndicador(Indicador indicador){
        for(int i = 0; i < listaIndicadores.size(); i++){
            if(indicador.getNombreIndicador() == listaIndicadores.get(i).getNombreIndicador()){
                return indicador;
            }
        }
        return null;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    @Override
    public String toString() {
        return nombreAsignatura;
    }
}
