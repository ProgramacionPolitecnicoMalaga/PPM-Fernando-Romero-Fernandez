import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class RankingPilotos {

    ArrayList<Piloto> pilotos = new ArrayList<>();

    public RankingPilotos() throws IOException {

        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/pilotos.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split(";");
                lineas = Lector.readLine();
                Piloto piloto1 = new Piloto(linea[1],linea[2],Integer.parseInt(linea[0]));
                pilotos.add(piloto1);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void añadirPiloto(Piloto piloto, int posicionDeSalida){
        pilotos.add(posicionDeSalida,piloto);
    }

    public void adelantarPiloto(Piloto piloto){
        pilotos.set(piloto.getPosicionDeSalida()-1,piloto);
    }

    public void retrasarPiloto(Piloto piloto){
        pilotos.set(piloto.getPosicionDeSalida()+1,piloto);
    }

    public void descalificarPiloto(Piloto piloto){
        piloto.setDescalificado(true);
    }

    public void eliminarPilotosDescalificados(){
        pilotos.removeIf(piloto -> piloto.isDescalificado());
    }

    public void ordenarPilotosPorPosicionDeSalida(){
        Collections.sort(pilotos, new Comparator<Piloto>() {
            public int compare(Piloto piloto1, Piloto piloto2) {
                return new Integer(piloto1.getPosicionDeSalida()).compareTo(piloto2.getPosicionDeSalida());
            }
        });
    }

    public void ordenarPilotosPorNombre(){
        Collections.sort(pilotos, new Comparator<Piloto>() {
            public int compare(Piloto piloto1, Piloto piloto2) {
                return piloto1.getNombre().compareTo(piloto2.getNombre());
            }
        });
    }

    @Override
    public String toString() {
        Iterator<Piloto> pilotoActual = pilotos.iterator();
        while (pilotoActual.hasNext()) {
            return pilotoActual.toString();
        }
        return null;
    }

}
