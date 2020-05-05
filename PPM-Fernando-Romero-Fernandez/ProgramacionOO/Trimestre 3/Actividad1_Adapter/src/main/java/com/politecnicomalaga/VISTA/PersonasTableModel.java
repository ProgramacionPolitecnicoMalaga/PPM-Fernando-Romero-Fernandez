package com.politecnicomalaga.VISTA;

import com.politecnicomalaga.MODELO.Persona;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonasTableModel extends AbstractTableModel {
    private final static int COLUMNA_NOMBRE = 0;
    private final static int COLUMNA_APELLIDOS = 1;
    private final static int COLUMNA_EDAD = 2;

    private List<Persona> listaPersonas;
    private String[] nombreColumnas = {"Nombre","Apellidos","Edad"};

    public PersonasTableModel(List<Persona> listaPersonas){
        this.listaPersonas = listaPersonas;
    }

    public int getRowCount() {
        return listaPersonas.size();
    }

    public int getColumnCount() {
        return nombreColumnas.length;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        if ((rowIndex > -1) && (rowIndex < listaPersonas.size())){
            if (columnIndex == COLUMNA_NOMBRE) listaPersonas.get(rowIndex).setNombre((String) aValue);
            else if (columnIndex == COLUMNA_APELLIDOS) listaPersonas.get(rowIndex).setApellidos((String) aValue);
            else if (columnIndex == COLUMNA_EDAD) listaPersonas.get(rowIndex).setEdad((Integer) aValue);
        }
        fireTableCellUpdated(rowIndex,columnIndex);
    }

    public Object getValueAt(int fila, int columna) {
        if ((fila > -1) && (fila < listaPersonas.size())){
            switch(columna){
                case COLUMNA_NOMBRE: return listaPersonas.get(fila).getNombre();
                case COLUMNA_APELLIDOS: return listaPersonas.get(fila).getApellidos();
                case COLUMNA_EDAD: return listaPersonas.get(fila).getEdad();
            }
        }
        return null;
    }

    public void removeRow(int row){
        if ((row > -1) && (row < listaPersonas.size())){
            int confirmacionBorrar = JOptionPane.showConfirmDialog(null,"¿Desea borrar la fila?","Borrado",JOptionPane.WARNING_MESSAGE);
            if (confirmacionBorrar == JOptionPane.OK_OPTION) {
                listaPersonas.remove(row);
                fireTableRowsDeleted(row,row);
            }
        }
    }

    public void addRow(){
        listaPersonas.add(new Persona("","",0));
        fireTableDataChanged();
    }

    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case COLUMNA_NOMBRE:
            case COLUMNA_APELLIDOS: return String.class;
            case COLUMNA_EDAD: return Integer.class;
        }
        return null;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
