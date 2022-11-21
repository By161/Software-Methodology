package com.example.project_4;

import java.util.ArrayList;
import java.util.Arrays;

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Deep Dish");
        ArrayList<Topping> toppings = new ArrayList<>();
        Size size = new Size("Small");
        ArrayList<String> listToppingsDeluxe = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "green pepper", "onion", "mushroom"));
        double price = 0;
        Pizza newChicagoDeluxe = new Pizza(listToppingsDeluxe, crust, size, price) {
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
        return newChicagoDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust("Stuffed");
        Size size = new Size ("Small");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsMeatzza = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        double price = 0;
        Pizza newChicagoMeatzza = new Pizza(listToppingsMeatzza, crust, size, price) {
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
        return newChicagoMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust("Pan");
        Size size = new Size("Large");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsBBQChicken = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        double price = 0;
        Pizza newChicagoBBQChicken = new Pizza(listToppingsBBQChicken, crust, size, price) {
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
        return newChicagoBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust("Pan");
        Size size = new Size("Large");
        ArrayList<String> toppings = new ArrayList<>();
        double price = 0;
        Pizza newChicagoBuildYourOwn = new Pizza(toppings, crust, size, price) {
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
        return newChicagoBuildYourOwn;
    }
    public String printToppings(ArrayList<String> toppingsToPrint){
        String printToppings = "";
        for (int i = 0; i < toppingsToPrint.size(); i++){
            printToppings += toppingsToPrint.get(i) + ", ";
        }
        return printToppings;
    }
}
