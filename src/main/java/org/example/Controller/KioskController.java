package org.example.Controller;

import org.example.Dto.ProductDto;
import org.example.Service.KioskService;
import org.example.View.View;

import java.util.Scanner;

public class KioskController extends KioskService {
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

    // 메뉴 관련 상수
    final static int HIDEMENU = 0;
    final static int HAMBERGER = 1;
    final static int FORZENCUSTARD = 2;
    final static int DRINK = 3;
    final static int BEER = 4;
    final static int ORDER = 5;
    final static int CANCEL = 6;

    // 스캐너 관련 상수
    final static int INVALID_INDEX = -1;
    final static int AGREE = 1;
    final static int REFUSE = 2;


    public void start() throws InterruptedException {
        while (true){
            // 가장 메인 메뉴 출력
            view.printMainMenu();
            // 메인 메뉴 중 선택 0 ~ 6
            mainMenuInputValue = scanOneToSix();
            switch (mainMenuInputValue){
                case HIDEMENU -> {
                    view.hideMenu(kioskService.getAfterOrder());
                    scanOneToSec();
                }
                case HAMBERGER,FORZENCUSTARD,DRINK,BEER -> { // 메뉴 선택
                    // 메뉴 출력
                    printMenu(mainMenuInputValue);

                    // 메뉴 선택
                    menuChoose();

                    // 옵션선택 - 싱글, 더블 (1번 햄버거의 경우에만)
                    if (mainMenuInputValue == HAMBERGER){
                        menuOptionChoose();
                    }

                    // 선택된 상품 출력
                    view.foodMenuChoose(kioskService.getProduct().toString());

                    // 장바구니 추가 여부 확인
                    addBasket();
                }
                case ORDER -> { // 5번 장바구니 선택
                    // 장바구니 옵션
                   basketOption();
                }
                case CANCEL -> { // 6번 취소 선택
                    // 장바구니 취소 옵션
                    basketCancel();
                }
                default -> System.out.println("1~6번 사이 값을 입력해주세요");
            }
        }
    }


    public KioskController() {}

    private static int scanOneToSix(){
        try{
            Scanner sc = new Scanner(System.in);
            int inputscan = Integer.parseInt(sc.nextLine());
            return inputscan;
        }catch (NumberFormatException e){
            return 7;
        }
    }

    private static int scanOneToSec(){
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                int inputscan = Integer.parseInt(sc.nextLine());
                if (inputscan == AGREE || inputscan == REFUSE){
                    return inputscan;
                }else{
                    System.out.println("올바른 값 1 혹은 2를 입력해주세요");
                }
            }catch (NumberFormatException e){
                System.out.println("올바른 값 1 혹은 2를 입력해주세요");
            }
        }
    }

    public void printMenu(int mainMenuInputValue){
        ProductDto productDto = new ProductDto();
        switch (mainMenuInputValue){
            case HAMBERGER->{view.foodMenu(productDto.getSingleBurgerArrayList(), "Burger");}
            case FORZENCUSTARD->{view.foodMenu(productDto.getForzenCustardArrayList(), "ForzenCustard");}
            case DRINK->{view.foodMenu(productDto.getDrinkArrayList(), "Drink");}
            case BEER->{view.foodMenu(productDto.getBeerArrayList(), "Beer");}
        }
    }

    public void menuChoose(){
        subMenuInputValue = scanOneToSec()  + INVALID_INDEX;
        kioskService.selectProduct(mainMenuInputValue, subMenuInputValue);
    }

    public void menuOptionChoose(){
        view.foodMenuOption(kioskService.getProduct());
        menuOptionInputValue = scanOneToSec();
        kioskService.menuOptionDouble(subMenuInputValue, menuOptionInputValue);
    }

    public void addBasket(){
        addBasketInputValue = scanOneToSec();
        if (addBasketInputValue == AGREE){
            view.foodMenuChooseCorrect(kioskService.getProduct());
            kioskService.addBasket();
        }
    }

    public void basketOption() throws InterruptedException {
        view.orderMenu(kioskService.getOrder());
        subMenuInputValue = scanOneToSec();
        if (subMenuInputValue == AGREE){
            kioskService.moveAfterOrder();
            kioskService.orderListInit();
            view.orderMenuChoose(kioskService.getOrder());
            Thread.sleep(3000);
            kioskService.plusWaitingNumber();
        }
    }

    public void basketCancel(){
        view.cancelMenu();
        subMenuInputValue = scanOneToSec();
        if (subMenuInputValue == AGREE){
            kioskService.deleteOrder();
        }
    }
}
