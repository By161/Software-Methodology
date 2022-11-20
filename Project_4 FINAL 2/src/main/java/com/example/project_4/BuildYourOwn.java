package com.example.project_4;


import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class BuildYourOwn extends Pizza{
    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;

    public BuildYourOwn(ArrayList<String> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    public double price() {
        switch (size.getSize()) {
            case "Small":
                return 8.99;
            case "Medium":
                return 10.99;
            case "Large":
                return 12.99;
            default:
                return 0;
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
