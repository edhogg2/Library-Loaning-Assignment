package com.example.summativeoop.controllers.Admin;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
public class DeleteEmployeesController {

    public Button returnToAdminOptionsBtn, searchEmployeeListBtn, deleteEmployeeBtn;
    public TextField searchEmployeeListFld;

    // Navigation Button
    @FXML
    void onReturnToAdminOptionsButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/administratorOptions.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnToAdminOptionsBtn.getScene().getWindow();
        stage.setTitle("Fort Anatheaum Loans");
        stage.setScene(scene);
        stage.show();
    }
}