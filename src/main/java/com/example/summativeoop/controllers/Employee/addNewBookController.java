package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.bookDBUtilise;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class addNewBookController implements Initializable {

    @FXML
    public Button returnMainMenuBtn, addNewBookBtn;
    public TextField bookDescriptionTextField, bookIDTextField, bookTitleTextField, bookGenreTextField, bookTypeTextField,
            bookQuantityTextField;

    // Event handler that initiates function when button is pressed

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNewBookBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bookDBUtilise.addBook(event, Integer.valueOf(bookIDTextField.getText()),
                        bookTitleTextField.getText(), bookGenreTextField.getText(), bookGenreTextField.getText(),
                        bookDescriptionTextField.getText(), Integer.valueOf(bookQuantityTextField.getText()));
            }
        });
    }

    //Navigation Button
    @FXML
    void onReturnMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchBooks.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Athanaeum Loans");
        stage.setScene(scene);
        stage.show();
    }


}
