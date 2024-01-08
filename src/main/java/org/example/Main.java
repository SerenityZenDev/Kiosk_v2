package org.example;

import org.example.Controller.OrderController;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        OrderController orderController = new OrderController();
        orderController.start();
    }
}

