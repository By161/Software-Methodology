package com.example.project_4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Controller for the view to see your current order/selected pizzas
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class CurrentOrderController {
    private MainViewController mainViewController;
    //private static final double SALES_TAX = .06625;
    private int orderNumber = 1;
    @FXML
    Button removeButton = new Button();

    @FXML
    Button clearOrderButton = new Button();

    @FXML
    Button placeOrderButton = new Button();

    @FXML
    ListView displayPizzas;

    @FXML
    TextField orderNumberLabel;

    @FXML
    TextField costBeforeTaxLabel;

    @FXML
    TextField taxAmountLabel;

    @FXML
    TextField totalCostLabel;

    /**
     * called from the MainViewController to give this class access to the data from the other classes
     * @param controller the reference to the MainViewController
     */
    public void setMainViewController(MainViewController controller) {
        this.mainViewController = controller;
        updateView();
    }

    /**
     * initializes the necessary fields
     */
    public void initialize() {
        orderNumberLabel.setEditable(false);
        taxAmountLabel.setEditable(false);
        totalCostLabel.setEditable(false);
        costBeforeTaxLabel.setEditable(false);
        removeOrder();
        placeOrder();
        clearOrder();
    }

    /**
     * Method that occurs when the remove button is clicked
     */
    public void removeOrder() {
        removeButton.setOnAction(actionEvent -> {
            int removeThisOrder = displayPizzas.getSelectionModel().getSelectedIndex();
            mainViewController.getCurrentOrder().remove(removeThisOrder);
            updateView();
        });
    }

    /**
     * Clears the list of pizzas in the cart when the clear button is clicked
     */
    public void clearOrder() {
        clearOrderButton.setOnAction(actionEvent -> {
            displayPizzas.getItems().clear();
            mainViewController.getCurrentOrder().clearOrder();
            updateView();
        });
    }

    /**
     * Places the order with all the items in your current cart when the place order button is clicked.
     */
    public void placeOrder() {
        placeOrderButton.setOnAction(actionEvent -> {
            mainViewController.getCurrentOrder().makeCompleted();
            mainViewController.getAllOrdersFromStore().updateCurrentOrder();
            //mainViewController.confirmPopup("Successfully submitted!"); //we would need to add this
            ObservableList<String> orderedPizzas = FXCollections.observableArrayList();
            orderedPizzas.add("");
            displayPizzas.setItems(orderedPizzas);
            orderNumber++;
            taxAmountLabel.setText("0.00");
            costBeforeTaxLabel.setText("0.00");
            totalCostLabel.setText("0.00");
        });
    }

    /**
     * updates the ListView after a change has been made
     */
    public void updateView() {
        if (mainViewController.getCurrentOrder().getNumPizzas() == 0) {
            removeButton.setDisable(true);
            placeOrderButton.setDisable(true);
            clearOrderButton.setDisable(true);
        }
        ObservableList<String> orderedPizzas = FXCollections.observableArrayList();
        for (int i = 0; i < mainViewController.getCurrentOrder().getNumPizzas(); i++) {
            if (mainViewController.getCurrentOrder().getPizza(i).contains("Brooklyn") ||
                    mainViewController.getCurrentOrder().getPizza(i).contains("Thin") ||
                    mainViewController.getCurrentOrder().getPizza(i).contains("Hand Tossed")){
                orderedPizzas.add("New York Style: " + mainViewController.getCurrentOrder().getPizza(i));
            }
            else{
                orderedPizzas.add("Chicago Style: " + mainViewController.getCurrentOrder().getPizza(i));
            }
        }
        if (mainViewController.getCurrentOrder().getNumPizzas() == 0) {
            orderedPizzas.add("Your pizza cart is empty!");
        }
        displayPizzas.setItems(orderedPizzas);
        orderNumberLabel.setText(String.valueOf(orderNumber));
        updateLabel();
    }

    /**
     * updates the label after a change has been made
     */
    public void updateLabel() {
        String costBeforeTax = mainViewController.getCurrentOrder().getCostBeforeTax();
        String taxAmount = mainViewController.getCurrentOrder().getTax();
        String totalCost = mainViewController.getCurrentOrder().getTotalCost();
        costBeforeTaxLabel.setText(costBeforeTax);
        taxAmountLabel.setText(taxAmount);
        totalCostLabel.setText(totalCost);
    }
}
