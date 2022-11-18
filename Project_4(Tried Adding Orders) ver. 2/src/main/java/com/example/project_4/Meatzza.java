package com.example.project_4;

import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class Meatzza extends Pizza{
    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    public Meatzza(ArrayList<String> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
        toppings.add("Sausage");
        toppings.add("pepperoni");
        toppings.add("beef");
        toppings.add("ham");
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    @Override
    public double price() {
        if(size.equals("Small")){
            return 15.99;
        }
        else if (size.equals("Medium")){
            return 17.99;
        }
        else{
            return 19.99;
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
