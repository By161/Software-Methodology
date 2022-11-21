package com.example.project_4;

import java.util.ArrayList;

/**
 * Required class that makes the BBQChicken pizza flavor
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class BBQChicken extends Pizza{

    public double price;
    private static final double SMALL_PRICE = 13.99;
    private static final double MEDIUM_PRICE = 15.99;
    private static final double LARGE_PRICE = 17.99;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    /**
     * Constructor for the BBQChicken object
     * @param toppings the list of toppings for the pizza
     * @param crust the crust of the pizza
     * @param size the size of the pizza
     * @param price the price of the pizza
     */
    public BBQChicken(ArrayList<String> toppings, Crust crust, Size size, double price) {
        super(toppings, crust, size, price);
        toppings.add("BBQChicken");
        toppings.add("green pepper");
        toppings.add("provolone");
        toppings.add("cheddar");
        super.setToppings(toppings);
        super.setSize(size.getSize());
        super.setCrust(crust);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * Concrete method that returns the price of the pizza
     * @return the price of the pizza
     */
    @Override
    public double price() {
        if(size.equals("Small")){
            price = SMALL_PRICE;
            return price;
        }
        else if (size.equals("Medium")){
            price = MEDIUM_PRICE;
            return price;
        }
        else{
            price = LARGE_PRICE;
            return price;
        }
    }

    /**
     * Concrete method that adds toppings to the pizza
     * @param obj desired topping
     * @return true if topping was added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        return toppings.add(obj.toString());
    }

    /**
     * Concrete method that removes toppings from the pizza
     * @param obj desired topping to remove
     * @return true if topping was removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        return toppings.remove(obj.toString());
    }
}