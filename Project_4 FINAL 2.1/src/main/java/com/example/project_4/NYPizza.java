package com.example.project_4;

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
//        Size size =
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price;
        if(size.equals("Small")){
            price = 14.99;
        }
        else if(size.equals("Medium")){
            price = 16.99;
        }
        else{
            price = 18.99;
        }
        Pizza newNYDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(size), price) {
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
                switch (size) {
                    case "Small":
                        price = 14.99;
                        return price;
                    case "Medium":
                        price = 16.99;
                        return price;
                    case "Large":
                        price = 17.99;
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
        Crust crust = new Crust("Hand tossed");
        Size size = new Size ("Small");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsMeatzza = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price = createMeatzza().price();
        Pizza newNYMeatzza = new Pizza(listToppingsMeatzza, crust, size, price) {
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
        Crust crust = new Crust("Thin");
        Size size = new Size("Large");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsBBQChicken = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price = createBBQChicken().price();
        Pizza newNYBBQChicken = new Pizza(listToppingsBBQChicken, crust, size, price) {
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
        return newNYBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust("Hand tossed");
        Size size = new Size("Large");
        ArrayList<String> toppings = new ArrayList<>();
        double price = createBuildYourOwn().price();
        Pizza newNYBuildYourOwn = new Pizza(toppings, crust, size, price) {
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
                        price = 8.99;
                        return price;
                    case "Medium":
                        price = 10.99;
                        return price;
                    case "Large":
                        price = 12.99;
                        return price;
                    default:
                        return price;
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
