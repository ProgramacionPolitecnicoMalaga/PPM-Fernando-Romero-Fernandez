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
import java.util.*;

public class XMLGeneratorListaTareasPorEmpleado {

    public XMLGeneratorListaTareasPorEmpleado(Empleado miEmpleado, ListaEmpleadoTarea listaEmpleadoTarea){

            TreeMap<Empleado, LinkedList<Tarea>> miMapa = listaEmpleadoTarea.mapaEmpleadoTarea;
            LinkedList lista = new LinkedList();
            String DNI = "";

            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement("empleado");
                doc.appendChild(rootElement);
                for (Map.Entry<Empleado, LinkedList<Tarea>> entry : miMapa.entrySet()) {
                    //CREAMOS EL NODO DEL EMPLEADO ACTUAL
                    if (entry.getKey() == miEmpleado) {
                        Attr DNIAtributo = doc.createAttribute("DNI");
                        DNIAtributo.setValue(entry.getKey().getDNI());
                        DNI = entry.getKey().getDNI();
                        rootElement.setAttributeNode(DNIAtributo);

                        Attr NombreAtributo = doc.createAttribute("nombre");
                        NombreAtributo.setValue(entry.getKey().getNombre());
                        rootElement.setAttributeNode(NombreAtributo);

                        Attr ApellidosAtributo = doc.createAttribute("apellidos");
                        ApellidosAtributo.setValue(entry.getKey().getApellidos());
                        rootElement.setAttributeNode(ApellidosAtributo);

                        Attr CategoriaAtributo = doc.createAttribute("categoria");
                        CategoriaAtributo.setValue(entry.getKey().getCategoria().getCategoria());
                        rootElement.setAttributeNode(CategoriaAtributo);

                        for (int i = 0; i < entry.getValue().size(); i++) {

                            Element proyecto = doc.createElement("proyecto");
                            rootElement.appendChild(proyecto);

                            Attr nombreProyecto = doc.createAttribute("id");
                            nombreProyecto.setValue(entry.getValue().get(i).getProyecto().getNombre());
                            proyecto.setAttributeNode(nombreProyecto);

                            Attr descripcionProyecto = doc.createAttribute("descripcion");
                            descripcionProyecto.setValue(entry.getValue().get(i).getProyecto().getDescripcion());
                            proyecto.setAttributeNode(descripcionProyecto);

                            Attr departamentoProyecto = doc.createAttribute("departamento");
                            departamentoProyecto.setValue(entry.getValue().get(i).getProyecto().getDepartamento());
                            proyecto.setAttributeNode(departamentoProyecto);

                            Attr productividadProyecto = doc.createAttribute("factorProductividad");
                            productividadProyecto.setValue(String.valueOf(entry.getValue().get(i).getProyecto().getFactorProduccion()));
                            proyecto.setAttributeNode(productividadProyecto);


                        }

                        for (int j = 0; j < entry.getValue().size(); j++) {

                            Element tarea = doc.createElement("tarea");
                            doc.getElementsByTagName("proyecto").item(j).appendChild(tarea);

                            Attr NombreTareaAtributo = doc.createAttribute("nombre");
                            NombreTareaAtributo.setValue(entry.getValue().get(j).getNombreTarea());
                            tarea.setAttributeNode(NombreTareaAtributo);

                            Attr HorasTareaAtributo = doc.createAttribute("horasEmpleadas");
                            HorasTareaAtributo.setValue(String.valueOf(entry.getValue().get(j).getHorasEmpleadas()));
                            tarea.setAttributeNode(HorasTareaAtributo);

                        }
                    }


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
