package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.cdSearchModel;
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

public class searchCdsController implements Initializable {

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
    public TableView<cdSearchModel> cdTableView;
    public TableColumn<cdSearchModel, Integer> cdIDColumnView;
    public TableColumn<cdSearchModel, String> cdTitleColumnView;
    public TableColumn<cdSearchModel, String> cdGenreColumnView;
    public TableColumn<cdSearchModel, Integer> cdQuantityColumnView;
    public TextField cdSearchTextField;

    ObservableList<cdSearchModel> cdSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnect();

        //Database SQL Query
        String cdViewQuery = "SELECT cdid, title, genre, quantity FROM cds;";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(cdViewQuery);

            while (queryOutput.next()){

                Integer queryCdID = queryOutput.getInt("cdID");
                String queryTitle = queryOutput.getString("title");
                String queryGenre = queryOutput.getString("genre");
                Integer queryQuantity = queryOutput.getInt("quantity");

                //Populating Observable List
                cdSearchModelObservableList.add(new cdSearchModel(queryCdID, queryTitle, queryGenre, queryQuantity));
            }

            cdIDColumnView.setCellValueFactory(new PropertyValueFactory<>("cdID"));
            cdTitleColumnView.setCellValueFactory(new PropertyValueFactory<>("title"));
            cdGenreColumnView.setCellValueFactory(new PropertyValueFactory<>("genre"));
            cdQuantityColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            cdTableView.setItems(cdSearchModelObservableList);

            //Filtering List
            FilteredList<cdSearchModel> filteredData = new FilteredList<>(cdSearchModelObservableList, b -> true);

            cdSearchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(cdSearchModel -> {

                    //If no search value is input, all records are shown
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (cdSearchModel.getTitle().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (cdSearchModel.getGenre().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (cdSearchModel.getCdid().toString().indexOf(searchKeyword) > -1){
                        return true;
                    } else
                        return  false;

                });
            });

            SortedList<cdSearchModel> sortedData = new SortedList<>(filteredData);

            //Binds sorted data to table view
            sortedData.comparatorProperty().bind(cdTableView.comparatorProperty());

            //Apply filter to table view
            cdTableView.setItems(sortedData);


        } catch(SQLException e) {
            Logger.getLogger(searchCdsController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}

