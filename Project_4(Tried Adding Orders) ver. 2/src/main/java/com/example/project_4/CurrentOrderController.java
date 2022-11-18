package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.ArrayList;


public class CurrentOrderController {

    @FXML
    TableView currentOrderTable = new TableView();

    @FXML
    Button clearButton = new Button();

    @FXML
    Button removeButton = new Button();

    @FXML
    Button placeOrderButton = new Button();

    @FXML
    TextField orderNumber = new TextField();
    private Parent root;

    ArrayList<String> myToppings = new ArrayList<>();
    int counter = 1;

    public void initialize() {
        TableColumn<Order, String> PizzaStyle = new TableColumn<>("Pizza Style");
        TableColumn<Order, String> Crust = new TableColumn<>("Crust");
        TableColumn<Order, String> Toppings = new TableColumn<>("Toppings");
        TableColumn<Order, String> Subtotal = new TableColumn<>("Subtotal");
        currentOrderTable.getColumns().addAll(PizzaStyle, Crust, Toppings, Subtotal);
        orderNumber.setText(Integer.toString(counter));
        currentOrderTable.setItems(OrdersModel);
    }

    private ObservableList<OrdersModel> OrdersModel = FXCollections.observableArrayList(
            new OrdersModel(counter, "Deluxe", "Thin", myToppings, 20.99)
    );
//public void addOrder(Order order){
//    FXMLLoader loader = new FXMLLoader(getClass().getResource("NYPizzaView.fxml"));
//    NYPizzaController controller = loader.getController();
//    currentOrderTable.getItems().add(order.toString(controller.getOrder()));
//}

    public void clearOrder(){
        currentOrderTable.getItems().clear();
    }

    public void removeOrder(){
        currentOrderTable.getSelectionModel().clearSelection();
    }

    public ObservableList placeOrder(){
        return currentOrderTable.getItems();
    }


}
