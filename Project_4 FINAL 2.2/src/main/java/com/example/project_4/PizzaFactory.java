package com.example.project_4;

/**
 * Required interface for the pizza subclasses to inherit
 * @author Brandon Yuen, Anna Kryzanekas
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
