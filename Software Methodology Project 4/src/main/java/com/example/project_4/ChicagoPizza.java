package com.example.project_4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Required class for the chicago pizza type
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class ChicagoPizza implements PizzaFactory {
    public static final double PRICE_TOPPING = 1.59;
    public static double PRICE_SMALL_DELUXE = 14.99;
    public static double PRICE_MEDIUM_DELUXE = 16.99;
    public static double PRICE_LARGE_DELUXE = 18.99;
    public static double PRICE_SMALL_BBQ = 13.99;
    public static double PRICE_MEDIUM_BBQ = 15.99;
    public static double PRICE_LARGE_BBQ = 17.99;
    public static double PRICE_SMALL_MEATZZA = 15.99;
    public static double PRICE_MEDIUM_MEATZZA = 17.99;
    public static double PRICE_LARGE_MEATZZA = 19.99;
    public static double PRICE_SMALL_BYO = 8.99;
    public static double PRICE_MEDIUM_BYO = 10.99;
    public static double PRICE_LARGE_BYO = 12.99;

    /**
     * Method that creates a deluxe flavored pizza
     * @return the new deluxe flavored pizza object
     */
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Deep Dish");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = PRICE_SMALL_DELUXE;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = PRICE_MEDIUM_DELUXE;
        }
        else{
            price = PRICE_LARGE_DELUXE;
        }
        Pizza newChicagoDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize), price) {
            /**
             * Concrete method to add toppings to the pizza
             * @param obj the specified attribute that is to be added to the object
             * @return true if added, false otherwise
             */
            @Override
            public boolean add(Object obj) {
                return true;
            }

            /**
             * Concrete method to remove toppings from the pizza
             * @param obj the specified attribute that is to be removed from the object
             * @return true if removed, false otherwise
             */
            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }
            /**
             * Concrete method to calculate the price of the pizza
             * @return the price of the pizza
             */
            @Override
            public double price() {
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = PRICE_SMALL_DELUXE;
                        return price;
                    case "Medium":
                        price = PRICE_MEDIUM_DELUXE;
                        return price;
                    case "Large":
                        price = PRICE_LARGE_DELUXE;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newChicagoDeluxe;
    }

    /**
     * Method that creates a Meatzza flavored pizza
     * @return the new Meatzza flavored pizza
     */
    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust ("Stuffed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = PRICE_SMALL_MEATZZA;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = PRICE_MEDIUM_MEATZZA;
        }
        else{
            price = PRICE_MEDIUM_MEATZZA;
        }
        Pizza newChicagoMeatzza = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize), price) {
            /**
             * Concrete method to add toppings to the pizza
             * @param obj the specified attribute that is to be added to the object
             * @return true if added, false otherwise
             */
            @Override
            public boolean add(Object obj) {
                return true;
            }

            /**
             * Concrete method to remove toppings from the pizza
             * @param obj the specified attribute that is to be removed from the object
             * @return true if removed, false otherwise
             */
            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }
            /**
             * Concrete method to calculate the price of the pizza
             * @return the price of the pizza
             */
            @Override
            public double price() {
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = PRICE_SMALL_MEATZZA;
                        return price;
                    case "Medium":
                        price = PRICE_MEDIUM_MEATZZA;
                        return price;
                    case "Large":
                        price = PRICE_LARGE_MEATZZA;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newChicagoMeatzza;
    }

    /**
     * Method that creates a BBQChicken flavored pizza
     * @return the new BBQChicken flavored pizza
     */
    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust ("Pan");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = PRICE_SMALL_BBQ;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = PRICE_MEDIUM_BBQ;
        }
        else{
            price = PRICE_LARGE_BBQ;
        }
        Pizza newBBQChicken = new Pizza(listToppingsDeluxe, crust, new Size(ChicagoPizzaController.chicagoSize), price) {
            /**
             * Concrete method to add toppings to the pizza
             * @param obj the specified attribute that is to be added to the object
             * @return true if added, false otherwise
             */
            @Override
            public boolean add(Object obj) {
                return true;
            }

            /**
             * Concrete method to remove toppings from the pizza
             * @param obj the specified attribute that is to be removed from the object
             * @return true if removed, false otherwise
             */
            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }
            /**
             * Concrete method to calculate the price of the pizza
             * @return the price of the pizza
             */
            @Override
            public double price() {
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = PRICE_SMALL_BBQ;
                        return price;
                    case "Medium":
                        price = PRICE_MEDIUM_BBQ;
                        return price;
                    case "Large":
                        price = PRICE_LARGE_BBQ;
                        return price;
                    default:
                        return price;
                }
            }
        };
        return newBBQChicken;
    }

    /**
     * Method that creates a build your own pizza
     * @return the customized pizza
     */
    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust ("Pan");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppings = new ArrayList<String>();
        double price;
        if(ChicagoPizzaController.chicagoSize.equals("Small")){
            price = PRICE_SMALL_BYO;
        }
        else if(ChicagoPizzaController.chicagoSize.equals("Medium")){
            price = PRICE_MEDIUM_BYO;
        }
        else{
            price = PRICE_LARGE_BYO;
        }
        Pizza newChicagoBuildYourOwn = new Pizza(ChicagoPizzaController.listToppingsChicagoBuildYourOwn, crust,
                new Size(ChicagoPizzaController.chicagoSize),
                price + (PRICE_TOPPING * ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size())) {
            /**
             * Concrete method to add toppings to the pizza
             * @param obj the specified attribute that is to be added to the object
             * @return true if added, false otherwise
             */
            @Override
            public boolean add(Object obj) {
                return true;
            }

            /**
             * Concrete method to remove toppings from the pizza
             * @param obj the specified attribute that is to be removed from the object
             * @return true if removed, false otherwise
             */
            @Override
            public boolean remove(Object obj) {
                if(toppings.contains((Topping) obj)){
                    toppings.remove((Topping) obj);
                    return true;
                }
                return false;
            }
            /**
             * Concrete method to calculate the price of the pizza
             * @return the price of the pizza
             */
            @Override
            public double price() {
                switch (ChicagoPizzaController.chicagoSize) {
                    case "Small":
                        price = PRICE_SMALL_BYO + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size() *
                                PRICE_TOPPING);
                        return price;
                    case "Medium":
                        price = PRICE_MEDIUM_BYO + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size() *
                                PRICE_TOPPING);
                        return price;
                    case "Large":
                        price = PRICE_LARGE_BYO + (ChicagoPizzaController.listToppingsChicagoBuildYourOwn.size() *
                                PRICE_TOPPING);
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
