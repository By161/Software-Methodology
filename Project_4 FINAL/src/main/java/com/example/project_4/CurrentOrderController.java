package com.example.project_4;

import java.text.DecimalFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {
    private MainViewController mainViewController;
    //private static final double SALES_TAX = .06625;

    @FXML
    Button removeButton = new Button();

    @FXML
    Button clearOrderButton = new Button();

    @FXML
    Button placeOrderButton = new Button();

    @FXML
    ListView displayPizzas;

    @FXML
    TextField costBeforeTaxLabel;

    @FXML
    TextField taxAmountLabel;

    @FXML
    TextField totalCostLabel;

    public void initialize() {
        removeOrder();
        placeOrder();
        clearOrder();
    }

    public void setMainController(MainViewController controller) {
        this.mainViewController = controller;
        updateView();
    }

    public void removeOrder() {
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int removeThisOrder = displayPizzas.getSelectionModel().getSelectedIndex();
                mainViewController.getCurrentOrder().remove(removeThisOrder);
                updateView();
            }
        });
    }

    public void clearOrder() {
        clearOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                for (int i = 0; i < mainViewController.getCurrentOrder().getNumPizzas(); i++) {
                    mainViewController.getCurrentOrder().remove(i);
                }
                updateView(); //so it all updates at once
            }
        });
    }

    public void placeOrder() {
        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainViewController.getCurrentOrder().makeCompleted();
                mainViewController.getAllOrdersFromStore().updateCurrentOrder();
                //mainViewController.confirmPopup("Successfully submitted!"); //we would need to add this
                ObservableList<String> orderedPizzas = FXCollections.observableArrayList();
                orderedPizzas.add("");
                displayPizzas.setItems(orderedPizzas);
                //these next 3 lines prob need to be changed
                costBeforeTaxLabel.setText("Cost Before Tax: $0.00");
                taxAmountLabel.setText("Tax: $0.00");
                totalCostLabel.setText("Total Cost: $0.00");
            }
        });
    }

    public void updateView() {
        if (mainViewController.getCurrentOrder().getNumPizzas() == 0) {
            removeButton.setDisable(true);
            placeOrderButton.setDisable(true);
            clearOrderButton.setDisable(true);
        }
        ObservableList<String> orderedPizzas = FXCollections.observableArrayList();
        for (int i = 0; i < mainViewController.getCurrentOrder().getNumPizzas(); i++) {
            orderedPizzas.add(mainViewController.getCurrentOrder().getPizza(i));
        }
        if (mainViewController.getCurrentOrder().getNumPizzas() == 0) {
            orderedPizzas.add("Your pizza cart is empty!");
        }
        displayPizzas.setItems(orderedPizzas);
        updateLabel();
    }

    public void updateLabel() {
        String costBeforeTax = mainViewController.getCurrentOrder().getCostBeforeTax();
        String taxAmount = mainViewController.getCurrentOrder().getTax();
        String totalCost = mainViewController.getCurrentOrder().getTotalCost();
        costBeforeTaxLabel.setText("Cost Before Tax: " + costBeforeTax);
        taxAmountLabel.setText("Tax: " + taxAmount);
        totalCostLabel.setText("Total Cost: " + totalCost);
    }
}
