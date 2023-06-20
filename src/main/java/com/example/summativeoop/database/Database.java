package com.example.summativeoop.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public Connection databaseConnection;
    public Connection getDBConnect(){
        String databaseName = "fortanathaeumloans";
        String databaseUserName = "root";
        String databasePassword = "CoreyLBKS1";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseConnection = DriverManager.getConnection(url, databaseUserName, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return databaseConnection;
    }
}
