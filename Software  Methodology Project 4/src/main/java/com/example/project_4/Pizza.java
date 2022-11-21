package com.example.project_4;


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Required abstract class that makes the pizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public abstract class Pizza implements Customizable{
    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    /**
     * Constructor for the pizza object
     * @param toppings the toppings of the pizza
     * @param crust the crust of the pizza
     * @param size the size of the pizza
     * @param price the price of the pizza
     */
    public Pizza(ArrayList<String> toppings, Crust crust, Size size, double price){
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
        this.price = price;
    }

    /**
     * Getter method for the crust of the pizza
     * @return the crust of the pizza
     */
    public String getCrust() {
        return crust.getCrust();
    }

    /**
     * Setter method for the crust of the pizza
     * @param crust the new crust for the pizza
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * Getter method for the size of the pizza
     * @return the size of the pizza
     */
    public Size getSize() {
        return size;
    }

    /**
     * Setter method for the size of the pizza
     * @param size the new size for the pizza
     */
    public void setSize(String size) {
        this.size = new Size(size);
    }

    /**
     * Getter method for the price of the pizza
     * @return the price of the pizza
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Setter method for the price of the pizza
     * @param newPrice the new price of the pizza
     */
    public void setPrice(double newPrice){ this.price = newPrice; }

    /**
     * Setter method for the toppings of the pizza
     * @param selectedToppings the toppings for the pizza
     */
    public void setToppings(ArrayList<String> selectedToppings){
        this.toppings = selectedToppings;
    }

    /**
     * toString method for the pizza to better represent the information of the pizza
     * @return String to show the information of the pizza
     */
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#.00");
        return (this.toppings + ", " + crust + ", " + this.size.getSize() + ", $" +  df.format(price));
    }
}
