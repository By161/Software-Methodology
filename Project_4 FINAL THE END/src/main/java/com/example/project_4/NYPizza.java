package com.example.project_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.Arrays;
//fix build your own
/**
 * Required Class to make a NYPizza object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class NYPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Brooklyn");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = 14.99;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = 16.99;
        }
        else{
            price = 18.99;
        }
        Pizza newNYDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
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
                switch (NYPizzaController.size) {
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
        return newNYDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust ("Hand Tossed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = 15.99;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = 17.99;
        }
        else{
            price = 19.99;
        }
        Pizza newNYMeatzza = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
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
                switch (NYPizzaController.size) {
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
        return newNYMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust ("Thin");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = 13.99;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = 15.99;
        }
        else{
            price = 17.99;
        }
        Pizza newBBQChicken = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
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
                switch (NYPizzaController.size) {
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

    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust ("Hand Tossed");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppings = new ArrayList<String>();
        double price;
        if(NYPizzaController.size.equals("Small")){
            price = 8.99;
        }
        else if(NYPizzaController.size.equals("Medium")){
            price = 10.99;
        }
        else{
            price = 12.99;
        }
        Pizza newNYBuildYourOwn = new Pizza(NYPizzaController.listToppingsBuildYourOwn,
                crust, new Size(NYPizzaController.size), price) {
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
                switch (NYPizzaController.size) {
                    case "Small":
                        price = 8.99 + (NYPizzaController.listToppingsBuildYourOwn.size()*1.59);
                        return price;
                    case "Medium":
                        price = 10.99 + (NYPizzaController.listToppingsBuildYourOwn.size()*1.59);
                        return price;
                    case "Large":
                        price = 12.99 + (NYPizzaController.listToppingsBuildYourOwn.size()*1.59);
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
