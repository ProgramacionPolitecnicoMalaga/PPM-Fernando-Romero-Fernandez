import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class AirportNodeAXML {

    long iniciotiempo = System.nanoTime();

    public AirportNodeAXML(){
        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/airports.dat"));
            String lineas = Lector.readLine();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("aeropuertos");
            doc.appendChild(rootElement);


            while (null != lineas) {
                String[] linea = lineas.split(",");
                lineas = Lector.readLine();

                try {
                    Element Pais = doc.createElement("Pais");

                        rootElement.appendChild(Pais);
                        Attr attr = doc.createAttribute("name");
                        attr.setValue(linea[3]);
                        Pais.setAttributeNode(attr);

                        Element aeropuerto = doc.createElement("aeropuerto");
                        Pais.appendChild(aeropuerto);

                        Element nombre = doc.createElement("nombre");
                        nombre.appendChild(doc.createTextNode(linea[1]));
                        aeropuerto.appendChild(nombre);

                        // iata
                        Element iata = doc.createElement("iata");
                        iata.appendChild(doc.createTextNode(linea[4]));
                        aeropuerto.appendChild(iata);

                        // Etiqueta aeropuerto
                        Element localizacion = doc.createElement("localizacion");
                        aeropuerto.appendChild(localizacion);

                        // Etiqueta ciudad en localizacion
                        Element ciudad = doc.createElement("ciudad");
                        ciudad.appendChild(doc.createTextNode(linea[2]));
                        localizacion.appendChild(ciudad);

                        // Etiqueta ciudad en localizacion
                        Element latitud = doc.createElement("latitud");
                        latitud.appendChild(doc.createTextNode(linea[6]));
                        localizacion.appendChild(latitud);

                        // Etiqueta ciudad en localizacion
                        Element longitud = doc.createElement("longitud");
                        longitud.appendChild(doc.createTextNode(linea[7]));
                        localizacion.appendChild(longitud);


                    // escribimos el contenido en un archivo .xml
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("results/airportXMLporNodos.xml"));

                    transformer.transform(source, result);


                } catch (TransformerException tfe) {
                    tfe.printStackTrace();
                }

            }
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("File saved!");
    }

    public static void main(String[] args) {
        AirportNodeAXML arp1 = new AirportNodeAXML();
        long tiempo = System.nanoTime() - arp1.iniciotiempo;
        System.out.println(tiempo + "nanosegundos");
    }
}
