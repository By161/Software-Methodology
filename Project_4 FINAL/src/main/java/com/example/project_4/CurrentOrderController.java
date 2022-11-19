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

public class CurrentOrderControllerCOPY {
    private MainViewController mainViewController;
    private static final double SALES_TAX = .06625;

    @FXML
    Button removeButton = new Button();

    @FXML
    Button clearOrderButton = new Button();

    @FXML
    Button placeOrderButton = new Button();

    @FXML
    ListView displayOrders;

    @FXML
    Label costBeforeTaxLabel;

    @FXML
    Label taxAmountLabel;

    @FXML
    Label totalCostLabel;

    public void initialize() {
        removeButtonHandler();
        placeOrderButtonHandler();
    }

    public void setMainController(MainViewController controller) {
        this.mainViewController = controller;
        updateView();
    }

    private void removeButtonHandler() {
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int removeThisOrder = displayOrders.getSelectionModel().getSelectedIndex();
                mainViewController.getCurrentOrder().remove(removeThisOrder);
                updateView();
            }
        });
    }

    private void clearOrderButtonHandler() {
        clearOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
    }

    private void placeOrderButtonHandler() {
        placeOrderButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainViewController.getCurrentOrder().makeCompleted();
                mainViewController.getAllOrders().nextOrder();
                mainViewController.confirmPopup("Successfully submitted!"); //we would need to add this
                ObservableList<String> orderedPizzas = FXCollections.observableArrayList();
                orderedPizzas.add("");
                displayOrders.setItems(orderedPizzas);
                //these next 3 lines prob need to be changed
                costBeforeTaxLabel.setText("Cost Before Tax: $0.00");
                taxAmountLabel.setText("Tax: $0.00");
                totalCostLabel.setText("Total Cost: $0.00");
            }
        });
    }

    private void updateView() {
        if (mainViewController.getCurrentOrder().length() == 0) {
            removeButton.setDisable(true);
            placeOrderButton.setDisable(true);
            clearOrderButton.setDisable(true);
        }
        ObservableList<String> orderItems = FXCollections.observableArrayList();
        for (int i = 0; i < mainViewController.getCurrentOrder().length(); i++) {
            orderItems.add(mainViewController.getCurrentOrder().getItem(i));
        }
        if (mainViewController.getCurrentOrder().length() == 0) {
            orderItems.add("Your pizza cart is empty!");
        }
        displayOrders.setItems(orderItems);
        updateLabel();
    }

    private void updateLabel() {
        String costBeforeTax = mainViewController.getCurrentOrder.getCostBeforeTax();
        String taxAmount = mainViewController.getCurrentOrder.getTax();
        String totalCost = mainViewController.getCurrentOrder.getTotalCost();
        costBeforeTaxLabel.setText("Cost Before Tax: " + costBeforeTax);
        taxAmountLabel.setText("Tax: " + taxAmount);
        totalCostLabel.setText("Total Cost: " + totalCost);
    }
}
