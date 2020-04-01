package com.politecnicomalaga.DAO;

import com.politecnicomalaga.MODELO.HerramientaFechas;
import com.politecnicomalaga.MODELO.Item;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ItemDAO {

    String url = "jdbc:mysql://94.177.232.107:3306/CustomRender";
    String usuario = "CustomRenderUser";
    String password = "Perro20";
    Connection dbConn;
    private HerramientaFechas herramientaFechas;

    public ItemDAO(){
        herramientaFechas = new HerramientaFechas();

        try {
            dbConn = DriverManager.getConnection(url,usuario,password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Item> buscar(){
        ArrayList<Item> listaItemsBuscados = new ArrayList<>();
        try{
            ResultSet rs = dbConn.prepareStatement("SELECT * FROM CustomRenderTable").executeQuery();
            while(rs.next()){
                Date date = rs.getDate("fecha");

                listaItemsBuscados.add(new Item(rs.getString("autor"), herramientaFechas.obtenerLocalDate(date),rs.getString("texto"),rs.getString("tema")));
            }
            return listaItemsBuscados;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return listaItemsBuscados;
    }

    public void insertar(String nombreAutor, String nombreTema, String contenidoTexto, String fechaEnString){
        try{
            dbConn.prepareStatement("INSERT INTO CustomRenderTable(autor, tema, texto, fecha) VALUES('" + nombreAutor + "','" + nombreTema + "','" + contenidoTexto + "','" + fechaEnString + "')").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void borrar(Item item){
        try{
            dbConn.prepareStatement("DELETE FROM CustomRenderTable WHERE autor = '" + item.getAutor() +"' AND texto = '" + item.getTexto() +"' AND tema = '" + item.getTema() +"'").executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}