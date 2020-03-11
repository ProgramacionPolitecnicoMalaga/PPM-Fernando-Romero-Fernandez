package com.politecnicomalaga.vista;

import com.politecnicomalaga.DAO.EmpleadoDAO;
import com.politecnicomalaga.modelo.Empleado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfazCRUD {
    private JTextField txtNombreABuscar;
    private JButton buscarButton;
    private JPanel InterfazCRUD;
    private JTable tablaEmpleados;
    private JButton btnInsertar;
    private JButton btnModificar;
    private JButton btnBorrar;
    private JPanel controlBotones;
    private JPanel controlConsultar;
    private JScrollPane controlTabla;
    private ArrayList<Empleado> empleados;
    DefaultTableModel tableModelEmpleados;
    private InterfazCRUD estaVentana;
    private int rows;

    public InterfazCRUD(){
        estaVentana = this;
        empleados = new ArrayList<>();

        tableModelEmpleados = new DefaultTableModel();
        tableModelEmpleados.addColumn("ID");
        tableModelEmpleados.addColumn("Nombre");
        tableModelEmpleados.addColumn("Edad");
        tablaEmpleados.setModel(tableModelEmpleados);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                empleados = empleadoDAO.buscar(txtNombreABuscar.getText());
                crearTablaEmpleados(empleados);

            }
        });
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DialogoCrearEmpleado dialogoCrearEmpleado = new DialogoCrearEmpleado(estaVentana);
                dialogoCrearEmpleado.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogoCrearEmpleado.pack();
                dialogoCrearEmpleado.setVisible(true);

                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                empleadoDAO.insertar(dialogoCrearEmpleado.getTxtNombre(),dialogoCrearEmpleado.getTxtEdad());
                Object[] rowData = {"?",dialogoCrearEmpleado.getTxtNombre(),dialogoCrearEmpleado.getTxtEdad()};
                tableModelEmpleados.addRow(rowData);
                tablaEmpleados.setModel(tableModelEmpleados);
                rows = tablaEmpleados.getRowCount();
            }
        });
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tablaEmpleados.getSelectedRow();
                String idValue = tablaEmpleados.getModel().getValueAt(row, 0).toString();
                String nombreValue = tablaEmpleados.getModel().getValueAt(row, 1).toString();
                String edadValue = tablaEmpleados.getModel().getValueAt(row, 2).toString();

                DialogoModificarEmpleado dialogoModificarEmpleado = new DialogoModificarEmpleado(estaVentana, idValue, nombreValue, edadValue);
                dialogoModificarEmpleado.setLocationRelativeTo(SwingUtilities.getRoot((Component) actionEvent.getSource()));
                dialogoModificarEmpleado.pack();
                dialogoModificarEmpleado.setVisible(true);

                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                String idValueModificado = dialogoModificarEmpleado.getTxtID();
                String nombreValueModificado = dialogoModificarEmpleado.getTxtNombre();
                String edadValueModificado = dialogoModificarEmpleado.getTxtEdad();

                empleadoDAO.modificar(idValueModificado,nombreValueModificado,edadValueModificado);
                JOptionPane.showMessageDialog(null, "Empleado modificado!",null,JOptionPane.YES_OPTION);

                tablaEmpleados.getModel().setValueAt(nombreValueModificado,row,1);
                tablaEmpleados.getModel().setValueAt(edadValueModificado,row,2);
            }
        });
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = tablaEmpleados.getSelectedRow();
                String idValue = tablaEmpleados.getModel().getValueAt(row, 0).toString();
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                empleadoDAO.borrar(idValue);
                tableModelEmpleados.removeRow(row);
                tablaEmpleados.setModel(tableModelEmpleados);
                rows = tablaEmpleados.getRowCount();
            }
        });
    }

    public void crearTablaEmpleados(ArrayList<Empleado> listaEmpleados){
        vaciarTablaEmpleados();
        Object filaDatos[] = new Object[3];
        for(int i = 0; i < listaEmpleados.size(); i++){
            filaDatos[0] = listaEmpleados.get(i).getId();
            filaDatos[1] = listaEmpleados.get(i).getNombre();
            filaDatos[2] = listaEmpleados.get(i).getEdad();
            tableModelEmpleados.addRow(filaDatos);
        }
    }

    public void vaciarTablaEmpleados(){
        int a = tableModelEmpleados.getRowCount()-1;
        for (int i = a; i >= 0; i--) {
            tableModelEmpleados.removeRow(tableModelEmpleados.getRowCount()-1);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InterfazCRUD");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new InterfazCRUD().InterfazCRUD);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
