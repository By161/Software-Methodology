package com.example.project_4;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class OrdersModel {
    private SimpleIntegerProperty orderNumber;
    private SimpleStringProperty pizzaStyle;
    private SimpleStringProperty crust;
    private SimpleListProperty toppings;
    private SimpleDoubleProperty subtotal;

    public OrdersModel (Integer orderNum, String pizzaStyle, String crust, ArrayList<String> toppings, double price){
        this.orderNumber = new SimpleIntegerProperty(orderNum);
        this.pizzaStyle = new SimpleStringProperty(pizzaStyle);
        this.crust = new SimpleStringProperty(crust);
        this.toppings = new SimpleListProperty((ObservableList) toppings);
        this.subtotal = new SimpleDoubleProperty(price);
    }

    public int getOrderNum(){
        return orderNumber.get();
    }

    public void setOrderNumber(int newOrderNum){
        this.orderNumber = new SimpleIntegerProperty(newOrderNum);
    }

    public String getStyle(){
        return pizzaStyle.get();
    }

    public void setPizzaStyle(String style){
        this.pizzaStyle = new SimpleStringProperty(style);
    }

    public String getCrust(){
        return crust.get();
    }

    public void setCrust(String crust){
        this.crust = new SimpleStringProperty(crust);
    }

    public ArrayList<String> getToppings(){
        return (ArrayList<String>) this.toppings.get();
    }
    public void setToppings(ArrayList<String> toppings){
        this.toppings = new SimpleListProperty<>((ObservableList) toppings);
    }

    public double getPrice(){
        return this.subtotal.get();
    }

    public void setSubtotal(Double newPrice){
        this.subtotal = new SimpleDoubleProperty(newPrice);
    }
}
