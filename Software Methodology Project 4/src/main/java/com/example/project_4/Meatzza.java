package com.example.project_4;

import java.util.ArrayList;

/**
 * Required class to create the Meatzza flavored pizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Meatzza extends Pizza{
    public double price;
    private static final double SMALL_PRICE = 15.99;
    private static final double MEDIUM_PRICE = 17.99;
    private static final double LARGE_PRICE = 19.99;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    /**
     * Constructor for the Meatzza flavored pizza object
     * @param toppings the toppings on the pizza
     * @param crust the crust of the pizza
     * @param size the size of the pizza
     * @param price the price of the pizza
     */
    public Meatzza(ArrayList<String> toppings, Crust crust, Size size, double price) {
        super(toppings, crust, size, price);
        toppings.add("Sausage");
        toppings.add("pepperoni");
        toppings.add("beef");
        toppings.add("ham");
        super.setToppings(toppings);
        super.setSize(size.getSize());
        super.setCrust(crust);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    /**
     * Concrete method to return the price of the pizza
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
     * Getter Method for the crust of the pizza
     * @return the crust of the pizza
     */
    public String getCrust(){
        return this.crust.getCrust();
    }

    /**
     * Setter Method for the crust of the pizza
     * @param newCrust the new crust for the pizza
     */
    public void setCrust(String newCrust){
        this.crust = new Crust(newCrust);
    }

    /**
     * Concrete class to add toppings to the pizza
     * @param obj the attribute to be added to an object
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        return toppings.add(obj.toString());
    }

    /**
     * Concrete class to remove toppings from the pizza
     * @param obj the attribute to be removed from an object
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        return toppings.remove(obj.toString());
    }
}
