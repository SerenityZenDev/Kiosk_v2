package org.example.Controller;

import org.example.Model.Order;
import org.example.Model.Product;

public class OrderController {
    private Order order;

    public OrderController(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void addOrder(Product product){
        order.getOrderList().add(product);
    }

    public void deleteOrder(){
        order.getOrderList().clear();
    }

    public int totalPrice(){
        int sum = 0;
        for (Product product : order.getOrderList()){
            sum += product.getPrice();
        }

        return sum;
    }
}
