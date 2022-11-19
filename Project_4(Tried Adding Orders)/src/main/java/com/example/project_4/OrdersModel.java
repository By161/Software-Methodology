package com.example.project_4;

import java.util.ArrayList;

public class OrdersModel {
    private int orderNumber;
    private String pizzaStyle;
    private String crust;
    private ArrayList<String> toppings;
    private double subtotal;

    public OrdersModel (Integer orderNum, String pizzaStyle, String crust, ArrayList<String> toppings, double price){
        this.orderNumber = orderNum;
        this.pizzaStyle = pizzaStyle;
        this.crust = crust;
        this.toppings = toppings;
        this.subtotal = price;
    }

    public int getOrderNum(){
        return orderNumber;
    }

    public void setOrderNumber(int newOrderNum){
        this.orderNumber = newOrderNum;
    }

    public String getStyle(){
        return pizzaStyle;
    }

    public void setPizzaStyle(String style){
        this.pizzaStyle = style;
    }

    public String getCrust(){
        return crust;
    }

    public void setCrust(String crust){
        this.crust = crust;
    }

    public ArrayList<String> getToppings(){
        return (ArrayList<String>) this.toppings;
    }
    public void setToppings(ArrayList<String> toppings){
        this.toppings = toppings;
    }

    public double getPrice(){
        return this.subtotal;
    }

    public void setSubtotal(Double newPrice){
        this.subtotal = newPrice;
    }
}
