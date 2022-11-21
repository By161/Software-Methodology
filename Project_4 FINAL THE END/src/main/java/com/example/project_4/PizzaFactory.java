package com.example.project_4;

/**
 * Required interface for the pizza subclasses to inherit
 * @author Brandon Yuen, Anna Kryzanekas
 */
public interface PizzaFactory {

    /**
     * Method that creates a Deluxe pizza
     * @return a Deluxe pizza object
     */
    Pizza createDeluxe();

    /**
     * Method that creates a Meatzza pizza
     * @return a Meatzza pizza object
     */
    Pizza createMeatzza();

    /**
     * Method that creates a BBQ Chicken pizza
     * @return a BBQ Chicken pizza object
     */
    Pizza createBBQChicken();

    /**
     * Method that creates a Build Your Own pizza
     * @return a Build Your Own pizza object
     */
    Pizza createBuildYourOwn();
}
