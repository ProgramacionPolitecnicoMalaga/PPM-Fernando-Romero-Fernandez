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

public class XMLTareasPorEmpleado {

    public XMLTareasPorEmpleado(Empleado miEmpleado){

        LinkedList<Tarea> tareasDeMiEmpleado = miEmpleado.getListaTareas();
        String DNI = "";

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            //EMPLEADO

            Element rootElement = doc.createElement("empleado");
            doc.appendChild(rootElement);

            Attr DNIAtributo = doc.createAttribute("DNI");
            DNIAtributo.setValue(miEmpleado.getDNI());
            DNI = miEmpleado.getDNI();
            rootElement.setAttributeNode(DNIAtributo);

            Attr NombreAtributo = doc.createAttribute("nombre");
            NombreAtributo.setValue(miEmpleado.getNombre());
            rootElement.setAttributeNode(NombreAtributo);

            Attr ApellidosAtributo = doc.createAttribute("apellidos");
            ApellidosAtributo.setValue(miEmpleado.getApellidos());
            rootElement.setAttributeNode(ApellidosAtributo);

            Attr CategoriaAtributo = doc.createAttribute("categoria");
            CategoriaAtributo.setValue(miEmpleado.getCategoria().getStringCategoria());
            rootElement.setAttributeNode(CategoriaAtributo);

            for (int i = 0; i < tareasDeMiEmpleado.size(); i++) {
                //PROYECTO

                Element proyecto = doc.createElement("proyecto");
                rootElement.appendChild(proyecto);

                Attr nombreProyecto = doc.createAttribute("id");
                nombreProyecto.setValue(tareasDeMiEmpleado.get(i).getProyecto().getNombre());
                proyecto.setAttributeNode(nombreProyecto);

                Attr descripcionProyecto = doc.createAttribute("descripcion");
                descripcionProyecto.setValue(tareasDeMiEmpleado.get(i).getProyecto().getDescripcion());
                proyecto.setAttributeNode(descripcionProyecto);

                Attr departamentoProyecto = doc.createAttribute("departamento");
                departamentoProyecto.setValue(tareasDeMiEmpleado.get(i).getProyecto().getDepartamento());
                proyecto.setAttributeNode(departamentoProyecto);

                Attr productividadProyecto = doc.createAttribute("factorProductividad");
                productividadProyecto.setValue(String.valueOf(tareasDeMiEmpleado.get(i).getProyecto().getFactorProduccion()));
                proyecto.setAttributeNode(productividadProyecto);

                //TAREA

                Element tarea = doc.createElement("tarea");
                doc.getElementsByTagName("proyecto").item(i).appendChild(tarea);

                Attr NombreTareaAtributo = doc.createAttribute("descripcion");
                NombreTareaAtributo.setValue(tareasDeMiEmpleado.get(i).getDescripcion());
                tarea.setAttributeNode(NombreTareaAtributo);

                Attr HorasTareaAtributo = doc.createAttribute("minutosEmpleados");
                HorasTareaAtributo.setValue(String.valueOf(tareasDeMiEmpleado.get(i).getMinutosEmpleados()));
                tarea.setAttributeNode(HorasTareaAtributo);

            }
            try {
                // escribimos el contenido en un archivo .xml
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                String ruta2 = "results/"+DNI+".xml";
                StreamResult result = new StreamResult(new File(ruta2));

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
