package com.example.project_4;

import java.util.ArrayList;

public class Deluxe extends Pizza{
    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

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

    @Override
    public double price() {
        if(size.equals("Small")){
            super.setPrice(14.99);
            return 14.99;
        }
        else if (size.equals("Medium")){
            super.setPrice(16.99);
            return 16.99;
        }
        else{
            super.setPrice(18.99);
            return 18.99;
        }
    }
    public String getCrust(){
        return super.getCrust();
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
