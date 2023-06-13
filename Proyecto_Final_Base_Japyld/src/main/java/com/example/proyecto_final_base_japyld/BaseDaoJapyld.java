package com.example.proyecto_final_base_japyld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDaoJapyld {
    public Connection getConnection() throws SQLException{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/japyld";

        return DriverManager.getConnection(url, "root","root");
    }
}
