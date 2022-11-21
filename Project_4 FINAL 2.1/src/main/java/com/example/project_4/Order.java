package com.example.project_4;

import java.text.DecimalFormat;
import java.util.LinkedList;

public class Order implements Customizable {
    private static final double SALES_TAX = 1.06625;
    private boolean completed;
    private LinkedList<Pizza> pizzas = new LinkedList<>();

    public Order() {
        completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean makeCompleted() {
        if (completed) {
            return false;
        }
        else {
            completed = true;
            return true;
        }
    }

    public int getNumPizzas() {
        return pizzas.size();
    }

    @Override
    public boolean add(Object obj) {
        Pizza pizza = (Pizza) obj;
        if (pizzas.size() == 0) {
            pizzas.add(pizza);
            return true;
        }
        else if (pizzas.contains(pizza)) {
            return true;
            //might not work - bc i can add the same pizza multiple times
        }
        else {
            pizzas.add(pizza);
            return true;
        }
    }

    @Override
    public boolean remove(Object obj) {
        int i = (int) obj;
        pizzas.remove(i);
        return true;
    }

    public String getCostBeforeTax() {
        double priceBeforeTax = 0.00;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        DecimalFormat df = new DecimalFormat("#.##");
        String costBeforeTaxString = df.format(priceBeforeTax);
        return "$" + costBeforeTaxString;
    }

    public String getTax() {
        double priceBeforeTax = 0.00;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        double taxAmount = priceBeforeTax * SALES_TAX;
        DecimalFormat df = new DecimalFormat("#.##");
        String taxAmountString = df.format(taxAmount);
        return "$" + taxAmountString;
    }

    public String getTotalCost() {
        double priceBeforeTax = 0.00;
        for (int i = 0; i < pizzas.size(); i++) {
            priceBeforeTax += pizzas.get(i).price();
        }
        double finalTotalCost = priceBeforeTax * SALES_TAX;
        DecimalFormat df = new DecimalFormat("#.##");
        String totalCostString = df.format(finalTotalCost);
        return "$" + totalCostString;
    }

//    public String getIndividualCost(){
//        for(int i = 0; i < pizzas.size(); i++){
//
//        }
//    }
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < pizzas.size(); i++) {
            returnString += pizzas.get(i) + "\n";
        }
        returnString += getTotalCost();
        return returnString;
    }

    public String getPizza(int index) {
        return pizzas.get(index).toString();
    }
    //might not need this

    //maybe include Item Number: Index
    // then have box saying Enter Item Number to Remove: and remove button next to it

}