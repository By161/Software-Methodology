package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.FileWriter;
import java.io.IOException;

public class StoreOrdersController {
    private MainViewController mainViewController;

    @FXML
    ListView displayAllOrders;

    @FXML
    Button removeButton = new Button();

    @FXML
    Button exportButton = new Button();

    public void setMainViewController(MainViewController controller) {
        this.mainViewController = controller;
    }

    public void initialize() {
        removeButtonHandler();
        exportButtonHandler();
    }

    public void setMainController(MainViewController controller) {
        this.mainViewController = controller;
        updateView();
    }

    private void removeButtonHandler() {
        removeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (displayAllOrders.getSelectionModel().getSelectedIndex() == -1) {
                    //mainViewController.confirmPopup("Not applicable!");
                    return;
                }
                int removeIndex = displayAllOrders.getSelectionModel().getSelectedIndex();
                mainViewController.getAllOrdersFromStore().remove(removeIndex);
                updateView();
            }
        });
    }

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

    private void updateView() {
        if (!mainViewController.getAllOrdersFromStore().get(0).isCompleted()) {
            removeButton.setDisable(true);
            exportButton.setDisable(true);
        }
        ObservableList<String> orders = FXCollections.observableArrayList();
        StoreOrder allOrdersFromStore = mainViewController.getAllOrdersFromStore();
        if (!allOrdersFromStore.get(0).isCompleted()) {
            orders.add("No orders yet!");
        }
        for (int i = 0; i < mainViewController.getAllOrdersFromStore().getNumOfOrders(); i++) {
            if (allOrdersFromStore.get(i).isCompleted()) {
                orders.add(allOrdersFromStore.get(i).toString());
            }
        }
        displayAllOrders.setItems(orders);
    }
}
