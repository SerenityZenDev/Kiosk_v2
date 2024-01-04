package org.example;

import org.example.Controller.OrderController;
import org.example.Controller.ProductController;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.View.MenuView;
import org.example.View.OrderView;
import org.example.View.ProductView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ArrayList<Product> BurgerArrayList = new ArrayList<>();
        ArrayList<Product> ForzenCustardArrayList = new ArrayList<>();
        ArrayList<Product> DrinkArrayList = new ArrayList<>();
        ArrayList<Product> BeerArrayList = new ArrayList<>();
        ProductController productController = new ProductController(BurgerArrayList, ForzenCustardArrayList,
                DrinkArrayList, BeerArrayList);
        ProductView productView = new ProductView(productController);

        Order order = new Order();
        OrderController orderController = new OrderController(order);
        OrderView orderView = new OrderView(orderController);

        MenuView menuView = new MenuView();

        int waitingNumber = 1;

        while(true){
            MenuView.printMenu();

            int customerFirstInputValue = scan();
            System.out.println(customerFirstInputValue);
            int customerSecondInputValue = 0;

            switch (customerFirstInputValue){
                case 0->{
                    System.out.println("[ 총 판매금액 현황 ]");
                    System.out.println("현재까지 총 판매된 금액은 [ W" + ((double)orderController.totalSalesAmount())/1000 + " ] 입니다.");
                    System.out.println("----------------------------------");
                    System.out.println("[ 총 판매상품 목록 현황]");
                    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.");
                    orderView.printPastOrder();
                    System.out.println("버튼을 눌러 돌아가기");
                    scan();

                }
                case 1-> {
                    productView.printProductList(BurgerArrayList);
                    choose(1, BurgerArrayList, orderController);
                }
                case 2-> {
                    productView.printProductList(ForzenCustardArrayList);
                    choose(2, ForzenCustardArrayList, orderController);
                }
                case 3-> {
                    productView.printProductList(DrinkArrayList);
                    choose(3, DrinkArrayList, orderController);
                }
                case 4-> {
                    productView.printProductList(BeerArrayList);
                    choose(4, BeerArrayList, orderController);
                }
                case 5-> {
                    orderView.printOrder();
                    orderView.printTotalPrice();
                    customerSecondInputValue = scan();
                    orderView.lastOrder(customerSecondInputValue, waitingNumber);
                    waitingNumber++;
                }
                case 6-> {
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인 \t\t 2.취소");
                    customerSecondInputValue = scan();
                    if (customerSecondInputValue == 1){
                        orderController.deleteOrder(false);
                    }
                }
                default -> System.out.println("1~6번 사이 값을 입력해주세요");
            }

        }
    }
    public static int scan(){
        try{
            Scanner sc = new Scanner(System.in);
            int inputscan = Integer.parseInt(sc.nextLine());
            return inputscan;
        }catch (NumberFormatException e){
            return -1;
        }
    }


    public static void choose(int customerFirstInputValue, ArrayList<Product> productArrayList, OrderController orderController){
        int customerSecondInputValue = 0;
        Product product;
        int customerThirdInputValue = 0;
        if (customerFirstInputValue > 0 && customerFirstInputValue <5){

            // 옵션 선택 로직
            customerFirstInputValue = scan();
            System.out.println(
                    productArrayList.get(customerFirstInputValue-1).getName()+ "\t | W " +
                            (double)(productArrayList.get(customerFirstInputValue-1).getPrice())/1000 + " | " +
                            productArrayList.get(customerFirstInputValue-1).getDescription());
            System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
            System.out.println("1. Single(W " +
                    (double)(productArrayList.get(customerFirstInputValue-1).getPrice())/1000
                    + ")        2.Double(W " +
                    (double)(productArrayList.get(customerFirstInputValue-1).getPrice()*18)/10000 + ")");
            customerThirdInputValue = scan();

            System.out.println((int) ((double)(productArrayList.get(customerFirstInputValue-1).getPrice())));

            product = new Product(
                    productArrayList.get(customerFirstInputValue-1).getName()+ "(Double)",
                    productArrayList.get(customerFirstInputValue-1).getDescription(),
                    (int) ((double)(productArrayList.get(customerFirstInputValue-1).getPrice())*1.8)
            );
            System.out.println("내이름"+product.getName());

            switch (customerThirdInputValue){
                case 1 -> {
                    System.out.println(
                            productArrayList.get(customerFirstInputValue-1).getName()+ "\t | W " +
                                    (double)(productArrayList.get(customerFirstInputValue-1).getPrice())/1000.0 + " | " +
                                    productArrayList.get(customerFirstInputValue-1).getDescription());
                }
                case 2->{
                    System.out.println(product.getName() + (double)product.getPrice()/1000 + " | " + product.getDescription());
                }
            }

            // 장바구니 추가 로직

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인 \t\t 2.취소");
            customerSecondInputValue = scan();

            switch (customerSecondInputValue){
                case 1-> {
                    switch (customerThirdInputValue){
                        case 1->{
                            orderController.addOrder(productArrayList.get(customerFirstInputValue-1));
                            System.out.println(productArrayList.get(customerFirstInputValue-1).getName() + "가 장바구니에 추가되었습니다.");
                        }case 2->{
                            orderController.addOrder(product);
                            System.out.println(product.getName() + "가 장바구니에 추가되었습니다.");
                        }
                    }

                }
                case 2-> System.out.println("취소하셨습니다.");
                default -> System.out.println("1또는 2를 입력해주세요");
            }
        }
    }
}

