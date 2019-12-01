import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class InterfazGrafica {
    private JPanel InterfazGrafica;
    private JComboBox comboProyectos;
    private JComboBox comboEmpleados;
    private JTextField txtNombreTarea;
    private JTextField txtDescripcionTarea;
    private JTextField txtHorasEmpleadasTarea;
    private JTextField txtDepartamento;
    private JTextField txtFactorProductividad;
    private JButton btnAñadirTarea;
    private JTextArea txtListaTareas;
    private JTextArea txtListaProyectos;
    private JPanel PanelControl;
    private JTextField txtSueldoBase;
    private JTextField txtComplementos;
    private JPanel PanelXML;
    private JButton btnListaTareasEmpleado;
    private JButton btnListaTareasProyecto;
    private JButton btnListaNominas;


    public InterfazGrafica(){

        ListaEmpleadoTarea listaEmpleadoTarea = new ListaEmpleadoTarea();

        ArchivoXML miArchivoXML = new ArchivoXML("files/empleados.xml","empleado");
        NodeList listaNodosEmpleados = miArchivoXML.ObtenerListaDeNodos();
        for(int i = 0; i < listaNodosEmpleados.getLength();i++){
            Node miNodoActual = listaNodosEmpleados.item(i);

            String dniEmpleado = miNodoActual.getAttributes().getNamedItem("DNI").getTextContent();
            String nombreEmpleado = miNodoActual.getAttributes().getNamedItem("nombre").getTextContent();
            String apellidosEmpleado = miNodoActual.getAttributes().getNamedItem("apellidos").getTextContent();
            Double productividadEmpleado = Double.parseDouble(miNodoActual.getAttributes().getNamedItem("productividad").getTextContent());
            int categoriaEmpleado = Integer.parseInt(miNodoActual.getAttributes().getNamedItem("categoria").getTextContent());
            Categoria miCategoria = new Categoria(categoriaEmpleado);

            Empleado miEmpleado2 = new Empleado(nombreEmpleado,apellidosEmpleado,dniEmpleado,productividadEmpleado,miCategoria);
            comboEmpleados.addItem(miEmpleado2);

        }

        ArchivoXML miArchivoXML2 = new ArchivoXML("files/proyectos.xml","proyecto");
        NodeList listaNodosEmpleados2 = miArchivoXML2.ObtenerListaDeNodos();
        for(int i = 0; i < listaNodosEmpleados2.getLength();i++){
            Node miNodoActual = listaNodosEmpleados2.item(i);

            String nombreProyecto = miNodoActual.getAttributes().getNamedItem("nombre").getTextContent();
            String descripcionProyecto = miNodoActual.getTextContent();
            String departamentoProyecto = miNodoActual.getAttributes().getNamedItem("departamento").getTextContent();
            Double fProduccionProyecto = Double.parseDouble(miNodoActual.getAttributes().getNamedItem("fprod").getTextContent());


            Proyecto miProyecto2 = new Proyecto(nombreProyecto,descripcionProyecto,departamentoProyecto,fProduccionProyecto);
            comboProyectos.addItem(miProyecto2);

        }


        btnListaTareasEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Empleado miEmpleado = (Empleado) comboEmpleados.getSelectedItem();
                XMLGeneratorListaTareasPorEmpleado xmlGenerator = new XMLGeneratorListaTareasPorEmpleado(miEmpleado,listaEmpleadoTarea);
            }
        });
        btnAñadirTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nombreTarea = txtNombreTarea.getText();
                String descripcion = txtDescripcionTarea.getText();
                Double horasEmpleadas = Double.parseDouble(txtHorasEmpleadasTarea.getText());
                Empleado miEmpleado = (Empleado) comboEmpleados.getSelectedItem();
                Proyecto proyecto = (Proyecto) comboProyectos.getSelectedItem();

                Tarea tarea1 = new Tarea(nombreTarea,descripcion,horasEmpleadas,miEmpleado,proyecto);
                LinkedList<Tarea> listaArray = tarea1.getEmpleado().getListaTareas();
                listaArray.addLast(tarea1);


                listaEmpleadoTarea.mapaEmpleadoTarea.put(miEmpleado, listaArray);
                System.out.println("Tarea añadida al mapa!");
                System.out.println(listaEmpleadoTarea.mapaEmpleadoTarea);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Empleados y Proyectos");
        frame.setContentPane(new InterfazGrafica().InterfazGrafica);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
