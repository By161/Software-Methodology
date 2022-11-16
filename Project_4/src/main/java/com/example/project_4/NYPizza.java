package com.example.project_4;

import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class NYPizza implements PizzaFactory {
    String flavor;
    Crust crust;
    ArrayList<Topping> toppings;
    Size size;

    public NYPizza(String flavor, Crust crust, ArrayList<Topping> toppings, Size size) {
        this.flavor = flavor;
        this.crust = crust;
        this.toppings = toppings;
        this.size = size;
    }

    @Override
    public Pizza createDeluxe() {
        Pizza newNYDeluxePizza = new Pizza(toppings, this.crust, this.size) {
            @Override
            public boolean add(Object obj) {
                toppings.add(new Topping ("Sausage"));
                toppings.add(new Topping("pepperoni"));
                toppings.add(new Topping("green pepper"));
                toppings.add (new Topping("onion"));
                toppings.add(new Topping("mushroom"));
                return true;
            }

            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }

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
        };
        return newNYDeluxePizza;
    }

    @Override
    public Pizza createMeatzza() {
        Pizza newNYMeatzza = new Pizza(toppings, this.crust, this.size) {
            @Override
            public boolean add(Object obj) {
                toppings.add(new Topping ("Sausage"));
                toppings.add(new Topping("pepperoni"));
                toppings.add(new Topping("beef"));
                toppings.add (new Topping("ham"));
                return true;
            }

            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }

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
        };
        return newNYMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Pizza newNYCreateBBCChicken = new Pizza(toppings, this.crust, this.size) {
            @Override
            public boolean add(Object obj) {
                toppings.add(new Topping ("BBQ Chicken"));
                toppings.add(new Topping("green pepper"));
                toppings.add(new Topping("provolone"));
                toppings.add (new Topping("cheddar"));
                return true;
            }

            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }

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
        };
        return newNYCreateBBCChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Pizza newBuildYourOwn = new Pizza(toppings, this.crust, this.size) {
            @Override
            public boolean add(Object obj) {
                if (toppings.size() < 7){
                    toppings.add((Topping) obj);
                }
                return false;
            }

            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }

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
        };
        return newBuildYourOwn;
    }
}
