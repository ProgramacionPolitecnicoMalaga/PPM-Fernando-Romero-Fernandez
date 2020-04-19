package com.politecnicomalaga.DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DBConn {

    Dotenv dotenv = Dotenv.configure().load();
    private String url = "jdbc:mysql://" + dotenv.get("DDBB_HOST") + "/" + dotenv.get("DDBB_DATABASE") + "?serverTimezone="+ TimeZone.getDefault().getID();
    private String usuario = dotenv.get("DDBB_USER");
    private String clave = dotenv.get("DDBB_PASSWORD");
    private Connection conn;

    public DBConn(){
        try {
            conn = DriverManager.getConnection(url, usuario, clave);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConn(){
        return conn;
    }
}
