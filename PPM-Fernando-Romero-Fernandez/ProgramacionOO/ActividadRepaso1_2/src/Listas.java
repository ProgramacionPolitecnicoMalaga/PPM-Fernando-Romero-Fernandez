import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;

public class Listas {

    LinkedList<Empleado> listaEmpleados = new LinkedList<>();
    LinkedList<Proyecto> listaProyectos = new LinkedList<>();

    public Listas(){

        //===========================================RELLENAR NUESTRA LISTA DE EMPLEADOS=================================================

        ArchivoXML arch1 = new ArchivoXML("files/empleados.xml","empleado");
        NodeList listaNodosEmpleados = arch1.ObtenerListaDeNodos();

        for(int i = 0; i < listaNodosEmpleados.getLength();i++){
            Node miNodoActual = listaNodosEmpleados.item(i);

            String dniEmpleado = miNodoActual.getAttributes().getNamedItem("DNI").getTextContent();
            String nombreEmpleado = miNodoActual.getAttributes().getNamedItem("nombre").getTextContent();
            String apellidosEmpleado = miNodoActual.getAttributes().getNamedItem("apellidos").getTextContent();
            Double productividadEmpleado = Double.parseDouble(miNodoActual.getAttributes().getNamedItem("productividad").getTextContent());
            int categoriaEmpleado = Integer.parseInt(miNodoActual.getAttributes().getNamedItem("categoria").getTextContent());
            Categoria miCategoria = new Categoria(categoriaEmpleado);

            Empleado miEmpleado = new Empleado(nombreEmpleado,apellidosEmpleado,dniEmpleado,productividadEmpleado,miCategoria);
            listaEmpleados.add(miEmpleado);
        }

        //===========================================RELLENAR NUESTRA LISTA DE PROYECTOS=================================================

        ArchivoXML arch2 = new ArchivoXML("files/proyectos.xml","proyecto");
        NodeList listaNodosProyectos = arch2.ObtenerListaDeNodos();

        for(int i = 0; i < listaNodosProyectos.getLength();i++){
            Node miNodoActual = listaNodosProyectos.item(i);

            String nombreProyecto = miNodoActual.getAttributes().getNamedItem("nombre").getTextContent();
            String descripcionProyecto = miNodoActual.getTextContent();
            String departamentoProyecto = miNodoActual.getAttributes().getNamedItem("departamento").getTextContent();
            double fProduccionProyecto = Double.parseDouble(miNodoActual.getAttributes().getNamedItem("fprod").getTextContent());


            Proyecto miProyecto = new Proyecto(nombreProyecto,descripcionProyecto,departamentoProyecto,fProduccionProyecto);
            listaProyectos.add(miProyecto);

        }

        //===========================================RELLENAR NUESTRA LISTA DE TAREAS=================================================



    }

    public LinkedList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public LinkedList<Proyecto> getListaProyectos() {
        return listaProyectos;
    }

}
