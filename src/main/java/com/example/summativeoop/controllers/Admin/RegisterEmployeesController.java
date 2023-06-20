package com.example.summativeoop.controllers.Admin;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Admin.models.registerEmployeeDBUtilise;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterEmployeesController implements Initializable {

    @FXML
    public Button returnToAdminOptionsBtn, createEmployeeAccountBtn;
    @FXML
    public TextField employeeUsernameTextField, employeeIDTextField, employeeNameTextField,
            employeeEmailAddressTextField, employeePasswordTextField;

    @FXML
    public CheckBox administratorCheckBox;

// Event handler that initiates function when button is pressed
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createEmployeeAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registerEmployeeDBUtilise.registerUser(event, Integer.valueOf(employeeIDTextField.getText()),
                        employeeNameTextField.getText(), employeeUsernameTextField.getText(),
                        employeePasswordTextField.getText(), employeeEmailAddressTextField.getText(),
                        Boolean.valueOf(administratorCheckBox.getText()));
            }

        });
    }

    // Navigation Button
    @FXML
    void onReturnToAdminOptionsButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/administratorOptions.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnToAdminOptionsBtn.getScene().getWindow();
        stage.setTitle("FAL: Administrator Options");
        stage.setScene(scene);
        stage.show();
    }

}
