package com.example.project_4;


import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class BuildYourOwn extends Pizza{
    public double price = 0;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    public BuildYourOwn(ArrayList<String> toppings, Crust crust, Size size, double price) {
        super(toppings, crust, size, price);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    public double price() {
        switch (size.getSize()) {
            case "Small":
                price = 8.99;
                return price;
            case "Medium":
                price = 10.99;
                return price;
            case "Large":
                price = 12.99;
                return price;
            default:
                return price;
        }
    }

    @Override
    public boolean add(Object obj) {
        if (toppings.size() <= 7){
            toppings.add(obj.toString());
        }
        return false;
    }

    public String getCrust(){
        return this.crust.getCrust();
    }

    public void setCrust(String newCrust){
        this.crust = new Crust(newCrust);
    }

    @Override
    public boolean remove(Object obj) {
        if(toppings.contains(obj.toString())){
            toppings.remove(obj.toString());
            return true;
        }
        return false;
    }
}
