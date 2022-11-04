package com.example.project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/** This class starts and launches the GUI of the project
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class GymManagerMain extends Application {
    /**
     * Initial stage of the GUI
     * @param primaryStage the first stage
     * @throws Exception declare exceptions
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("GymManagerView.fxml"));
        primaryStage.setTitle("Gym Manager");
        primaryStage.setScene(new Scene(root, 1500, 400));
        primaryStage.show();
    }

    /**
     * Launches the GUI program
     * @param args All inputs from the user
     */
    public static void main(String[] args) {
        launch(args);
    }
}