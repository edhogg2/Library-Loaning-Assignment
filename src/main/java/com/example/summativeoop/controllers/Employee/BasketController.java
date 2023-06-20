package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BasketController {

    public Button returnMainMenuBtn, removeBasketItemBtn, basketCheckoutBtn;
    public TextField customerNameInputFld, customerEmailAddressFld;

    //Navigation Buttons
    @FXML
    void onReturnToMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Anatheaum Loans");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBasketCheckoutButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/basketCheckout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) basketCheckoutBtn.getScene().getWindow();
        stage.setTitle("FAL: Checkout");
        stage.setScene(scene);
        stage.show();
    }
}