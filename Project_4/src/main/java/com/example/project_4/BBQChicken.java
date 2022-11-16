package com.example.project_4;

import java.util.ArrayList;

/**
 * @author Brandon Yuen, Anna Kryzanekas
 */
public abstract class BBQChicken extends Pizza{

    public BBQChicken(ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    @Override
    public abstract double price();
}
