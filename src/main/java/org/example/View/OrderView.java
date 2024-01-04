package org.example.View;

import org.example.Controller.OrderController;
import org.example.Model.Product;

public class OrderView {
    private OrderController orderController;

    public OrderView(OrderController orderController) {
        this.orderController = orderController;
    }

    public void printTotalPrice(){
        double price = (double)orderController.totalPrice()/1000;

        System.out.println("[ Total ]");
        System.out.println("W " + price);
        System.out.println();
        System.out.println("1. 주문 \t 2. 메뉴판");
    }

    public int printPrice(){
        return orderController.totalPrice();
    }

    public void printOrder() {
        int number = 1;
        double price = 0;
        // 주문 목록은 OrderController의 getOrderList 메소드를 통해 가져옵니다.
        for (Product product : orderController.getOrder().getOrderList()) {
            price = (double)(product.getPrice()* product.getQuantity())/1000;
            System.out.println(number++ + ". " + product.getName() + "\t| W " + price + " | " + product.getQuantity() + "개\t| " + product.getDescription());
        }
    }

    public void lastOrder(int input, int waiting) throws InterruptedException {
        if (input == 1){
            System.out.println("주문이 완료되었습니다!");
            System.out.println("대기번호는 [ " + waiting++ + " ] 번 입니다.");
            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
            Thread.sleep(3000);
            orderController.addTotalSalesAmount(printPrice());
            orderController.deleteOrder(true);
        }
    }

    public void printPastOrder(){
        for (Product product : orderController.getAfterOrder().getOrderList()){
            System.out.println("- " + product.getName() + "\t | W " + product.getPrice());
        }
    }
}
