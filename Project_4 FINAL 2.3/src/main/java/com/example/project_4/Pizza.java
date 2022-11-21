package com.example.project_4;


import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public abstract class Pizza implements Customizable{
    public double price;
    private ArrayList<String> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    public Pizza(ArrayList<String> toppings, Crust crust, Size size, double price){
        this.toppings = toppings;
        this.crust = crust;
        this.size = size;
        this.price = price;
    }

    public String getCrust() {
        return crust.getCrust();
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = new Size(size);
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double newPrice){ this.price = newPrice; }

    public void setToppings(ArrayList<String> selectedToppings){
        this.toppings = selectedToppings;
    }


    @Override
    public String toString(){
        return (this.toppings + ", " + crust + ", " + price);
    }
}
