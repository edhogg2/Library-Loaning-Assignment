package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;
public class OverdueFeesController {

    public Button returnMainMenuBtn, overdueFeesCheckoutBtn;
    public TextField customerEmailAddressFld, customerNameFld, customerSortCodeFld, customerBankAccountNumberFld;

    //Navigation Buttons
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
    void onOverdueFeesCheckoutButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/overdueFeesCheckout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) overdueFeesCheckoutBtn.getScene().getWindow();
        stage.setTitle("FAL: Checkout");
        stage.setScene(scene);
        stage.show();
    }
}
