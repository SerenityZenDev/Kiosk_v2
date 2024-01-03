package org.example;

import org.example.Controller.OrderController;
import org.example.Controller.ProductController;
import org.example.Model.Menu;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.View.MenuView;
import org.example.View.OrderView;
import org.example.View.ProductView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Product> productArrayList = new ArrayList<>();
        ProductController productController = new ProductController(productArrayList);
        ProductView productView = new ProductView(productController);

        Order order = new Order();
        OrderController orderController = new OrderController(order);
        OrderView orderView = new OrderView(orderController);

        MenuView menuView = new MenuView();

        int waitingNumber = 1;

        while(true){
            MenuView.printMenu();

            int input = scan();
            int input2 = 0;
            switch (input){
                case 1-> productView.printBurger();
                case 2-> System.out.println("추후 개발");
                case 3-> System.out.println("추후 개발");
                case 4-> System.out.println("추후 개발");
                case 5-> {
                    orderView.printOrder();
                    orderView.printTotalPrice();
                    input2 = scan();
                    orderView.lastOrder(input2, waitingNumber);
                }
                case 6-> {
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    input2 = scan();
                    if (input2 == 1){
                        orderController.deleteOrder();
                    }
                }
                default -> System.out.println("1~6번 사이 값을 입력해주세요");
            }
            if (input > 0 && input <5){
                input = scan();
                System.out.println(
                        productArrayList.get(input-1).getName()+ "\t | W " +
                                (double)(productArrayList.get(input-1).getPrice()/1000) + " | " +
                                productArrayList.get(input-1).getDescription());
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인 \t\t 2.취소");
                input2 = scan();
                switch (input2){
                    case 1-> {
                        orderController.addOrder(productArrayList.get(input-1));
                        System.out.println(productArrayList.get(input-1).getName() + "가 장바구니에 추가되었습니다.");
                    }
                    case 2-> System.out.println("취소하셨습니다.");
                    default -> System.out.println("1또는 2를 입력해주세요");
                }
            }
        }
    }
    public static int scan(){
        try{
            Scanner sc = new Scanner(System.in);
            int inputscan = Integer.parseInt(sc.nextLine());
            return inputscan;
        }catch (NumberFormatException e){
            return 0;
        }
    }




}

