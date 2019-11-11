import java.io.IOException;
import java.util.*;

public class RankingPilotos {

    ArrayList<Piloto> pilotos;

    public RankingPilotos() throws IOException {
        ArchivoCSV arch1 = new ArchivoCSV("files/pilotos.csv");
        arch1.cargarCSV();
        pilotos = arch1.listaPilotos;
    }

    public int elegirMovimiento(){
        Random r = new Random();
        return r.nextInt(7) - 3;
    }


    public void moverPiloto(Piloto piloto){

        int numeroRandom = elegirMovimiento();

        if((numeroRandom == -3) || (numeroRandom == 3)){ //DESCALIFICAR SI EL NUMERO ES 3 O -3;
            descalificarPiloto(piloto);

        } else if((numeroRandom > 0) && (numeroRandom <= 2)){ //SUMAR PUESTOS, ES DECIR RETRASAR POSICIÓN 1 O 2 PUESTOS
            int indexPiloto = pilotos.indexOf(piloto);
            int cola = pilotos.size();

            Piloto pilotoActual = new Piloto(piloto.getNombre(), piloto.getEscuderia(), piloto.getPosicionDeSalida());
            pilotos.remove(piloto);

            if((indexPiloto == cola) || (indexPiloto == cola-1))
                pilotos.add(cola,pilotoActual);
            else
                pilotos.add(indexPiloto+numeroRandom,pilotoActual);


        } else{ //RESTAR PUESTOS, ES DECIR ADELANTAR 1 O 2 PUESTOS
            int indexPiloto = pilotos.indexOf(piloto);
            numeroRandom = Math.abs(numeroRandom);
            Piloto pilotoActual = new Piloto(piloto.getNombre(), piloto.getEscuderia(), piloto.getPosicionDeSalida());
            pilotos.remove(piloto);

            if((indexPiloto == 0 ) || (indexPiloto == 1))
                pilotos.add(0, pilotoActual);
            else
                pilotos.add(indexPiloto-numeroRandom, pilotoActual);
        }
    }

    public void nosMoveran(){
        /*Iterator <Piloto> pilotoActual = pilotos.iterator();
        while(pilotoActual.hasNext()){
            moverPiloto(pilotoActual.next());
        } NO SÉ SOLUCIONAR EL ERROR QUE ME DA*/

        for(int i = 0; i < pilotos.size(); i++){
            moverPiloto(pilotos.get(i));
        }
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
        eliminarPilotosDescalificados();
        return pilotos.toString();
    }



}
