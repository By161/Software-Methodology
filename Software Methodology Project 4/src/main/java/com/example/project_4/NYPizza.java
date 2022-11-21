package com.example.project_4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Required Class to make a NYPizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class NYPizza implements PizzaFactory {
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
     * Method to create a deluxe flavored pizza object
     * @return the deluxe flavored pizza
     */
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Brooklyn");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = PRICE_SMALL_DELUXE;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = PRICE_MEDIUM_DELUXE;
        }
        else{
            price = PRICE_LARGE_DELUXE;
        }
        Pizza newNYDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
            /**
             * Concrete method to add a topping to the pizza
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
                switch (NYPizzaController.size) {
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
        return newNYDeluxe;
    }

    /**
     * Method to create a Meatzza flavored Pizza object
     * @return the meatzza pizza object
     */
    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust ("Hand Tossed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = PRICE_SMALL_MEATZZA;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = PRICE_MEDIUM_MEATZZA;
        }
        else{
            price = PRICE_LARGE_MEATZZA;
        }
        Pizza newNYMeatzza = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
            /**
             * Concrete method to add a topping to the pizza
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
                switch (NYPizzaController.size) {
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
        return newNYMeatzza;
    }

    /**
     * Method to create a BBQChicken flavored pizza object
     * @return the BBQChicken flavored pizza object
     */
    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust ("Thin");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = PRICE_SMALL_BBQ;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = PRICE_MEDIUM_BBQ;
        }
        else{
            price = PRICE_LARGE_BBQ;
        }
        Pizza newBBQChicken = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
            /**
             * Concrete method to add a topping to the pizza
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
                switch (NYPizzaController.size) {
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
     * Method to create the customized Build your own pizza object
     * @return the customized pizza object
     */
    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust ("Hand Tossed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppings = new ArrayList<String>();
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = PRICE_SMALL_BYO;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = PRICE_MEDIUM_BYO;
        }
        else{
            price = PRICE_LARGE_BYO;
        }
        Pizza newNYBuildYourOwn = new Pizza(NYPizzaController.listToppingsBuildYourOwn,
                crust, new Size(NYPizzaController.size), price) {
            /**
             * Concrete method to add a topping to the pizza
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
                switch (NYPizzaController.size) {
                    case "Small":
                        price = PRICE_SMALL_BYO + (NYPizzaController.listToppingsBuildYourOwn.size() * PRICE_TOPPING);
                        return price;
                    case "Medium":
                        price = PRICE_MEDIUM_BYO + (NYPizzaController.listToppingsBuildYourOwn.size() * PRICE_TOPPING);
                        return price;
                    case "Large":
                        price = PRICE_LARGE_BYO + (NYPizzaController.listToppingsBuildYourOwn.size() * PRICE_TOPPING);
                        return price;
                    default:
                        return price;
                }
            }
        };
        newNYBuildYourOwn.price();
        return newNYBuildYourOwn;
    }
}