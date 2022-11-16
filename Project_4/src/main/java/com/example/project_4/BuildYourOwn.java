package com.example.project_4;

import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public abstract class BuildYourOwn extends Pizza{

    public BuildYourOwn(ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    public abstract double price();
}
