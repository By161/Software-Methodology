package com.example.project_4;

import java.util.LinkedList;

/**
 * Required class to make a Store Order object
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class StoreOrder implements Customizable{
    private int currentOrderIndex = 0;
    private LinkedList<Order> allOrders = new LinkedList<>();

    /**
     *
     * @return
     */
    public Order getCurrentOrder() {
        return allOrders.get(currentOrderIndex);
    }

    /**
     *
     * @param index
     * @return
     */
    public Order get(int index) {
        return allOrders.get(index);
    }

    /**
     *
     * @param obj the specified attribute that is to be added to the object
     * @return
     */
    @Override
    public boolean add(Object obj) {
        Order orderToAdd = (Order) obj;
        allOrders.add(orderToAdd);
        return true;
    }

    /**
     *
     * @param obj the specified attribute that is to be removed from the object
     * @return
     */
    @Override
    public boolean remove(Object obj) {
        int index = (int) obj;
        currentOrderIndex--;
        allOrders.remove(index);
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return allOrders.toString();
    }

    /**
     *
     */
    public void updateCurrentOrder() {
        currentOrderIndex++;
        Order newOrder = new Order();
        allOrders.add(newOrder);
    }

    /**
     *
     * @return
     */
    public int getNumOfOrders() {
        return allOrders.size();
    }
}
