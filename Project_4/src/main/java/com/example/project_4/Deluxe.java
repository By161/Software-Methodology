package com.example.project_4;

import java.util.ArrayList;

public abstract class Deluxe extends Pizza{


    public Deluxe(ArrayList<Topping> toppings, Crust crust, Size size) {
        super(toppings, crust, size);
    }

    @Override
    public abstract double price();
}

