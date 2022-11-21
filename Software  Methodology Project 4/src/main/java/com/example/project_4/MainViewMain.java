package com.example.project_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class that launches the app
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class MainViewMain extends Application {
    /**
     * Sets up the initial stage of when the application starts up
     * @param stage initial stage
     * @throws IOException exception thrown when an I/O error occurs
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainViewMain.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method that launches the whole app
     * @param args all user inputs
     */
    public static void main(String[] args) {
        launch();
    }
}