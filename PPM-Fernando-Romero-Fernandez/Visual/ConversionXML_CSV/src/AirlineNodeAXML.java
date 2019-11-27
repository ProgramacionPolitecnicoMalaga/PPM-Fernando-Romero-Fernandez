import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AirlineNodeAXML {

    long iniciotiempo = System.nanoTime();

    public AirlineNodeAXML(){
        BufferedReader Lector = null;
        try {
            Lector = new BufferedReader(new FileReader("files/airlines.dat"));
            String lineas = Lector.readLine();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //elemento raiz
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("aerolineas");
            doc.appendChild(rootElement);


            while (null != lineas) {
                String[] linea = lineas.split(",");
                lineas = Lector.readLine();

                try {
                    Element Pais = doc.createElement("Pais");

                    rootElement.appendChild(Pais);
                    Attr attr = doc.createAttribute("id");
                    attr.setValue(linea[0]);
                    Pais.setAttributeNode(attr);

                    Element aerolinea = doc.createElement("aerolinea");
                    Pais.appendChild(aerolinea);

                    //nombre
                    Element nombre = doc.createElement("nombre");
                    nombre.appendChild(doc.createTextNode(linea[1]));
                    aerolinea.appendChild(nombre);

                    // iata
                    Element iata = doc.createElement("iata");
                    iata.appendChild(doc.createTextNode(linea[4]));
                    aerolinea.appendChild(iata);

                    // codigoLlamada
                    Element codigoLlamada = doc.createElement("codigoLlamada");
                    iata.appendChild(doc.createTextNode(linea[5]));
                    aerolinea.appendChild(codigoLlamada);



                    // escribimos el contenido en un archivo .xml
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File("results/airlinesXMLporNodos.xml"));

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
        AirlineNodeAXML arp1 = new AirlineNodeAXML();
        long tiempo = System.nanoTime() - arp1.iniciotiempo;
        System.out.println(tiempo + "nanosegundos");
    }


}
