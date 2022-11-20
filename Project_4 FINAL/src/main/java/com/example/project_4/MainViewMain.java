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
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainViewMain.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("RU Pizzeria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

//    public static void showOrderNY(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("NYPizzaView.fxml"));
//
//        NYPizzaController nyc = loader.getController(); // This did the "trick"
//        nyc.setOrder(myOrder); // Passing the client-object to the ClientViewController
//    }
//
//    public static void showOrderChicago(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("ChicagoPizzaView.fxml"));
//
//        ChicagoPizzaController chicago = loader.getController(); // This did the "trick"
//        chicago.setOrder(myOrder); // Passing the client-object to the ClientViewController
//    }
//
//    public static void showOrderOrder(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("OrderView.fxml"));
//
//        CurrentOrderController currentOrder = loader.getController(); // This did the "trick"
//        currentOrder.setOrder(myOrder); // Passing the client-object to the ClientViewController
//    }
//
//    public static void showOrderStoreOrder(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("StoreOrderView.fxml"));
//
//        StoreOrdersController store = loader.getController(); // This did the "trick"
//        store.setOrder(myOrder); // Passing the client-object to the ClientViewController
//    }

}