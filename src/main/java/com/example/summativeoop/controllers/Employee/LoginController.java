package com.example.summativeoop.controllers.Employee;


import com.example.summativeoop.controllers.Employee.models.loginDBUtilise;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import java.net.URL;


public class LoginController implements Initializable {

    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;
    @FXML
    public Button signInButton;
    @FXML
    public Label unrecognisedCredentials;

    //Event handler that initiates login database function when button is clicked

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signInButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loginDBUtilise.loginUser(event, usernameTextField.getText(), passwordTextField.getText());
            }

        });
    }


    // MAINTENANCE LOGIN METHOD IN CASE OF DATABASE FAILURE

//    public class LoginController{
//        public Button signInButton;
//        public TextField usernameTextField;
//        public TextField passwordTextField;
//        String[] usernames = {"123"};
//        String[] passwords = {"123"};
//
//        @FXML
//        void onLoginButtonClick() throws IOException {
//
//            if (usernameTextField.getText().equals(usernames[0]) && passwordTextField.getText().equals(passwords[0])) {
//                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
//                Scene scene = new Scene(fxmlLoader.load(), 800, 500);
//                Stage stage = (Stage) signInButton.getScene().getWindow();
//                stage.setTitle("Forte Athenaeum Loans");
//                stage.setScene(scene);
//                stage.show();
//            } else {
//                System.out.println("User Not Found");
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Unrecognised Credentials");
//                alert.show();
//            }
//
//        }
//    }
}