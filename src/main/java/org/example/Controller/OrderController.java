package org.example.Controller;

import org.example.Model.Order;
import org.example.Model.Product;

public class OrderController {
    private Order order;
    private Order afterOrder = new Order();
    private int totalSalePrice;

    public OrderController(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public Order getAfterOrder() {
        return afterOrder;
    }

    public void addOrder(Product product){
        if (order.getOrderList().contains(product)){
            int index = order.getOrderList().indexOf(product);
            order.getOrderList().get(index).setQuantity(product.getQuantity()+1);
        }else{
            order.getOrderList().add(product);
        }
    }

    // 주문 삭제
    public void deleteOrder(boolean lastOrder){
        if (lastOrder){
            for (Product pastOrder : order.getOrderList()){
                afterOrder.getOrderList().add(pastOrder);
            }
        }
        order.getOrderList().clear();
    }

    public int totalPrice(){
        int sum = 0;
        for (Product product : order.getOrderList()){
            if (product.getQuantity() > 1){
                sum += product.getPrice() * product.getQuantity();
            }
            sum += product.getPrice();
        }
        return sum;
    }

    public void addTotalSalesAmount(int sales){
        totalSalePrice += sales;
    }

    public int totalSalesAmount(){
        return totalSalePrice;
    }
}
