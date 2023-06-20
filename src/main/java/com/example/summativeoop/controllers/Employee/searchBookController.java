package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.bookSearchModel;
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

public class searchBookController implements Initializable {

    public Button returnMainMenuBtn, goToAddNewBookBtn;

    //Navigation Buttons
    @FXML
    void onReturnMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Athanaeum Loans");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onGoToAddNewBookButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/addNewBook.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) goToAddNewBookBtn.getScene().getWindow();
        stage.setTitle("Fort Athanaeum Loans");
        stage.setScene(scene);
        stage.show();
    }

    //Database Retrieval
    @FXML
    private TableView<bookSearchModel> bookTableView;
    public TableColumn<bookSearchModel, Integer> bookIDColumnView;
    public TableColumn<bookSearchModel, String> bookTitleColumnView;
    public TableColumn<bookSearchModel, String> bookTypeColumnView;
    public TableColumn<bookSearchModel, String> bookGenreColumnView;
    public TableColumn<bookSearchModel, String> bookDescriptionColumnView;
    public TableColumn<bookSearchModel, Integer> bookQuantityColumnView;
    @FXML
    private TextField bookSearchTextField;

    ObservableList<bookSearchModel> bookSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnect();

        //Database SQL Query
        String bookViewQuery = "SELECT booksid, title, type, genre, description, quantity FROM books;";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(bookViewQuery);

            while (queryOutput.next()){

                Integer queryBookID = queryOutput.getInt("booksID");
                String queryTitle = queryOutput.getString("title");
                String queryType = queryOutput.getString("type");
                String queryGenre = queryOutput.getString("genre");
                String queryDescription = queryOutput.getString("description");
                Integer queryQuantity = queryOutput.getInt("quantity");

                //Populating Observable List
                bookSearchModelObservableList.add(new bookSearchModel(queryBookID, queryTitle, queryType, queryGenre,
                        queryDescription, queryQuantity));
            }

            bookIDColumnView.setCellValueFactory(new PropertyValueFactory<>("booksID"));
            bookTitleColumnView.setCellValueFactory(new PropertyValueFactory<>("title"));
            bookTypeColumnView.setCellValueFactory(new PropertyValueFactory<>("type"));
            bookGenreColumnView.setCellValueFactory(new PropertyValueFactory<>("genre"));
            bookDescriptionColumnView.setCellValueFactory(new PropertyValueFactory<>("description"));
            bookQuantityColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            bookTableView.setItems(bookSearchModelObservableList);

            //Filtering List
            FilteredList<bookSearchModel> filteredData = new FilteredList<>(bookSearchModelObservableList, b -> true);

            bookSearchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(bookSearchModel -> {

                    //If no search value is input, all records are shown
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (bookSearchModel.getTitle().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches book title
                    } else if (bookSearchModel.getType().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches book title
                    } else if (bookSearchModel.getGenre().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches book genre
                    }else if (bookSearchModel.getDescription().toLowerCase().indexOf(searchKeyword) > -1){
                        return true; //Input matches book description
                    }else if (bookSearchModel.getBooksID().toString().indexOf(searchKeyword) > -1){
                        return true; //Input matches book ID number
                    } else
                        return  false; //no input match

                });
            });

            SortedList<bookSearchModel> sortedData = new SortedList<>(filteredData);

            //binds sorted data to table view
            sortedData.comparatorProperty().bind(bookTableView.comparatorProperty());

            //Apply filter to table view
            bookTableView.setItems(sortedData);


        } catch(SQLException e) {
            Logger.getLogger(searchBookController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}

