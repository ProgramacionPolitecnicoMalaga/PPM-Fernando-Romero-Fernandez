import java.io.IOException;

public class MiMain {

    public static void main(String[] args) throws IOException {
        RankingPilotos ranking = new RankingPilotos();

        ranking.ordenarPilotosPorPosicionDeSalida();
        System.out.println("Ordenado por Posicion Salida \n" + ranking.pilotos);

        ranking.ordenarPilotosPorNombre();
        System.out.println("Ordenado por Nombre \n" + ranking.pilotos);



    }
}
