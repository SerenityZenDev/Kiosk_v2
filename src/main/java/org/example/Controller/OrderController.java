package org.example.Controller;

import org.example.Dto.ProductDto;
import org.example.Model.Order;
import org.example.Model.Product;
import org.example.View.View;

import java.util.Scanner;

public class OrderController {
    private ProductDto productDto = new ProductDto();
    private Product product = new Product();
    private Order order = new Order();
    private Order afterOrder = new Order();
    private View view = new View();

    // 첫번째 선택 : 첫 메인 메뉴에서 선택지 확인 / (1~4) : 음식 | 5 : 주문 | 6 : 취소
    int mainMenuInputValue = 0;
    // 두번째 선택 : 음식, 주문, 취소 안에서 / 음식의 경우 음식 종류 | 주문의 경우 주문여부 | 취소의 경우 취소여부
    int subMenuInputValue = 0;
    // 세번째 선택 : 음식 세부사항 (옵션 - 싱글, 더블 사이즈)
    int menuOptionInputValue = 0;
    // 4번째 선택 : 장바구니 추가 여부 확인
    int addBasket = 0;


    public void start() throws InterruptedException {
        while (true){
            // 가장 메인 메뉴 출력
            view.printMainMenu();
            // 메인 메뉴 중 선택 0 ~ 6
            mainMenuInputValue = scan();
            switch (mainMenuInputValue){
                case 0 -> {
                    view.hideMenu(afterOrder.getTotalSalePrice(), afterOrder.orderListName());
                    scan();
                }
                case 1 -> { // 1번 햄버거 선택
                    // 햄버거 메뉴 출력
                    String menuText = product.productText(productDto.getSingleBurgerArrayList());

                    // 햄버거 선택
                    view.foodMenu(menuText, "Burger");
                    subMenuInputValue = scan() -1;
                    product = productDto.getSingleBurgerArrayList().get(subMenuInputValue);
                    String typeMenu = product.toString();

                    // 옵션선택 - 싱글, 더블
                    view.foodMenuOption(typeMenu, product.getPrice());
                    menuOptionInputValue = scan();
                    if (menuOptionInputValue == 2){ // 더블일 경우 상품 더블로 변경
                        product = productDto.getDoubleBurgerArrayList().get(subMenuInputValue);
                        typeMenu = product.toString();
                    }

                    // 선택된 상품 출력
                    view.foodMenuChoose(typeMenu);

                    // 장바구니 추가 여부 확인
                    addBasket = scan();
                    if (addBasket == 1){
                        view.foodMenuChooseCorrect(product.getName());
                        order.addOrder(product);
                    }
                }
                case 2 -> {
                    // 냉동과자 메뉴 출력
                    String menuText = product.productText(productDto.getForzenCustardArrayList());

                    // 냉동과자 선택
                    view.foodMenu(menuText, "ForzenCustard");
                    subMenuInputValue = scan() -1;
                    product = productDto.getForzenCustardArrayList().get(subMenuInputValue);
                    String typeMenu = product.toString();

                    // 선택된 상품 출력
                    view.foodMenuChoose(typeMenu);

                    // 장바구니 옵션
                    addBasket = scan();
                    if (addBasket == 1){
                        view.foodMenuChooseCorrect(product.getName());
                        order.addOrder(product);
                    }
                }
                case 3 -> {
                    // 음료 메뉴 출력
                    String menuText = product.productText(productDto.getDrinkArrayList());

                    // 음료 선택
                    view.foodMenu(menuText, "Drink");
                    subMenuInputValue = scan() -1;
                    product = productDto.getDrinkArrayList().get(subMenuInputValue);
                    String typeMenu = product.toString();

                    // 선택된 상품 출력
                    view.foodMenuChoose(typeMenu);

                    // 장바구니 옵션
                    addBasket = scan();
                    if (addBasket == 1){
                        view.foodMenuChooseCorrect(product.getName());
                        order.addOrder(product);
                    }
                }
                case 4 -> {
                    // 맥주 메뉴 출력
                    String menuText = product.productText(productDto.getBeerArrayList());

                    // 맥주 선택
                    view.foodMenu(menuText, "Beer");
                    subMenuInputValue = scan() -1;
                    product = productDto.getBeerArrayList().get(subMenuInputValue);
                    String typeMenu = product.toString();

                    // 선택된 상품 출력
                    view.foodMenuChoose(typeMenu);

                    // 장바구니 옵션
                    addBasket = scan();
                    if (addBasket == 1){
                        view.foodMenuChooseCorrect(product.getName());
                        order.addOrder(product);
                    }
                }
                case 5 -> {
                    // 장바구니 옵션
                    view.orderMenu(order.toString(), order.orderPrice());
                    subMenuInputValue = scan();
                    if (subMenuInputValue == 1){
                        for (Product afterProduct : order.getOrderList()){
                            afterOrder.addOrder(new Product(afterProduct));
                        }
                        afterOrder.addTotalSaleAmount(order.orderPrice());
                        order.orderListQuantityZero();
                        order.deleteOrder();
                        System.out.println(order);
                        view.orderMenuChoose(order.getWaitingNumber());
                        Thread.sleep(3000);
                        order.plusWaitingNumber();
                    }
                }
                case 6 -> {
                    // 장바구니 취소 옵션
                    view.cancelMenu();
                    subMenuInputValue = scan();
                    if (subMenuInputValue == 1){
                        order.deleteOrder();
                    }

                }
                default -> System.out.println("1~6번 사이 값을 입력해주세요");
            }
        }
    }


    public OrderController() {}

    public static int scan(){
        try{
            Scanner sc = new Scanner(System.in);
            int inputscan = Integer.parseInt(sc.nextLine());
            return inputscan;
        }catch (NumberFormatException e){
            return 7;
        }
    }
}
