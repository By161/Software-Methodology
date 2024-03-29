package com.example.project_4;


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Required class for the Build Your Own flavor pizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class BuildYourOwn extends Pizza{
    public double price = 0;
    private static final int MAX_NUM_TOPPINGS = 7;
    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = 10.99;
    private static final double LARGE_PRICE = 12.99;
    private static final double ADD_PRICE = 1.59;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    /**
     * Constructor for the Build Your Own pizza
     * @param toppings list of toppings for the pizza
     * @param crust type of crust of the pizza
     * @param size size of the pizza
     * @param price price of the pizza
     */
    public BuildYourOwn(ArrayList<String> toppings, Crust crust, Size size, double price) {
        super(toppings, crust, size, price);
        super.setToppings(toppings);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * Helper method that calculates the price of the pizza
     * @return the price of the pizza
     */
    public double price() {
        DecimalFormat df = new DecimalFormat("#.##");
        if(size.getSize().equals("Small")){
            df.format(this.price = SMALL_PRICE + toppings.size() * ADD_PRICE);
            return this.price;
        }
        else if (size.getSize().equals("Medium")){
            df.format(this.price = MEDIUM_PRICE + toppings.size() * ADD_PRICE);
            return this.price;
        }
        else{
            df.format(this.price = LARGE_PRICE + toppings.size() * ADD_PRICE);
            return this.price;
        }
    }

    /**
     * Helper method that adds toppings
     * @param obj topping that wants to be added
     * @return true if the topping has been added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if (toppings.size() <= MAX_NUM_TOPPINGS){
            toppings.add(obj.toString());
        }
        return false;
    }

    /**
     * Getter method that returns the crust
     * @return String that shows the crust of the pizza
     */
    public String getCrust(){
        return this.crust.getCrust();
    }

    /**
     * Helper method that removes toppings
     * @param obj topping that wants to be removed
     * @return true if the topping has been removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(toppings.contains(obj.toString())){
            toppings.remove(obj.toString());
            return true;
        }
        return false;
    }
}
