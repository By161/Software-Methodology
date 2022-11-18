package com.example.project_4;

import java.util.ArrayList;

public class Order implements Customizable{
    private ArrayList<Pizza> orderList;

    public Order(ArrayList<Pizza> myPizzas){
        this.orderList = myPizzas;
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
//    public Object toString(Order order) {
//        String information = " ";
//        for (int i = 0; i < orderList.size(); i++){
//            Pizza myPizza = orderList.get(i);
//            information += (myPizza.getToppings + myPizza.getCrust() + myPizza.getPrice());
//        }
//        return information.trim();
//    }
}
