package com.example.project_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class that launches the app
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class MainViewMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainViewMain.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }
    public static void showOrderNY(Order myOrder) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainViewMain.class.getResource("NYPizzaView.fxml"));
        Parent mainLayout = loader.load();

        NYPizzaController npc = loader.getController();
        npc.setOrder(myOrder);
    }

    public static void main(String[] args) {
        launch();
    }
}