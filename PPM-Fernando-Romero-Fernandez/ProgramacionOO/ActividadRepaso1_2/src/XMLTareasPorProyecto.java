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

public class XMLTareasPorProyecto {


    private LinkedList<Tarea> tareasDeMiProyecto = new LinkedList<>();
    private String nombreProyecto = "";

    public XMLTareasPorProyecto(Proyecto miProyecto){

        tareasDeMiProyecto = miProyecto.getListaTareas();

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("proyecto");
            doc.appendChild(rootElement);

            for(int i = 0; i < tareasDeMiProyecto.size();i++) {
                if(tareasDeMiProyecto.get(i).getProyecto().getNombre().equals(miProyecto.getNombre())) {

                    Attr NombreProyectoAtributo = doc.createAttribute("nombre");
                    NombreProyectoAtributo.setValue(tareasDeMiProyecto.get(i).getProyecto().getNombre());
                    nombreProyecto = tareasDeMiProyecto.get(i).getProyecto().getNombre();
                    rootElement.setAttributeNode(NombreProyectoAtributo);

                    Attr DepartamentoProyectoAtributo = doc.createAttribute("departamento");
                    DepartamentoProyectoAtributo.setValue(tareasDeMiProyecto.get(i).getProyecto().getDepartamento());
                    rootElement.setAttributeNode(DepartamentoProyectoAtributo);

                    Element tarea = doc.createElement("tarea");
                    rootElement.appendChild(tarea);

                    Attr descripcion = doc.createAttribute("descripcion");
                    descripcion.setValue(tareasDeMiProyecto.get(i).getDescripcion());
                    tarea.setAttributeNode(descripcion);

                    Attr minuntosEmpleados = doc.createAttribute("minuntosEmpleados");
                    minuntosEmpleados.setValue(String.valueOf(tareasDeMiProyecto.get(i).getMinutosEmpleados()));
                    tarea.setAttributeNode(minuntosEmpleados);

                    Attr nombreEmpleado = doc.createAttribute("nombreEmpleado");
                    nombreEmpleado.setValue(tareasDeMiProyecto.get(i).getEmpleado().getNombre());
                    tarea.setAttributeNode(nombreEmpleado);
                }
            }
            try {

                // escribimos el contenido en un archivo .xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                String rutaXMLResultante = "results/"+nombreProyecto+".xml";
                StreamResult result = new StreamResult(new File(rutaXMLResultante));

                transformer.transform(source, result);


            } catch (TransformerException tfe) {
                tfe.printStackTrace();
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }

        System.out.println("File saved!");
    }

}
