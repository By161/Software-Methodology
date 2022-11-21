package com.example.project_4;

import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class BBQChicken extends Pizza{

    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

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

    @Override
    public double price() {
        if(size.equals("Small")){
            price = 13.99;
            return price;
        }
        else if (size.equals("Medium")){
            price = 15.99;
            return price;
        }
        else{
            price = 17.99;
            return price;
        }
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
