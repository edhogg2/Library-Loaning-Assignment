package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.IOException;

public class SingularItemController {

    public Button returnSearchMenuBtn;

    @FXML
    void onReturnSearchMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnSearchMenuBtn.getScene().getWindow();
        stage.setTitle("FAL: Search");
        stage.setScene(scene);
        stage.show();
    }
}
