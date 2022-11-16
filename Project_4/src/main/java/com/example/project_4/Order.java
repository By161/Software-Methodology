package com.example.project_4;

import java.util.ArrayList;

public class Order implements Customizable{
    ArrayList<Pizza> orderList;
    public static int orderNumber;

    public Order(int orderNumber, ArrayList<Pizza> myOrder){
        this.orderNumber = orderNumber;
        this.orderList = myOrder;
    }
    @Override
    public boolean add(Object obj) {
        orderList.add((Pizza) obj);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        orderList.remove((Pizza) obj);
        return false;
    }
}
