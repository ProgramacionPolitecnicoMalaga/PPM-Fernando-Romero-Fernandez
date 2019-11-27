import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AirlineStringAXML {

    private HashMap<String,String> mapaPaisNodo = new HashMap<>();
    long iniciotiempo = System.nanoTime();

    public AirlineStringAXML(){
        BufferedReader Lector = null;

        try {
            Lector = new BufferedReader(new FileReader("files/airlines.dat"));
            PrintWriter escritor = new PrintWriter(new File("results/airlanesXMLporString.xml"));
            String lineas = Lector.readLine();
            escritor.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            escritor.write("<aerolineas>");

            while (null != lineas) {
                String[] linea = lineas.split(",");
                lineas = Lector.readLine(); // Siguiente linea
                String paisActual = linea[6];

                if(!mapaPaisNodo.containsKey(paisActual)){
                    mapaPaisNodo.put(paisActual,"\n\t<Pais id=" + linea[6]+ ">\n");
                }

                String nodoString = "";
                nodoString +=("\t\t<aerolinea id="+'"' +linea[0]+'"' +">\n");
                nodoString +=("\t\t\t<nombre>" + linea[1] + "</nombre>\n");
                nodoString +=("\t\t\t<iata>" + linea[4] + "</iata>\n");
                nodoString +=("\t\t\t<codigoLlamada>" + linea[5] + "</codigoLlamada>\n");
                nodoString +=("\t\t</aerolinea>\n");

                mapaPaisNodo.put(paisActual,this.mapaPaisNodo.get(paisActual)+nodoString);

            }

            for (Map.Entry<String,String> entry : mapaPaisNodo.entrySet()) {
                //ESCRIBIR AL FINAL DE CADA NODO PAIS SU ETIQUETA DE CIERRE
                mapaPaisNodo.put(entry.getKey(),entry.getValue()+"\n\t</Pais>");
            }

            for (Map.Entry<String,String> entry : mapaPaisNodo.entrySet()) {
                //RECORRER MAPA PARA ESCRIBIR EN EL DOCUMENTO XML TODOS LOS NODOS
                escritor.write(entry.getValue());
            }
            escritor.write("\n</aerolineas>");
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AirlineStringAXML air1 = new AirlineStringAXML();
        long tiempo = System.nanoTime() - air1.iniciotiempo;
        System.out.println(tiempo + "nanosegundos");
    }
}
