import java.io.IOException;

public class MiMain {

    public static void main(String[] args) throws IOException {
        RankingPilotos ranking = new RankingPilotos();


        ranking.ordenarPilotosPorNombre();
        for(int i= 0; i< ranking.pilotos.size(); i++){
            System.out.println(ranking.pilotos.get(i).getNombre());
        }


        ranking.ordenarPilotosPorPosicionDeSalida();
        for(int i= 0; i< ranking.pilotos.size(); i++){
            System.out.println(ranking.pilotos.get(i).getNombre() + ranking.pilotos.get(i).getPosicionDeSalida());
        }
    }
}
