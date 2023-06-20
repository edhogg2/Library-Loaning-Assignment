package com.example.summativeoop.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class views {

    private AnchorPane HomeMenuView;
    public views(){}

    public AnchorPane getHomeMenuView (){
        if (HomeMenuView == null){
            try{
                HomeMenuView = new FXMLLoader(getClass().getResource("/com.example.summativeoop/Employee/homeMenu.fxml")).load();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return HomeMenuView;
    }

    public void showLoginView() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.summativeoop/loginView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Fort Anatheum Loans");
        stage.show();
    }

    public void showAdminOptions() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com.example.summativeoop/Admin/administratorOptions.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Fort Anatheum Loans Administrator Options");
        stage.show();

    }
}
