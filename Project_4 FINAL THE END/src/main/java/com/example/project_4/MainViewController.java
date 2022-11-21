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

    /**
     * Initializes required fields
     */
    public void initialize() {
        Order currentOrder = new Order();
        allOrdersFromStore.add(currentOrder);
    }

    /**
     * Action that is performed when the chicago style button is clicked,
     * opens a new menu to choose what kind of chicago style pizza you want
     */
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

    /**
     * Action that is performed when the NY style button is clicked,
     * opens a new menu to choose what kind of New York style pizza you want
     */
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

    /**
     * Action that is performed when the Store Order button is clicked,
     * opens a new window to show the store orders
     */
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
    /**
     * Action that is performed when the current order button is clicked,
     * opens a new window that shows you the current order
     */
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

    /**
     * Getter method for all the orders from the store
     * @return all the orders from the store
     */
    public StoreOrder getAllOrdersFromStore() {
        return allOrdersFromStore;
    }

    /**
     * Getter method for the current order
     * @return the current order
     */
    public Order getCurrentOrder() {
        return allOrdersFromStore.getCurrentOrder();
    }

}