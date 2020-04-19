package com.politecnicomalaga.DAO;


import com.politecnicomalaga.MODELO.Credencial;
import com.politecnicomalaga.MODELO.Mensaje;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MensajeDAO {

    DBConn dBConn;
    Connection conn;

    public MensajeDAO(){
        dBConn = new DBConn();
        conn = dBConn.getConn();
    }

    public void registrarMensaje (int idCreador, int idDestino, String titulo, String cuerpo){
        try{
            conn.prepareStatement("INSERT INTO Mensajes(id_origen, id_destino, titulo_mensaje, cuerpo_mensaje) VALUES('" + idCreador + "','" + idDestino + "','" + titulo + "','" + cuerpo + "')").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Mensaje> obtenerListaMensajesDeUnUsuarios(int idDestino){
        ArrayList<Mensaje> listaMensajesBuscados = new ArrayList<>();
        try{
            ResultSet rs = conn.prepareStatement("SELECT m.id_origen, c.nombre, m.titulo_mensaje, m.cuerpo_mensaje FROM Mensajes m JOIN Credenciales c ON m.id_origen=c.id WHERE id_destino='"+ idDestino +"'").executeQuery();
            while(rs.next()){
                listaMensajesBuscados.add(new Mensaje(rs.getInt("id_origen"), rs.getString("c.nombre"), rs.getString("titulo_mensaje"), rs.getString("cuerpo_mensaje")));
            }
            return listaMensajesBuscados;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaMensajesBuscados;
    }

}
