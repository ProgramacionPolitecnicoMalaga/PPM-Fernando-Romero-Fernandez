import java.io.IOException;

public class TestCarrera {

    public static void main(String[] args) throws IOException {
        RankingPilotos ranking = new RankingPilotos();

        ranking.nosMoveran();
        System.out.println(ranking);
        ranking.nosMoveran();
        System.out.println(ranking);
        ranking.nosMoveran();
        System.out.println(ranking);


    }
}
