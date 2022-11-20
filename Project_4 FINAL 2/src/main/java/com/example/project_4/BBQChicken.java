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

    public BBQChicken(ArrayList<String> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
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
            return 13.99;
        }
        else if (size.equals("Medium")){
            return 15.99;
        }
        else{
            return 17.99;
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
