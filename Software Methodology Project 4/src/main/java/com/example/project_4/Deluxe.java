package com.example.project_4;

import java.util.ArrayList;
/**
 * Required class to make a deluxe flavored pizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Deluxe extends Pizza{
    public double price;
    private static final double SMALL_PRICE = 14.99;
    private static final double MEDIUM_PRICE = 16.99;
    private static final double LARGE_PRICE = 18.99;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;
    /**
     * Constructor for a deluxe pizza object
     * @param toppings toppings for the pizza
     * @param crust crust of the pizza
     * @param size size of the pizza
     * @param price price of the pizza
     */
    public Deluxe(ArrayList<String> toppings, Crust crust, Size size, double price) {
        super(toppings, crust, size, price);
        toppings.add("Sausage");
        toppings.add("pepperoni");
        toppings.add("green pepper");
        toppings.add("onion");
        toppings.add("mushroom");
        super.setToppings(toppings);
        super.setSize(size.getSize());
        super.setCrust(crust);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * Concrete method for the price of the pizza
     * @return the price of the pizza
     */
    @Override
    public double price() {
        if(size.equals("Small")){
            super.setPrice(SMALL_PRICE);
            return SMALL_PRICE;
        }
        else if (size.equals("Medium")){
            super.setPrice(MEDIUM_PRICE);
            return MEDIUM_PRICE;
        }
        else{
            super.setPrice(LARGE_PRICE);
            return LARGE_PRICE;
        }
    }
    /**
     * Getter method for the crust of the pizza
     * @return the crust of the pizza
     */
    public String getCrust(){
        return super.getCrust();
    }

    /**
     * Concrete method to add toppings to the pizza
     * @param obj the attribute to be added to an object
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        return toppings.add(obj.toString());
    }

    /**
     * Concrete method to remove toppings to the pizza
     * @param obj the attribute to be removed from an object
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        return toppings.remove(obj.toString());
    }
}
