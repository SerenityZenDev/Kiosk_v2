package org.example.Model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> OrderList;

    public Order() {
        this.OrderList = new ArrayList<>();
    }

    public ArrayList<Product> getOrderList() {
        return OrderList;
    }
}
