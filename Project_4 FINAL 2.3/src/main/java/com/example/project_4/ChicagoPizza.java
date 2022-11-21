package com.example.project_4;

import java.util.ArrayList;
import java.util.Arrays;

public class ChicagoPizza implements PizzaFactory {
    @Override
    public Pizza createDeluxe() {
        Crust crust = new Crust ("Deep Dish");
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
        Pizza newChicagoDeluxe = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
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
        return newChicagoDeluxe;
    }

    @Override
    public Pizza createMeatzza() {
        Crust crust = new Crust ("Stuffed");
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
        Pizza newChicagoMeatzza = new Pizza(listToppingsDeluxe, crust, new Size(NYPizzaController.size), price) {
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
        return newChicagoMeatzza;
    }

    @Override
    public Pizza createBBQChicken() {
        Crust crust = new Crust ("Pan");
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
        Crust crust = new Crust ("Pan");
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
        Pizza newChicagoBuildYourOwn = new Pizza(listToppings, crust, new Size(NYPizzaController.size), price) {
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
