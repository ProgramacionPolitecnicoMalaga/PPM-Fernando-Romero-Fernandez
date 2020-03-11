package com.politecnicomalaga.DAO;

import com.politecnicomalaga.modelo.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO2 {

    DBConn dbConn;

    public EmpleadoDAO2() throws SQLException {
        dbConn = new DBConn();
    }

    public ArrayList<Empleado> buscar(String nombreABuscar){
        ArrayList<Empleado> listaPersonasBuscadas = new ArrayList<>();
        try{
            ResultSet rs = dbConn.read("SELECT * FROM Empleado WHERE nombre LIKE '%" + nombreABuscar + "%'");
            while(rs.next()){
                listaPersonasBuscadas.add(new Empleado(rs.getInt("id"), rs.getString("nombre"), rs.getInt("edad")));
            }
            return listaPersonasBuscadas;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaPersonasBuscadas;
    }

    public void insertar(String nombreEmpleado, String edadEmpleado){
        try{
            dbConn.create("INSERT INTO Empleado(nombre, edad) VALUES('" + nombreEmpleado + "','" + edadEmpleado + "')");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void modificar(String idEmpleado, String nombreEmpleado, String edadEmpleado){
        try{
            dbConn.update("UPDATE Empleado SET nombre = '" + nombreEmpleado + "', edad = '" + edadEmpleado + "' WHERE id = '" + idEmpleado +"'");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrar(String idEmpleado){
        try{
            dbConn.delete("DELETE FROM Empleado WHERE id = '" + idEmpleado +"'");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
