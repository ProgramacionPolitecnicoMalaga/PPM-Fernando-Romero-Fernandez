package com.politecnicomalaga.DAO;

import com.politecnicomalaga.MODELO.Credencial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CredencialDAO {

    DBConn dBConn;
    Connection conn;

    public CredencialDAO(){
        dBConn = new DBConn();
        conn = dBConn.getConn();
    }

    public ArrayList<Credencial> buscar(){
        ArrayList<Credencial> listaCredencialesBuscadas = new ArrayList<>();
        try{
            ResultSet rs = conn.prepareStatement("SELECT * FROM Credenciales").executeQuery();
            while(rs.next()){
                listaCredencialesBuscadas.add(new Credencial(rs.getString("nombre"), rs.getInt("algoritmo")));
            }
            return listaCredencialesBuscadas;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaCredencialesBuscadas;
    }

    public Credencial obtenerParaValidar(String nombreABuscar){
        Credencial credencial = null;
        try{
            ResultSet rs = conn.prepareStatement("SELECT * FROM Credenciales WHERE nombre LIKE '" + nombreABuscar + "'").executeQuery();
            while(rs.next()){
                credencial = new Credencial(rs.getString("nombre"),rs.getString("hash"),rs.getString("salt"),rs.getInt("algoritmo"));
            }
            return credencial;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return credencial;
    }

    public void registrar(String nombreCredencial, int algoritmoAUsar, String hashCreado, String saltGenerada){
        try{
            conn.prepareStatement("INSERT INTO Credenciales(nombre, algoritmo, hash, salt) VALUES('" + nombreCredencial + "','" + algoritmoAUsar + "','" + hashCreado + "','" + saltGenerada + "')").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrarUsuario(String usuarioABorrar){
        try{
            conn.prepareStatement("DELETE FROM Credenciales WHERE nombre LIKE '" + usuarioABorrar + "'").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
