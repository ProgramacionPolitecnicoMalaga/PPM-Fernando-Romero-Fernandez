public class Indicador {

    private String tipoIndicador, nombreIndicador;

    public Indicador(String tipoIndicador, String nombreIndicador) {
        this.tipoIndicador = tipoIndicador;
        this.nombreIndicador = nombreIndicador;
    }

    public String getTipoIndicador() {
        return tipoIndicador;
    }

    public void setTipoIndicador(String tipoIndicador) {
        this.tipoIndicador = tipoIndicador;
    }

    public String getNombreIndicador() {
        return nombreIndicador;
    }

    public void setNombreIndicador(String nombreIndicador) {
        this.nombreIndicador = nombreIndicador;
    }

}
