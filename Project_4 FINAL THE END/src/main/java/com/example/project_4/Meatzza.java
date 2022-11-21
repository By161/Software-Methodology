package com.example.project_4;

import java.util.ArrayList;

/**
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

    public String getCrust(){
        return this.crust.getCrust();
    }

    public void setCrust(String newCrust){
        this.crust = new Crust(newCrust);
    }

    @Override
    public boolean add(Object obj) {
        return toppings.add(obj.toString());
    }

    @Override
    public boolean remove(Object obj) {
        return toppings.remove(obj.toString());
    }
}
