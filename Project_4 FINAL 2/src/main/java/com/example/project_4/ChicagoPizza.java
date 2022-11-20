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
        Pizza newChicagoDeluxe = new Pizza(listToppingsDeluxe, crust, size) {
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
        return newChicagoDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust("Stuffed");
        Size size = new Size ("Small");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsMeatzza = new ArrayList<String>(Arrays.asList("Sausage", "pepperoni",
                "beef", "ham"));
        Pizza newChicagoMeatzza = new Pizza(listToppingsMeatzza, crust, size) {
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
        return newChicagoMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust("Pan");
        Size size = new Size("Large");
        ArrayList<Topping> toppings = new ArrayList<>();
        ArrayList<String> listToppingsBBQChicken = new ArrayList<String>(Arrays.asList("BBQ Chicken", "green pepper",
                "provolone", "cheddar"));
        Pizza newChicagoBBQChicken = new Pizza(listToppingsBBQChicken, crust, size) {
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
        return newChicagoBBQChicken;
    }

    @Override
    public Pizza createBuildYourOwn() {
        Crust crust = new Crust("Pan");
        Size size = new Size("Large");
        ArrayList<String> toppings = new ArrayList<>();
        Pizza newChicagoBuildYourOwn = new Pizza(toppings, crust, size) {
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
