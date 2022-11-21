package com.example.project_4;

/**
 * Required interface for the pizza subclasses to inherit
 * @author Brandon Yuen, Anna Kryzanekas
 */
public interface PizzaFactory {
    /**
     * Creates a deluxe pizza
     * @return a deluxe pizza
     */
    Pizza createDeluxe();

    /**
     * Creates a Meatzza pizza
     * @return a Meatzza Pizza
     */
    Pizza createMeatzza();

    /**
     * Creates a BBQChicken pizza
     * @return a BBQChicken pizza
     */
    Pizza createBBQChicken();

    /**
     * Creates a BuildYourOwn pizza
     * @return a customized pizza
     */
    Pizza createBuildYourOwn();
}
