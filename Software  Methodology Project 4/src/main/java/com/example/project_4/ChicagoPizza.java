package com.example.project_4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Required class to make a Chicago pizza type
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ChicagoPizza implements PizzaFactory {
    /**
     * Concrete method to create a deluxe flavored pizza
     * @return a new deluxe flavor pizza object
     */
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Deep Dish");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = 14.99;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = 16.99;
        }
        else{
            price = 18.99;
        }
        Pizza newChicagoDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize),
                price) {
            @Override
            public boolean add(Object obj) {
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
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = 14.99;
                        return price;
                    case "Medium":
                        price = 16.99;
                        return price;
                    case "Large":
                        price = 18.99;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newChicagoDeluxe;
    }

    /**
     * Concrete method to create a Meatzza flavored pizza
     * @return a new Meatzza flavor pizza object
     */
    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust ("Stuffed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = 15.99;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = 17.99;
        }
        else{
            price = 19.99;
        }
        Pizza newChicagoMeatzza = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize), price) {
            @Override
            public boolean add(Object obj) {
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
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = 15.99;
                        return price;
                    case "Medium":
                        price = 17.99;
                        return price;
                    case "Large":
                        price = 19.99;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newChicagoMeatzza;
    }

    /**
     * Concrete method to create a BBQChicken flavored pizza
     * @return a new BBQChicken flavored pizza object
     */
    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust ("Pan");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = 13.99;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = 15.99;
        }
        else{
            price = 17.99;
        }
        Pizza newBBQChicken = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize), price) {
            @Override
            public boolean add(Object obj) {
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
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = 13.99;
                        return price;
                    case "Medium":
                        price = 15.99;
                        return price;
                    case "Large":
                        price = 17.99;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newBBQChicken;
    }

    /**
     * Concrete method to create a build your own pizza
     * @return a new customized build your own pizza object
     */
    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust ("Pan");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppings = new ArrayList<String>();
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = 8.99;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = 10.99;
        }
        else{
            price = 12.99;
        }
        Pizza newChicagoBuildYourOwn = new Pizza(ChicagoPizzaController.listToppingsChicagoBuildYourOwn, crust,
                new Size(ChicagoPizzaController.chicagoSize),
                price + (1.59*ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size())) {
            @Override
            public boolean add(Object obj) {
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
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = 8.99 + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size()*1.59);
                        return price;
                    case "Medium":
                        price = 10.99 + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size()*1.59);
                        return price;
                    case "Large":
                        price = 12.99 + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size()*1.59);
                        return price;
                    default:
                        return price;
                }
            }
        };
        newChicagoBuildYourOwn.price();
        return newChicagoBuildYourOwn;
    }
}
