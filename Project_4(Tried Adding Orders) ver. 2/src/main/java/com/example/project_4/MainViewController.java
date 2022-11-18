package com.example.project_4;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Controller Class for the initial Main View GUI
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class MainViewController {
    @FXML
    public Button ChicagoStyleButton;

    @FXML
    public Button NYStyleButton;

    @FXML
    public Button storeOrdersButton;

    @FXML
    public Button currentOrderButton;
    ArrayList<Pizza> pizzaList= new ArrayList<>();
    Order myOrder = new Order(pizzaList);

    @FXML
    protected void onChicagoStyleButtonClick() {
       try{
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChicagoPizzaView.fxml"));
           Parent root1 = fxmlLoader.load();
           Stage stage = new Stage();
           stage.setTitle("Chicago Style Pizza");
           stage.setScene(new Scene(root1));
           stage.show();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
    @FXML
    protected void onNYStyleButtonClick(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NYPizzaView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("New York Style Pizza");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void onStoreOrdersClick(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StoreOrdersView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Store Orders");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void onCurrentOrderButtonClick(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CurrentOrderView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Order getMyOrder(){
        return this.myOrder;
    }
}