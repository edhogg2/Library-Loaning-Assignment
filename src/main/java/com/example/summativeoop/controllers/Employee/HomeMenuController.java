package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
public class HomeMenuController {

    public Button logoutBtn, adminOptionsBtn, seeAllItemsBtn, booksBtn, dvdsBtn, instrumentsBtn, cdsBtn,
            basketBtn, returnItemsBtn, overdueFeesBtn;

    //Navigation Buttons
    @FXML
    void onLogoutButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("loginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        stage.setTitle("Fort Athenaeum Loans");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAdminOptionsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Admin/administratorOptions.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) adminOptionsBtn.getScene().getWindow();
        stage.setTitle("FAL: Administrator Option");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onSeeAllItemsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) seeAllItemsBtn.getScene().getWindow();
        stage.setTitle("FAL: All Items");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBooksButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchBooks.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) booksBtn.getScene().getWindow();
        stage.setTitle("FAL: Books");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onDvdsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchDvds.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) dvdsBtn.getScene().getWindow();
        stage.setTitle("FAL: DVDs");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onInstrumentsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchInstruments.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) instrumentsBtn.getScene().getWindow();
        stage.setTitle("FAL: Instruments");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onCdsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/searchCds.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) cdsBtn.getScene().getWindow();
        stage.setTitle("FAL: CDs");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onBasketButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/basket.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) basketBtn.getScene().getWindow();
        stage.setTitle("FAL: Basket");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onReturnItemsButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/returnItems.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnItemsBtn.getScene().getWindow();
        stage.setTitle("FAL: Return Loaned Items");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onOverdueFeesButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/overdueFees.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) overdueFeesBtn.getScene().getWindow();
        stage.setTitle("FAL: Overdue Item Fees");
        stage.setScene(scene);
        stage.show();
    }
}