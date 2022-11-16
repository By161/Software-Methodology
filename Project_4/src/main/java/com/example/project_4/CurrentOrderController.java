package com.example.project_4;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;

public class CurrentOrderController {

    @FXML
    TableView informationType = new TableView();

public void initialize(){
    TableColumn PizzaStyle = new TableColumn<>("Pizza Style");
    TableColumn Crust = new TableColumn<>("Crust");
    TableColumn Toppings = new TableColumn<>("Toppings");
    TableColumn Subtotal = new TableColumn<>("Subtotal");

    informationType.getColumns().addAll(PizzaStyle, Crust, Toppings, Subtotal);
}


}
