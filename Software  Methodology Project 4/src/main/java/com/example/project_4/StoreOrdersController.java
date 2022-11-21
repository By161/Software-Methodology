package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Controller for the store orders window
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class StoreOrdersController {
    private MainViewController mainViewController;
    private final int SIZE_TO_SUBTRACT = 1;

    @FXML
    ListView displayAllPlacedOrders;

    @FXML
    ListView displayCurrentOrder;

    @FXML
    TextField numberOfOrders;

    @FXML
    Button removeButtonFromPlaced = new Button();

    @FXML
    Button removeButtonFromCurrent = new Button();

    @FXML
    Button exportButton = new Button();

    /**
     * initializes all event handlers and required fields
     */
    public void initialize() {
        removeButtonFromPlacedHandler();
        removeButtonFromCurrentHandler();
        exportButtonHandler();
    }

    /**
     * Method called from the MainController to give this class access to the data from the other classes
     * @param controller the reference to the MainController
     */
    public void setMainViewController(MainViewController controller) {
        this.mainViewController = controller;
        updateView();
    }

    /**
     * event handler for when the remove button is clicked for the placed orders
     */
    private void removeButtonFromPlacedHandler() {
        removeButtonFromPlaced.setOnAction(actionEvent -> {
            if (displayAllPlacedOrders.getSelectionModel().getSelectedIndex() == -1) {
                return;
            }
            int removeIndex = displayAllPlacedOrders.getSelectionModel().getSelectedIndex();
            mainViewController.getAllOrdersFromStore().remove(removeIndex);
            updateView();
        });
    }

    /**
     * Event handler for when the remove button is clicked for the current orders
     */
    private void removeButtonFromCurrentHandler() {
        removeButtonFromCurrent.setOnAction(actionEvent -> {
            if (displayCurrentOrder.getSelectionModel().getSelectedIndex() == -1) {
                return;
            }
            int removeIndex = displayCurrentOrder.getSelectionModel().getSelectedIndex();
            mainViewController.getCurrentOrder().remove(removeIndex);
            updateView();
        });
    }

    /**
     * Event handler for when the export button is clicked
     */
    private void exportButtonHandler() {
        exportButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    FileWriter myWriter = new FileWriter("export.txt");
                    myWriter.write(getExport());
                    myWriter.close();
                    //mainViewController.confirmPopup("Successfully exported!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Getter method for the export file
     * @return String of all the information for all the orders from the store
     */
    private String getExport() {
        StoreOrder allOrdersFromStore = mainViewController.getAllOrdersFromStore();
        String ret = "";
        for (int i = 0; i < mainViewController.getAllOrdersFromStore().getNumOfOrders(); i++) {
            if (allOrdersFromStore.get(i).isCompleted()) {
                ret += allOrdersFromStore.get(i).toString();
            }
        }
        return ret;
    }

    /**
     * Helper method that updates the view when a change is made
     */
    private void updateView() {
        if (!mainViewController.getAllOrdersFromStore().get(0).isCompleted()) {
            removeButtonFromPlaced.setDisable(true);
            removeButtonFromCurrent.setDisable(false);
            exportButton.setDisable(true);
        }
        ObservableList<String> orders = FXCollections.observableArrayList();
        StoreOrder allOrdersFromStore = mainViewController.getAllOrdersFromStore();
        if (!allOrdersFromStore.get(0).isCompleted()) {
            orders.add("No orders placed yet!");
        }
        for (int i = 0; i < mainViewController.getAllOrdersFromStore().getNumOfOrders(); i++) {
            if (allOrdersFromStore.get(i).isCompleted()) {
                orders.add(allOrdersFromStore.get(i).toString());
            }
        }
        displayAllPlacedOrders.setItems(orders);
        ObservableList<String> pizzasToOrder = FXCollections.observableArrayList();
        for (int i = 0; i < mainViewController.getCurrentOrder().getNumPizzas(); i++) {
            pizzasToOrder.add(mainViewController.getCurrentOrder().getPizza(i));
        }
        if (mainViewController.getCurrentOrder().getNumPizzas() == 0) {
            pizzasToOrder.add("No active orders right now!");
        }
        displayCurrentOrder.setItems(pizzasToOrder);
        numberOfOrders.setText(String.valueOf(mainViewController.getAllOrdersFromStore().getNumOfOrders()
                - SIZE_TO_SUBTRACT));
    }
}
