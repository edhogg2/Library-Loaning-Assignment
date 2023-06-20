package com.example.summativeoop.controllers.Admin;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;


public class AdminOptionController {

    public Button returnMainMenuBtn, registerNewEmployeesBtn, employeesListBtn, deleteEmployeesBtn;

    // Navigation Buttons
    @FXML
    void onReturnMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Anatheaum Loans");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onRegisterNewEmployeesButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/registerEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) registerNewEmployeesBtn.getScene().getWindow();
        stage.setTitle("FAL: Register Employees");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onEmployeesListButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/employeeList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) employeesListBtn.getScene().getWindow();
        stage.setTitle("FAL: Employee List");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onDeleteEmployeesButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/deleteEmployees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) deleteEmployeesBtn.getScene().getWindow();
        stage.setTitle("FAL: Delete Employees");
        stage.setScene(scene);
        stage.show();
    }
}
