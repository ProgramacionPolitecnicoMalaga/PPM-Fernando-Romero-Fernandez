package com.politecnicomalaga.DAO;

import com.politecnicomalaga.modelo.Empleado;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadoDAO {

    String url = "jdbc:mysql://vps791421.ovh.net:3306/Empleados";
    String usuario = "empleadosuser";
    String password = "Perro20";
    Connection dbConn;

    public EmpleadoDAO(){
        try {
            dbConn = DriverManager.getConnection(url,usuario,password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Empleado> buscar(String nombreABuscar){
        ArrayList<Empleado> listaPersonasBuscadas = new ArrayList<>();
        try{
            ResultSet rs = dbConn.prepareStatement("SELECT * FROM Empleado WHERE nombre LIKE '%" + nombreABuscar + "%'").executeQuery();
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
            dbConn.prepareStatement("INSERT INTO Empleado(nombre, edad) VALUES('" + nombreEmpleado + "','" + edadEmpleado + "')").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void modificar(String idEmpleado, String nombreEmpleado, String edadEmpleado){
        try{
            dbConn.prepareStatement("UPDATE Empleado SET nombre = '" + nombreEmpleado + "', edad = '" + edadEmpleado + "' WHERE id = '" + idEmpleado +"'").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrar(String idEmpleado){
        try{
            dbConn.prepareStatement("DELETE FROM Empleado WHERE id = '" + idEmpleado +"'").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
