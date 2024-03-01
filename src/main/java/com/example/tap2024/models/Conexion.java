package com.example.tap2024.models;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Conexion {
    static private String DB = "taqueria";
    static private String USER = "admintacos";
    static private String PWD = "12345";

    static public Connection connection;
    public static void crearConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+
                    DB+"?allowPublicKeyRetrieval=true&useSSL=false",
                    USER,PWD);
            System.out.println("Se concectó bien");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
