public class Piloto {

    private String nombre;
    private String escuderia;
    private int posicionDeSalida;
    private boolean descalificado;

    public Piloto(String nombre, String escuderia, int posicionDeSalida){
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.posicionDeSalida = posicionDeSalida;
        this.descalificado = false;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPosicionDeSalida() {
        return posicionDeSalida;
    }

    public void setPosicionDeSalida(int posicionDeSalida) {
        this.posicionDeSalida = posicionDeSalida;
    }

    public boolean isDescalificado() {
        return descalificado;
    }

    public void setDescalificado(boolean descalificado) {
        this.descalificado = descalificado;
    }

    @Override
    public String toString() {
        return "Piloto: " + nombre + "\n" +
                "Posición: " + posicionDeSalida + "\n" +
                "Escudería: " + escuderia + "\n" +
                "===============================================" + "\n";
    }
}
