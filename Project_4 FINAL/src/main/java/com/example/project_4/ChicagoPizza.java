package com.example.project_4;

import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Required class to make a chicago pizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ChicagoPizza implements PizzaFactory{
    Crust crust;
    ArrayList<String> myToppings;
    Size size;

    @Override
    public Pizza createDeluxe() {
        myToppings.add ("Sausage");
        myToppings.add ("pepperoni");
        myToppings.add ("green pepper");
        myToppings.add  ("onion");
        myToppings.add ("mushroom");
        Pizza createChicagoDeluxe = new Pizza(myToppings, this.crust, this.size) {
            @Override
            public double price() {
                switch (size.getSize()) {
                    case "Small":
                        return 14.99;
                    case "Medium":
                        return 16.99;
                    case "Large":
                        return 17.99;
                    default:
                        return 0;
                }
            }
            @Override
            public boolean add(Object obj) {

                return true;
            }

            @Override
            public boolean remove(Object obj) {
                return false;
            }
        };
        return createChicagoDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        myToppings.add ("Sausage");
        myToppings.add ("pepperoni");
        myToppings.add ("beef");
        myToppings.add ("ham");
        Pizza createChicagoMeatzza = new Pizza(myToppings, this.crust, this.size) {
            @Override
            public double price() {
                switch (size.getSize()) {
                    case "Small":
                        return 15.99;
                    case "Medium":
                        return 17.99;
                    case "Large":
                        return 19.99;
                    default:
                        return 0;
                }
            }

            @Override
            public boolean add(Object obj) {
                return true;
            }

            @Override
            public boolean remove(Object obj) {
                if(myToppings.contains((Topping) obj)){
                    myToppings.remove(obj);
                    return true;
                }
                return false;
            }
        };
        return createChicagoMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        myToppings.add ("BBQ Chicken");
        myToppings.add ("green pepper");
        myToppings.add ("provolone");
        myToppings.add ("cheddar");
        Pizza createBBQChicken = new Pizza(myToppings, this.crust, this.size){
            @Override
            public double price() {
                switch (size.getSize()) {
                    case "Small":
                        return 13.99;
                    case "Medium":
                        return 15.99;
                    case "Large":
                        return 17.99;
                    default:
                        return 0;
                }
            }

            @Override
            public boolean add(Object obj) {

                return true;
            }

            @Override
            public boolean remove(Object obj) {
                if(myToppings.contains((Topping) obj)){
                    myToppings.remove(obj.toString());
                    return true;
                }
                return false;
            }
        };
        return createBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {

        Pizza newBuildYourOwn = new Pizza(myToppings, this.crust, this.size) {
            @Override
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
                if (myToppings.size() <= 7){
                    myToppings.add(obj.toString());
                }
                return false;
            }

            @Override
            public boolean remove(Object obj) {
                if(myToppings.contains((Topping) obj)){
                    myToppings.remove(obj.toString());
                    return true;
                }
                return false;
            }
        };
        return newBuildYourOwn;
    }
    public ArrayList<String> getToppings(){
        return this.myToppings;
    }
}
