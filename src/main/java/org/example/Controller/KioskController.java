package org.example.Controller;

import org.example.Dto.ProductDto;
import org.example.Service.KioskService;
import org.example.View.View;

import java.util.Scanner;

public class KioskController {
    private final View view = new View();

    private final KioskService kioskService = new KioskService();

    // 첫번째 선택 : 첫 메인 메뉴에서 선택지 확인 / (1~4) : 음식 | 5 : 주문 | 6 : 취소
    private int mainMenuInputValue = 0;
    // 두번째 선택 : 음식, 주문, 취소 안에서 / 음식의 경우 음식 종류 | 주문의 경우 주문여부 | 취소의 경우 취소여부
    private int subMenuInputValue = 0;
    // 세번째 선택 : 음식 세부사항 (옵션 - 싱글, 더블 사이즈)
    private int menuOptionInputValue = 0;
    // 4번째 선택 : 장바구니 추가 여부 확인
    private int addBasketInputValue = 0;


    public void start() throws InterruptedException {
        while (true){
            // 가장 메인 메뉴 출력
            view.printMainMenu();
            // 메인 메뉴 중 선택 0 ~ 6
            mainMenuInputValue = scan();
            switch (mainMenuInputValue){
                case 0 -> {
                    view.hideMenu(kioskService.getAfterOrder());
                    scan();
                }
                case 1,2,3,4 -> { // 메뉴 선택
                    // 메뉴 출력
                    printMenu(mainMenuInputValue);

                    // 메뉴 선택
                    menuChoose();

                    // 옵션선택 - 싱글, 더블 (1번 햄버거의 경우에만)
                    if (mainMenuInputValue == 1){
                        menuOptionChoose();
                    }

                    // 선택된 상품 출력
                    view.foodMenuChoose(kioskService.getProduct().toString());

                    // 장바구니 추가 여부 확인
                    addBasket();
                }
                case 5 -> { // 5번 장바구니 선택
                    // 장바구니 옵션
                   basketOption();
                }
                case 6 -> { // 6번 취소 선택
                    // 장바구니 취소 옵션
                    basketCancel();
                }
                default -> System.out.println("1~6번 사이 값을 입력해주세요");
            }
        }
    }


    public KioskController() {}

    private static int scan(){
        try{
            Scanner sc = new Scanner(System.in);
            int inputscan = Integer.parseInt(sc.nextLine());
            return inputscan;
        }catch (NumberFormatException e){
            return 7;
        }
    }

    public void printMenu(int mainMenuInputValue){
        ProductDto productDto = new ProductDto();
        switch (mainMenuInputValue){
            case 1->{view.foodMenu(productDto.getSingleBurgerArrayList(), "Burger");}
            case 2->{view.foodMenu(productDto.getForzenCustardArrayList(), "ForzenCustard");}
            case 3->{view.foodMenu(productDto.getDrinkArrayList(), "Drink");}
            case 4->{view.foodMenu(productDto.getBeerArrayList(), "Beer");}
        }
    }

    public void menuChoose(){
        subMenuInputValue = scan() -1;
        kioskService.selectProduct(mainMenuInputValue, subMenuInputValue);
    }

    public void menuOptionChoose(){
        view.foodMenuOption(kioskService.getProduct());
        menuOptionInputValue = scan();
        kioskService.menuOptionDouble(subMenuInputValue, menuOptionInputValue);
    }

    public void addBasket(){
        addBasketInputValue = scan();
        if (addBasketInputValue == 1){
            view.foodMenuChooseCorrect(kioskService.getProduct());
            kioskService.addBasket();
        }
    }

    public void basketOption() throws InterruptedException {
        view.orderMenu(kioskService.getOrder());
        subMenuInputValue = scan();
        if (subMenuInputValue == 1){
            kioskService.moveAfterOrder();
            kioskService.orderListInit();
            view.orderMenuChoose(kioskService.getOrder());
            Thread.sleep(3000);
            kioskService.plusWaitingNumber();
        }
    }

    public void basketCancel(){
        view.cancelMenu();
        subMenuInputValue = scan();
        if (subMenuInputValue == 1){
            kioskService.deleteOrder();
        }
    }
}
