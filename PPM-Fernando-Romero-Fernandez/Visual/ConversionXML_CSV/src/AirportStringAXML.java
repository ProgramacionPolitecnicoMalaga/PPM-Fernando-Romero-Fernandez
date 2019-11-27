import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AirportStringAXML {

    private HashMap<String,String> mapaPaisNodo = new HashMap<>();
    long iniciotiempo = System.nanoTime();

    public AirportStringAXML(){
         BufferedReader Lector = null;
         try {
             Lector = new BufferedReader(new FileReader("files/airports.dat"));
             PrintWriter escritor = new PrintWriter(new File("results/airportsXMLporString.xml"));
             String lineas = Lector.readLine();
             escritor.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
             escritor.write("<aeropuertos>");

             while (null != lineas) {
                 String[] linea = lineas.split(",");
                 lineas = Lector.readLine(); // Siguiente linea
                 String paisActual = linea[3];

                 if(!mapaPaisNodo.containsKey(paisActual)){
                     mapaPaisNodo.put(paisActual,"\n\t<Pais id=" + linea[3]+ ">\n");
                 }

                 String nodoString = "";
                 nodoString +=("\t\t<aeropuerto>\n");
                 nodoString +=("\t\t\t<nombre>" + linea[1] + "</nombre>\n");
                 nodoString +=("\t\t\t<iata>" + linea[4] + "</iata>\n");
                 nodoString +=("\t\t\t<localizacion>\n");
                 nodoString +=("\t\t\t\t<ciudad>" + linea[2] + "</ciudad>\n");
                 nodoString +=("\t\t\t\t<latitud>" + linea[6] + "</latitud>\n");
                 nodoString +=("\t\t\t\t<longitud>" + linea[7] + "</longitud>\n");
                 nodoString +=("\t\t\t</localizacion>\n");
                 nodoString +=("\t\t</aeropuerto>\n");

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
             escritor.write("\n</aeropuertos>");
             escritor.close();

         } catch (IOException e) {
            e.printStackTrace();
         }
    }


    public static void main(String[] args) {
        AirportStringAXML arp1 = new AirportStringAXML();
        long tiempo = System.nanoTime() - arp1.iniciotiempo;
        System.out.println(tiempo + "nanosegundos");


    }
}
