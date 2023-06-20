package com.example.summativeoop.controllers.Employee;

import com.example.summativeoop.App;
import com.example.summativeoop.controllers.Employee.models.instrumentSearchModel;
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

public class searchInstrumentsController implements Initializable {

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
    public TableView<instrumentSearchModel> instrumentTableView;
    public TableColumn<instrumentSearchModel, Integer> instrumentIDColumnView;
    public TableColumn<instrumentSearchModel, String> instrumentNameColumnView;
    public TableColumn<instrumentSearchModel, String> instrumentTypeColumnView;
    public TableColumn<instrumentSearchModel, Integer> instrumentQuantityColumnView;
    public TextField instrumentSearchTextField;

    ObservableList<instrumentSearchModel> instrumentSearchModelObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resource){

        Database connectNow = new Database();
        Connection connectDB = connectNow.getDBConnect();

        //Database SQL Query
        String instrumentViewQuery = "SELECT instrumentsid, name, type, quantity FROM instruments;";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(instrumentViewQuery);

            while (queryOutput.next()){

                Integer queryInstrumentsID = queryOutput.getInt("instrumentsID");
                String queryName = queryOutput.getString("name");
                String queryType = queryOutput.getString("type");
                Integer queryQuantity = queryOutput.getInt("quantity");

                //Populating Observable List
                instrumentSearchModelObservableList.add(new instrumentSearchModel(queryInstrumentsID, queryName,
                        queryType, queryQuantity));
            }

            instrumentIDColumnView.setCellValueFactory(new PropertyValueFactory<>("instrumentsID"));
            instrumentNameColumnView.setCellValueFactory(new PropertyValueFactory<>("name"));
            instrumentTypeColumnView.setCellValueFactory(new PropertyValueFactory<>("type"));
            instrumentQuantityColumnView.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            instrumentTableView.setItems(instrumentSearchModelObservableList);

            //Filtering List
            FilteredList<instrumentSearchModel> filteredData = new FilteredList<>(instrumentSearchModelObservableList, b -> true);

            instrumentSearchTextField.textProperty().addListener((observable, oldValue, newValue) ->{
                filteredData.setPredicate(instrumentSearchModel -> {

                    //If no search value is input, all records are shown
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null){
                        return true;
                    }

                    String searchKeyword = newValue.toLowerCase();

                    if (instrumentSearchModel.getName().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    } else if (instrumentSearchModel.getType().toLowerCase().indexOf(searchKeyword) > -1){
                        return true;
                    }else if (instrumentSearchModel.getInstrumentsid().toString().indexOf(searchKeyword) > -1){
                        return true;
                    } else
                        return  false;

                });
            });

            SortedList<instrumentSearchModel> sortedData = new SortedList<>(filteredData);

            //binds sorted data to table view
            sortedData.comparatorProperty().bind(instrumentTableView.comparatorProperty());

            //Apply filter to table view
            instrumentTableView.setItems(sortedData);


        } catch(SQLException e) {
            Logger.getLogger(searchInstrumentsController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

    }

}

