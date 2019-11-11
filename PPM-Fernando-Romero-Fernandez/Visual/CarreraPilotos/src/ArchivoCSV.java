import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoCSV {

    private String ruta;
    ArrayList<Piloto> listaPilotos = new ArrayList<>();


    public ArchivoCSV(String ruta){
        this.ruta = ruta;
    }

    public ArrayList cargarCSV() throws IOException {

        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/pilotos.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split(";");
                lineas = Lector.readLine();
                Piloto piloto1 = new Piloto(linea[1],linea[2],Integer.parseInt(linea[0]));
                listaPilotos.add(piloto1);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        return listaPilotos;
    }

}
