package com.example.summativeoop.controllers.Admin;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Admin.models.employeeSearchModel;
import com.example.summativeoop.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class employeeListController implements Initializable {

    public Button returnToAdminOptionsBtn;

    @FXML
    void onReturntoAdminOptionsButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/administratorOptions.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnToAdminOptionsBtn.getScene().getWindow();
        stage.setTitle("Fort Athenaeum Loans");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private TableView<employeeSearchModel> employeeTableList;
    @FXML
    public TableColumn<employeeSearchModel, Integer> userIDColumnView;
    @FXML
    public TableColumn<employeeSearchModel, String> nameColumnView;
    @FXML
    public TableColumn<employeeSearchModel, String> usernameColumnView;
    @FXML
    public TableColumn<employeeSearchModel, String> passwordColumnView;
    @FXML
    public TableColumn<employeeSearchModel, String> emailAddressColumnView;
    @FXML
    public TableColumn<employeeSearchModel, Boolean> adminColumnView;
    public TextField employeeSearchFld;

    ObservableList<employeeSearchModel> employeeSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        // Employee list data retrieval and display
        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnect();

        //Database SQL Query
        String employeeViewQuery = "SELECT userid, name, username, password, email_address, admin FROM users;";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(employeeViewQuery);

            while (queryOutput.next()){

                Integer queryUserID = queryOutput.getInt("userid");
                String queryName = queryOutput.getString("name");
                String queryUsername = queryOutput.getString("username");
                String queryPassword = queryOutput.getString("password");
                String queryEmailAddress = queryOutput.getString("email_address");
                Boolean queryAdmin = queryOutput.getBoolean("admin");

                //Populating Observable List
                employeeSearchModelObservableList.add(new employeeSearchModel(queryUserID, queryName, queryUsername,
                        queryPassword, queryEmailAddress, queryAdmin));
            }

            userIDColumnView.setCellValueFactory(new PropertyValueFactory<>("userID"));
            nameColumnView.setCellValueFactory(new PropertyValueFactory<>("name"));
            usernameColumnView.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordColumnView.setCellValueFactory(new PropertyValueFactory<>("password"));
            emailAddressColumnView.setCellValueFactory(new PropertyValueFactory<>("email_address"));
            adminColumnView.setCellValueFactory(new PropertyValueFactory<>("admin"));

            employeeTableList.setItems(employeeSearchModelObservableList);

            //Filtering List
            FilteredList<employeeSearchModel> filteredData = new FilteredList<>(employeeSearchModelObservableList,
                    b -> true);

            employeeSearchFld.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(employeeSearchModel -> {

                    //If no search value is input, all records are shown
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (employeeSearchModel.getName().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches users name
                    } else if (employeeSearchModel.getUsername().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches usernames
                    }else if (employeeSearchModel.getEmail_address().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches users email address
                    }else if (employeeSearchModel.getAdmin().toString().indexOf(searchKeyword) > -1){
                        return true; //Input matches users admin privileges
                    } else
                        return  false; //no input match

                });
            });

            SortedList<employeeSearchModel> sortedData = new SortedList<>(filteredData);

            //binds sorted data to table view
            sortedData.comparatorProperty().bind(employeeTableList.comparatorProperty());

            //Apply filter to table view
            employeeTableList.setItems(sortedData);


        } catch(SQLException e) {
            Logger.getLogger(employeeListController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}

