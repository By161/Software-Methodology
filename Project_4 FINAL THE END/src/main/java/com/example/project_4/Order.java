package com.example.project_4;

import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 * Required class to make an order object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Order implements Customizable {
    private static final double SALES_TAX_1 = 1.06625;
    private static final double SALES_TAX_0 = 0.06625;
    private double ZERO_DOUBLE = 0.00;
    private boolean completed;
    private int orderNumberFinal;
    private LinkedList<Pizza> pizzas = new LinkedList<>();

    /**
     * Constructor for the order object
     */
    public Order() {
        completed = false;
    }

    /**
     * Getter method to see the status of the order
     * @return boolean value of order object
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Helper method to help determine when to make a new order
     * @return set true if order is done, false otherwise
     */
    public boolean makeCompleted() {
        if (completed) {
            return false;
        }
        else {
            completed = true;
            orderNumberFinal = CurrentOrderController.orderNumber;
            CurrentOrderController.orderNumber++;
            CurrentOrderController.orderNumberForLabel++;
            return true;
        }
    }

    /**
     * Getter method that returns the order number of the current order
     * @return integer specifying the order number
     */
    public int getOrderNumber() {
        return orderNumberFinal;
    }

    /**
     * Getter method that returns the order number of the current order for the FXML label
     * @return integer specifying the labeled order number in the order controller
     */
    public int getOrderNumberForLabel() {
        return CurrentOrderController.orderNumberForLabel;
    }

    /**
     * Getter method that returns the amount of pizzas in the order
     * @return number of pizzas in the order
     */
    public int getNumPizzas() {
        return pizzas.size();
    }

    /**
     * Helper Method that adds the inputted pizza to the list
     * @param obj Pizza that is intended to be added to the order
     * @return true if the pizza has been added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        Pizza pizza = (Pizza) obj;
        if (pizzas.size() == 0) {
            pizzas.add(pizza);
            return true;
        }
        else if (pizzas.contains(pizza)) {
            return true;
        }
        else {
            pizzas.add(pizza);
            return true;
        }
    }

    /**
     * Helper method that removes the inputted pizza from the list
     * @param obj Pizza that is intended to be removed from the order
     * @return true if the pizza has been removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        int i = (int) obj;
        pizzas.remove(i);
        return true;
    }

    /**
     * Helper method that clears all the pizzas in the current order
     */
    public void clearOrder(){
        pizzas.clear();
    }

    /**
     * Helper method to get the cost before tax
     * @return the cost before tax
     */
    public String getCostBeforeTax() {
        double priceBeforeTax = ZERO_DOUBLE;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String costBeforeTaxString = df.format(priceBeforeTax);
        return "$" + costBeforeTaxString;
    }

    /**
     * Helper method to get the tax cost
     * @return the tax cost
     */
    public String getTax() {
        double priceBeforeTax = ZERO_DOUBLE;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        double taxAmount = priceBeforeTax * SALES_TAX_0;
        DecimalFormat df = new DecimalFormat("#.##");
        String taxAmountString = df.format(taxAmount);
        return "$" + taxAmountString;
    }

    /**
     * Helper method that gets the total cost of the order
     * @return the total cost of the order
     */
    public String getTotalCost() {
        double priceBeforeTax = ZERO_DOUBLE;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        double finalTotalCost = priceBeforeTax * SALES_TAX_1;
        DecimalFormat df = new DecimalFormat("#.##");
        String totalCostString = df.format(finalTotalCost);
        return "$" + totalCostString;
    }

    /**
     * toString method for the order to easily represent the information of the order
     * @return String that easily represents the order object
     */
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < pizzas.size(); i++) {
            returnString += pizzas.get(i) + "\n";
        }
        returnString += getTotalCost();
        return returnString;
    }

    /**
     * Helper method that represents order information with the order number to be referred to in the
     * Store Orders Controller
     * @return String that represents the order object with the order number
     */
    public String toStringWithOrderNumber() {
        String returnString = "Order Number: " + String.valueOf(getOrderNumber()) + " , ";
        for (int i = 0; i < pizzas.size(); i++) {
            returnString += pizzas.get(i) + "\n";
        }
        returnString += getTotalCost();
        return returnString;
    }

    /**
     * Getter method to get the pizza at the inputted index
     * @param index inputted index where we want to access the order
     * @return the pizza at the desired index
     */
    public String getPizza(int index) {
        return pizzas.get(index).toString();
    }
}