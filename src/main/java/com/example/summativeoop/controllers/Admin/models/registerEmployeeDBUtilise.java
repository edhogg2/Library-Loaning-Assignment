package com.example.summativeoop.controllers.Admin.models;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;



public class registerEmployeeDBUtilise {

    // User data input through function through application
    public static void registerUser(ActionEvent event, Integer userid, String name,
                                    String username, String password,
                                    String email_address, Boolean admin) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fortanathaeumloans", "root",
                    "CoreyLBKS1");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username= ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("User already Exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username is already in use");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (userid, name, username, password, email_address, admin)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?);");
                psInsert.setInt(1, userid);
                psInsert.setString(2, name);
                psInsert.setString(3, username);
                psInsert.setString(4, password);
                psInsert.setString(5, email_address);
                psInsert.setBoolean(6, admin);
                psInsert.executeUpdate();

                System.out.println("User account has been created ฅ(^•ﻌ•^ฅ)");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("User account has been created ฅ(^•ﻌ•^ฅ)");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
