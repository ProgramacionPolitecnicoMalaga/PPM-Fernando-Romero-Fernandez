import java.io.*;
import java.util.ArrayList;

public class ArchivoCSV {

    ArrayList<String> listaEspecialidadesArray = new ArrayList<>();

    public ArchivoCSV() {

    }

    public ArrayList cargarCSV() throws IOException {

        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/especialidades.csv"));
            String lineas = Lector.readLine();
            while (null != lineas) {
                String[] linea = lineas.split(";");
                lineas = Lector.readLine();
                listaEspecialidadesArray.add(linea[1]);
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }

        return listaEspecialidadesArray;
    }


}
