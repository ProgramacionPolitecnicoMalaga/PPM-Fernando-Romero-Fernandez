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
import java.io.File;
import java.util.LinkedList;

public class XMLNominas {

    private LinkedList<Nomina> misNominas = new LinkedList<>();

    public XMLNominas(){

        Nominas nominas = new Nominas();
        misNominas = nominas.generarNominas();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("nominas");
            doc.appendChild(rootElement);

            for(int i = 0; i < misNominas.size();i++) {

                Element nomina = doc.createElement("nomina");
                rootElement.appendChild(nomina);

                Attr DNIAtributo = doc.createAttribute("DNI");
                DNIAtributo.setValue(misNominas.get(i).getEmpleado().getDNI());
                nomina.setAttributeNode(DNIAtributo);

                Attr NombreEmpleadoAtributo2 = doc.createAttribute("nombreEmpleado");
                NombreEmpleadoAtributo2.setValue(misNominas.get(i).getEmpleado().getNombre());
                nomina.setAttributeNode(NombreEmpleadoAtributo2);

                Attr categoriaEmpleado = doc.createAttribute("categoria");
                categoriaEmpleado.setValue(misNominas.get(i).getEmpleado().getCategoria().getStringCategoria());
                nomina.setAttributeNode(categoriaEmpleado);

                Attr sueldoBase = doc.createAttribute("sueldoBase");
                sueldoBase.setValue(String.valueOf(misNominas.get(i).getEmpleado().getCategoria().getSueldo()));
                nomina.setAttributeNode(sueldoBase);

                Attr complementos = doc.createAttribute("complementos");
                complementos.setValue(String.valueOf(misNominas.get(i).getComplementos()));
                nomina.setAttributeNode(complementos);

                Attr sueldoTotal = doc.createAttribute("sueldoTotal");
                sueldoTotal.setValue(String.valueOf(misNominas.get(i).getSueldoTotal()));
                nomina.setAttributeNode(sueldoTotal);
            }
            try {

                // escribimos el contenido en un archivo .xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                String rutaXMLResultante = "results/nominas.xml";
                StreamResult result = new StreamResult(new File(rutaXMLResultante));

                transformer.transform(source, result);


            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }

        } catch (
                ParserConfigurationException ex) {
            ex.printStackTrace();
        }
        System.out.println("Nóminas creadas");
    }
}
