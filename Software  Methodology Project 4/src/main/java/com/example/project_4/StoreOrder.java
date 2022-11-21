package com.example.project_4;

import java.util.LinkedList;

/**
 * Required class for the store order to keep track of all the orders placed in the pizzeria
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class StoreOrder implements Customizable{
    private int currentOrderIndex = 0;
    private LinkedList<Order> allOrders = new LinkedList<>();

    /**
     * Getter method for the current order
     * @return the current order
     */
    public Order getCurrentOrder() {
        return allOrders.get(currentOrderIndex);
    }

    /**
     * Getter method for a certain order
     * @param index the location of the desired order
     * @return the desired order
     */
    public Order get(int index) {
        return allOrders.get(index);
    }

    /**
     * Concrete method to add an order
     * @param obj the attribute to be added to an object
     * @return true if added, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        Order orderToAdd = (Order) obj;
        allOrders.add(orderToAdd);
        return true;
    }

    /**
     * Concrete method to remove an order
     * @param obj the attribute to be removed from an object
     * @return true if removed, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        int index = (int) obj;
        currentOrderIndex--;
        allOrders.remove(index);
        return true;
    }

    /**
     * toString method to better represent the information of the store orders
     * @return String to represent the store orders
     */
    @Override
    public String toString() {
        return allOrders.toString();
    }

    /**
     * Helper method to start a new order
     */
    public void updateCurrentOrder() {
        currentOrderIndex++;
        Order newOrder = new Order();
        allOrders.add(newOrder);
    }

    /**
     * Getter method for the number of orders the store has
     * @return the number of orders the store has
     */
    public int getNumOfOrders() {
        return allOrders.size();
    }
}
