package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.dvdSearchModel;
import com.example.summativeoop.database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class searchDvdsController implements Initializable {

    public Button returnMainMenuBtn;

    //Navigation Button
    @FXML
    void onReturnMainMenuButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Employee/homeMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        Stage stage = (Stage) returnMainMenuBtn.getScene().getWindow();
        stage.setTitle("Fort Anatheaum Loans");
        stage.setScene(scene);
        stage.show();
    }

    //Database Retrieval
    @FXML
    public TableView<dvdSearchModel> dvdTableView;
    public TableColumn<dvdSearchModel, Integer> dvdIDColumnView;
    public TableColumn<dvdSearchModel, String> dvdTitleColumnView;
    public TableColumn<dvdSearchModel, String> dvdGenreColumnView;
    public TableColumn<dvdSearchModel, String> dvdDescriptionColumnView;
    public TableColumn<dvdSearchModel, Integer> dvdQuantityColumnView;
    public TextField dvdSearchTextField;

    ObservableList<dvdSearchModel> dvdSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnect();

        //Database SQL Query
        String dvdViewQuery = "SELECT dvdid, title, genre, description, quantity FROM dvds;";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(dvdViewQuery);

            while (queryOutput.next()){

                Integer queryDvdID = queryOutput.getInt("dvdID");
                String queryTitle = queryOutput.getString("title");
                String queryGenre = queryOutput.getString("genre");
                String queryDescription = queryOutput.getString("description");
                Integer queryQuantity = queryOutput.getInt("quantity");

                //Populating Observable List
                dvdSearchModelObservableList.add(new dvdSearchModel(queryDvdID, queryTitle, queryGenre,
                        queryDescription, queryQuantity));
            }

            dvdIDColumnView.setCellValueFactory(new PropertyValueFactory<>("dvdID"));
            dvdTitleColumnView.setCellValueFactory(new PropertyValueFactory<>("title"));
            dvdGenreColumnView.setCellValueFactory(new PropertyValueFactory<>("genre"));
            dvdDescriptionColumnView.setCellValueFactory(new PropertyValueFactory<>("description"));
            dvdQuantityColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            dvdTableView.setItems(dvdSearchModelObservableList);

            //Filtering List
            FilteredList<dvdSearchModel> filteredData = new FilteredList<>(dvdSearchModelObservableList, b -> true);

            dvdSearchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(dvdSearchModel -> {

                    //If no search value is input, all records are shown
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (dvdSearchModel.getTitle().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (dvdSearchModel.getGenre().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (dvdSearchModel.getDescription().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (dvdSearchModel.getDvdID().toString().indexOf(searchKeyword) > -1){
                        return true;
                    } else
                        return  false; //no input match

                });
            });

            SortedList<dvdSearchModel> sortedData = new SortedList<>(filteredData);

            //binds sorted data to table view
            sortedData.comparatorProperty().bind(dvdTableView.comparatorProperty());

            //Apply filter to table view
            dvdTableView.setItems(sortedData);


        } catch(SQLException e) {
            Logger.getLogger(searchDvdsController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}