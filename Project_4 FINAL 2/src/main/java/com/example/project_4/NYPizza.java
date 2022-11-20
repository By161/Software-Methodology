package com.example.project_4;

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
        Size size = new Size("Small");
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        Pizza newNYDeluxe = new Pizza(listToppingsDeluxe, crust, size) {
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
                switch (size.getSize()) {
                    case "Small":
                        return 14.99;
                    case "Medium":
                        return 16.99;
                    case "Large":
                        return 17.99;
                    default:
                        return 1;
                }
            }
        };
        return newNYDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust("Hand tossed");
        Size size = new Size ("Small");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsMeatzza = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        Pizza newNYMeatzza = new Pizza(listToppingsMeatzza, crust, size) {
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
        Crust crust = new Crust("Thin");
        Size size = new Size("Large");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsBBQChicken = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        Pizza newNYBBQChicken = new Pizza(listToppingsBBQChicken, crust, size) {
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
        return newNYBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust("Hand tossed");
        Size size = new Size("Large");
        ArrayList<String> toppings = new ArrayList<>();
        Pizza newNYBuildYourOwn = new Pizza(toppings, crust, size) {
            @Override
            public boolean add(Object obj) {
                if (toppings.size() < 7){
                    toppings.add(obj.toString());
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
        return newNYBuildYourOwn;
    }
    public String printToppings(ArrayList<String> toppingsToPrint){
        String printToppings = "";
        for (int i = 0; i < toppingsToPrint.size(); i++){
            printToppings += toppingsToPrint.get(i) + ", ";
        }
        return printToppings;
    }
}
