package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.allSearchModel;
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

public class SearchMenuController {

    public Button returnMainMenuBtn;

    //Navigation Button
    @FXML
    void onReturnMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Athanaeum Loans");
        stage.setScene(scene);
        stage.show();
    }


//    Attempted Database Retrieval from all tables into 1

//    @FXML
//    public TableView<allSearchModel> allItemsTableView;
//    public TableColumn<allSearchModel, Integer> bookIdColumnView;
//    public TableColumn<allSearchModel, String> bookNameColumnView;
//    public TableColumn<allSearchModel, Integer> dvdIdColumnView;
//    public TableColumn<allSearchModel, String> dvdTitleColumnView;
//    public TableColumn<allSearchModel, Integer> cdIdColumnView;
//    public TableColumn<allSearchModel, String> cdTitleColumnView;
//    public TableColumn<allSearchModel, Integer> instrumentIdColumnView;
//    public TableColumn<allSearchModel, String> instrumentNameColumnView;
//
//    public TextField alltemsSearchTextField;
//
//    ObservableList<allSearchModel> allSearchModelObservableList = FXCollections.observableArrayList();
//
//    @Override
//    public void initialize(URL url, ResourceBundle resource){
//
//        Database connectNow = new Database();
//        Connection connectDB = connectNow.getDBConnect();
//
//        //Database SQL Query
//        String allViewQuery = "SELECT booksid, title, type, genre, description, quantity FROM books;";
//
//        try{
//
//            Statement statement = connectDB.createStatement();
//            ResultSet queryOutput = statement.executeQuery(allViewQuery);
//
//            while (queryOutput.next()){
//
//                Integer queryBookID = queryOutput.getInt("booksID");
//                String queryBookTitle = queryOutput.getString("bookTitle");
//                Integer queryCdID = queryOutput.getInt("cdsID");
//                String queryCdTitle = queryOutput.getString("cdTitle");
//                Integer queryDvdID = queryOutput.getInt("DvdID");
//                String queryDvdTitle = queryOutput.getString("dvdTitle");
//                Integer queryInstrumentID = queryOutput.getInt("instrumentID");
//                String queryInstrumentName = queryOutput.getString("instrumentName");
//
//                //Populating Observable List
//                allSearchModelObservableList.add(new allSearchModel(queryBookID, queryBookTitle, queryCdID, queryCdTitle,
//                        queryDvdID, queryDvdTitle, queryInstrumentID, queryInstrumentName));
//
//            }
//            bookIdColumnView.setCellValueFactory(new PropertyValueFactory<>("booksID"));
//            bookNameColumnView.setCellValueFactory(new PropertyValueFactory<>("title"));
//            dvdIdColumnView.setCellValueFactory(new PropertyValueFactory<>("type"));
//            dvdTitleColumnView.setCellValueFactory(new PropertyValueFactory<>("genre"));
//            cdIdColumnView.setCellValueFactory(new PropertyValueFactory<>("description"));
//            cdTitleColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//            instrumentIdColumnView.setCellValueFactory(new PropertyValueFactory<>("description"));
//            instrumentNameColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));
//
//            allItemsTableView.setItems(allSearchModelObservableList);
//
//            //Filtering List
//            FilteredList<bookSearchModel> filteredData = new FilteredList<>(allSearchModelObservableList, b -> true);
//
//            alltemsSearchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
//                filteredData.setPredicate(allSearchModel -> {
//
//                    //If no search value is input, all records are shown
//                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
//                        return true;
//                    }
//
//                    String searchKeyword = newValue.toLowerCase();
//
//                    if (allSearchModel.getTitle().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true; //Input matches book title
//                    } else if (allSearchModel.getType().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true; //Input matches book title
//                    } else if (allSearchModel.getGenre().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true; //Input matches book genre
//                    }else if (allSearchModel.getDescription().toLowerCase().indexOf(searchKeyword) > -1){
//                        return true; //Input matches book description
//                    }else if (allSearchModel.getBooksID().toString().indexOf(searchKeyword) > -1){
//                        return true; //Input matches book ID number
//                    } else
//                        return  false; //no input match
//
//                });
//            });
//
//            SortedList<bookSearchModel> sortedData = new SortedList<>(filteredData);
//
//            //binds sorted data to table view
//            sortedData.comparatorProperty().bind(allItemsTableView.comparatorProperty());
//
//            //Apply filter to table view
//            allItemsTableView.setItems(sortedData);
//
//
//        } catch(SQLException e) {
//            Logger.getLogger(searchBookController.class.getName()).log(Level.SEVERE, null, e);
//            e.printStackTrace();
//        }
//
//    }
//
}