import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ArchivoXML {

    private String ruta, tagName;

    public ArchivoXML(String ruta, String tagName){
        this.ruta = ruta;
        this.tagName = tagName;
    }

    public NodeList ObtenerListaDeNodos(){
        try{
            File archivo = new File(ruta); //CREAMOS UN OBJETO FILE CON NUESTRO ARCHIVO XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document documento = dBuilder.parse(archivo);

            documento.getDocumentElement().normalize();
            NodeList listaNodos = documento.getElementsByTagName(tagName);

            return listaNodos;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
