package com.example.project_4;

import org.junit.Test;

import java.util.ArrayList;

import static org.testng.AssertJUnit.assertEquals;

public class BuildYourOwnTest {

    @Test
    public void price6toppingsLarge() {
        //create a large pizza with 6 toppings and check if the price is correct
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add ("Sausage");
        toppings.add ("green pepper");
        toppings.add ("onion");
        toppings.add ("mushroom");
        toppings.add ("BBQ Chicken");
        toppings.add ("beef");
        BuildYourOwn pizza1 = new BuildYourOwn(toppings, new Crust("Hand tossed"), new Size("Large"), 0);
        boolean actualOutput = assertPriceLarge6toppings(pizza1.price());
        boolean expectedOutput = true;
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void price2toppingsLarge(){
        //create a large pizza with 2 toppings and check if the price is correct
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add ("Sausage");
        toppings.add ("green pepper");
        BuildYourOwn pizza2 = new BuildYourOwn(toppings, new Crust("Hand tossed"), new Size("Large"), 0);
        boolean actualOutput = assertPriceLarge2toppings(pizza2.price());
        boolean expectedOutput = true;
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void price4toppingsMedium(){
        //create a medium pizza with 4 toppings and check if the price is correct
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add ("Sausage");
        toppings.add ("green pepper");
        toppings.add("mushroom");
        toppings.add("onion");
        BuildYourOwn pizza3 = new BuildYourOwn(toppings, new Crust("Hand tossed"), new Size("Medium"), 0);
        boolean actualOutput = assertPriceMedium4toppings(pizza3.price());
        boolean expectedOutput = true;
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void price5toppingsMedium(){
        //create a medium pizza with 5 toppings and check if the price is correct
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add ("Sausage");
        toppings.add ("green pepper");
        toppings.add("mushroom");
        toppings.add("onion");
        toppings.add("beef");
        BuildYourOwn pizza4 = new BuildYourOwn(toppings, new Crust("Hand tossed"), new Size("Medium"), 0);
        boolean actualOutput = assertPriceMedium5toppings(pizza4.price());
        boolean expectedOutput = true;
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    public void price5toppingsSmall(){
        //create a small pizza with 5 toppings and check if the price is correct
        ArrayList<String> toppings = new ArrayList<>();
        toppings.add ("Sausage");
        toppings.add ("green pepper");
        toppings.add("mushroom");
        toppings.add("onion");
        toppings.add("beef");
        BuildYourOwn pizza5 = new BuildYourOwn(toppings, new Crust("Hand tossed"), new Size("Small"), 0);
        boolean actualOutput = assertPriceSmall5toppings(pizza5.price());
        boolean expectedOutput = true;
        assertEquals(expectedOutput,actualOutput);
    }

    //method to assert if price is true for specified case
    private boolean assertPriceLarge6toppings(double price) {
        if (price == 22.53){
            return true;
        }
        return false;
    }

    //method to assert if price is true for specified case
    private boolean assertPriceLarge2toppings(double price){
        if(price == 16.17){
            return true;
        }
        return false;
    }

    //method to assert if price is true for specified case
    private boolean assertPriceMedium4toppings(double price){
        if (price == 17.35){
            return true;
        }
        else{
            return false;
        }
    }

    //method to assert if price is true for specified case
    private boolean assertPriceMedium5toppings(double price){
        if (price == 18.94){
            return true;
        }
        else{
            return false;
        }
    }

    //method to assert if price is true for specified case
    private boolean assertPriceSmall5toppings(double price){
        if (price == 16.94){
            return true;
        }
        else{
            return false;
        }
    }

}