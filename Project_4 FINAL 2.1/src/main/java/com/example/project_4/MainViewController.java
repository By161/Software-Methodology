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
    public ArrayList<Pizza> pizzaList = new ArrayList<>();
    //public Order myOrder = new Order(pizzaList);

    private StoreOrder allOrdersFromStore = new StoreOrder();

    public void initialize() {
        Order currentOrder = new Order();
        allOrdersFromStore.add(currentOrder);
    }

    @FXML
    protected void onChicagoStyleButtonClick() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChicagoPizzaView.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Chicago Style Pizza");
            ChicagoPizzaController cpc = fxmlLoader.getController();
            cpc.setMainViewController(MainViewController.this);
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
            NYPizzaController nypc = fxmlLoader.getController();
            nypc.setMainViewController(MainViewController.this);
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
            StoreOrdersController soc = fxmlLoader.getController();
            soc.setMainViewController(MainViewController.this);
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
            CurrentOrderController coc = fxmlLoader.getController();
            coc.setMainViewController(MainViewController.this);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public StoreOrder getAllOrdersFromStore() {
        return allOrdersFromStore;
    }

    public Order getCurrentOrder() {
        return allOrdersFromStore.getCurrentOrder();
    }

//    private void showOrderNY(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("NYPizzaView.fxml"));
//
//        NYPizzaController nyc = loader.getController(); // This did the "trick"
//        nyc.setMainViewController(MainViewController.this); // Passing the client-object to the ClientViewController
//    }

//    private void showOrderChicago(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("ChicagoPizzaView.fxml"));
//
//        ChicagoPizzaController chicago = loader.getController(); // This did the "trick"
//        chicago.setMainViewController(MainViewController.this); // Passing the client-object to the ClientViewController
//    }

//    private void showOrderOrder(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("OrderView.fxml"));
//
//        CurrentOrderController currentOrder = loader.getController(); // This did the "trick"
//        currentOrder.setMainViewController(MainViewController.this); // Passing the client-object to the ClientViewController
//    }

//    private void showOrderStoreOrder(Order order) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(MainViewMain.class.getResource("StoreOrderView.fxml"));
//
//        StoreOrdersController store = loader.getController(); // This did the "trick"
//        store.setMainViewController(MainViewController.this); // Passing the client-object to the ClientViewController
//    }
}