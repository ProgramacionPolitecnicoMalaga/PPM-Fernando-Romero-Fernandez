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
import java.util.Map;
import java.util.TreeMap;

public class XMLGeneratorListaTareasPorEmpleado {

    public XMLGeneratorListaTareasPorEmpleado(Empleado miEmpleado, ListaEmpleadoTarea listaEmpleadoTarea){

            TreeMap<Empleado,Tarea> miMapa = listaEmpleadoTarea.mapaEmpleadoTarea;
            String DNI = "";

            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                Element rootElement = doc.createElement("empleado");
                doc.appendChild(rootElement);
                for (Map.Entry<Empleado,Tarea> entry : miMapa.entrySet()) {
                    //RECORRER MAPA PARA ESCRIBIR EN EL DOCUMENTO XML TODOS LOS NODOS
                    if(entry.getKey() == miEmpleado){
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
                    }
                }
                try {

                    for (Map.Entry<Empleado,Tarea> entry : miMapa.entrySet()) {
                        //RECORRER MAPA PARA ESCRIBIR EN EL DOCUMENTO XML TODOS LOS NODOS
                        if(entry.getKey() == miEmpleado) {
                            Element proyecto = doc.createElement("proyecto");
                            rootElement.appendChild(proyecto);

                            Attr nombreProyecto = doc.createAttribute("nombre");
                            nombreProyecto.setValue(entry.getValue().getProyecto().getNombre());
                            proyecto.setAttributeNode(nombreProyecto);

                            Attr descripcionProyecto = doc.createAttribute("descripcion");
                            descripcionProyecto.setValue(entry.getValue().getProyecto().getDescripcion());
                            proyecto.setAttributeNode(descripcionProyecto);

                            Attr departamentoProyecto = doc.createAttribute("departamento");
                            departamentoProyecto.setValue(entry.getValue().getProyecto().getDepartamento());
                            proyecto.setAttributeNode(departamentoProyecto);

                            Attr productividadProyecto = doc.createAttribute("factorProductividad");
                            productividadProyecto.setValue(String.valueOf(entry.getValue().getProyecto().getFactorProduccion()));
                            proyecto.setAttributeNode(productividadProyecto);

                            for (Map.Entry<Empleado, Tarea> entry2 : miMapa.entrySet()) {
                                System.out.println(entry2.getKey());
                                if(entry2.getKey() == miEmpleado) {
                                    System.out.println("hola");
                                    Element tarea = doc.createElement("tarea");
                                    proyecto.appendChild(tarea);

                                    Attr NombreTareaAtributo = doc.createAttribute("nombre");
                                    NombreTareaAtributo.setValue(entry2.getValue().getNombreTarea());
                                    tarea.setAttributeNode(NombreTareaAtributo);

                                    Attr HorasTareaAtributo = doc.createAttribute("horasEmpleadas");
                                    HorasTareaAtributo.setValue(String.valueOf(entry2.getValue().getHorasEmpleadas()));
                                    rootElement.setAttributeNode(HorasTareaAtributo);
                                }
                            }

                        }

                    }


                        // escribimos el contenido en un archivo .xml
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        DOMSource source = new DOMSource(doc);
                        String ruta2 = "results/"+DNI+".xml";
                        StreamResult result = new StreamResult(new File("results/miDNI.xml"));

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
