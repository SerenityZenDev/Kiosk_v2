package org.example.Model;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> orderList;
    private double totalSalePrice;
    private int waitingNumber;

    public Order() {
        this.orderList = new ArrayList<>();
        totalSalePrice = 0.0;
        waitingNumber = 1;
    }
    public ArrayList<Product> getOrderList() {
        return orderList;
    }
    public void addOrder(Product product){
        if (!orderList.contains(product)){
            orderList.add(product);
        }
        int index = orderList.indexOf(product);
        orderList.get(index).quantityPlus();
    }
    public double orderPrice(){
        double price = 0.0;
        for (Product product : orderList){
            price += product.getPrice() * product.getQuantity();
        }
        return price/1000;
    }
    public void addTotalSaleAmount(double sale){
        totalSalePrice += sale;
    }

    public void deleteOrder(){
        orderList.clear();
    }

    public double getTotalSalePrice() {
        return totalSalePrice;
    }

    public int getWaitingNumber() {
        return waitingNumber;
    }

    public void plusWaitingNumber(){
        waitingNumber++;
    }

    @Override
    public String toString() {
        String orderString = "";
        for (Product product : orderList){
            orderString += product.getName() +"   | W "+(double)product.getPrice()/1000+" | "+
                    product.getQuantity()+"개 | " + product.getDescription() + "\n";
        }
        return orderString;
    }

    public String orderListName(){
        String name = "";
        for (Product product : orderList){
            name += product.getName() + "\n";
        }
        return name;
    }

    public void orderListQuantityZero(){
        for (Product product : orderList){
            product.quantityZero();
        }
    }
}
