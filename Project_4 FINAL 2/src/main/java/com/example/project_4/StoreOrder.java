package com.example.project_4;

import java.util.LinkedList;

public class StoreOrder implements Customizable{
    private int currentOrderIndex = 0;
    private LinkedList<Order> allOrders = new LinkedList<>();

    public Order getCurrentOrder() {
        return allOrders.get(currentOrderIndex);
    }

    public Order get(int index) {
        return allOrders.get(index);
    }

    @Override
    public boolean add(Object obj) {
        Order orderToAdd = (Order) obj;
        allOrders.add(orderToAdd);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        int index = (int) obj;
        allOrders.remove(index);
        return true;
    }

    @Override
    public String toString() {
        return allOrders.toString();
    }

    public void updateCurrentOrder() {
        currentOrderIndex++;
        Order newOrder = new Order();
        allOrders.add(newOrder);
    }

    public int getNumOfOrders() {
        return allOrders.size();
    }
}
