import java.io.*;
import java.util.ArrayList;

public class ArchivoCSV {

    private String ruta;
    ArrayList<Piloto> listaPilotos = new ArrayList<>();


    public ArchivoCSV(String ruta){
        this.ruta = ruta;
    }

    public ArchivoCSV() {

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

    public void escribirCSV(ArrayList<Piloto> listaPilotos){

        try{

            PrintWriter escritor = new PrintWriter(new File("files/newpilotos.csv"));
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < listaPilotos.size(); i++){

                builder.append(listaPilotos.get(i).getPosicionDeSalida());
                builder.append(";");
                builder.append(listaPilotos.get(i).getNombre());
                builder.append(";");
                builder.append(listaPilotos.get(i).getEscuderia());
                builder.append("\n");
                System.out.println("Escribiendo...");


            }
            escritor.write(builder.toString());
            escritor.close();

            System.out.println("Archivo CSV creado!");

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }

}
