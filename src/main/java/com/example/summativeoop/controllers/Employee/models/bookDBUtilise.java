package com.example.summativeoop.controllers.Employee.models;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;


public class bookDBUtilise {

    //Data input function for adding new book through application
    public static void addBook(ActionEvent event, Integer booksid, String title,
                                    String type, String genre,
                                    String description, Integer quantity) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fortanathaeumloans", "root", "CoreyLBKS1");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM books WHERE Title= ?");
            psCheckUserExists.setString(1, title);
            resultSet = psCheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()) {
                System.out.println("Book already Exists");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Book is already in use");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO books (booksid, title, type, genre, description, quantity)\n" +
                        "VALUES (?, ?, ?, ?, ?, ?);");
                psInsert.setInt(1, booksid);
                psInsert.setString(2, title);
                psInsert.setString(3, type);
                psInsert.setString(4, genre);
                psInsert.setString(5, description);
                psInsert.setInt(6, quantity);
                psInsert.executeUpdate();

                System.out.println("New Book has been added ฅ(^•ﻌ•^ฅ)");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("New Book has been added ฅ(^•ﻌ•^ฅ)");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}