package com.example.project_4;


import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public abstract class Pizza implements Customizable{
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza(ArrayList<Topping> toppings, Crust crust, Size size){
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }
}
