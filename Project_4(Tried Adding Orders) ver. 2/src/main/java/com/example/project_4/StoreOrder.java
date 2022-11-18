package com.example.project_4;
import java.util.ArrayList;

/**
 *
 * @author Brandon Yuen, Anna Kryzanekas
 */
public class StoreOrder implements Customizable{
ArrayList<Order> orderList = new ArrayList<Order>();
    public StoreOrder(ArrayList<Order> orders){
        this.orderList = orders;
    }

    @Override
    public boolean add(Object obj) {
        orderList.add((Order) obj);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        if (orderList.contains((Order)obj)){
            orderList.remove((Order) obj);
            return true;
        }
        return false;
    }
}
