package org.example.View;

public class View {
    public void printMainMenu(){
        // 메뉴판 출력
        System.out.println(
                "SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                        "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n\n" +
                        "[ SHAKESHACK MENU ] \n" +
                        "1. Burgers         | 앵거스 비프 통살을 다져만든 버거 \n" +
                        "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림 \n" +
                        "3. Drinks          | 매장에서 직접 만드는 음료 \n" +
                        "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n\n" +
                        "[ ORDER MENU ] \n" +
                        "5. Order       | 장바구니를 확인 후 주문합니다. \n" +
                        "6. Cancel      | 진행중인 주문을 취소합니다.)\n");
    }
    // MainMenu 1~4번
    public void foodMenu(String menu, String menuType){
        System.out.println(
                "SHAKESHACK BURGER 에 오신걸 환영합니다.\n" +
                        "아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.\n\n" +
                        "[ "+menuType+" MENU ]\n" +
                        menu

        );
    }
    // MainMenu (1~4) - 1(메뉴 선택 후)
    public void foodMenuOption(String menu, double price){
        System.out.println(
                menu +
                        "위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n" +
                        "1. Single(W "+price/1000+")        2. Double(W "+price*1.8/1000+")"
        );
    }
    // MainMenu (1~4) - 1 - 1(옵션 선택 후)
    public void foodMenuChoose(String menu){
        System.out.println(
                menu +
                        "\n위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                        "1. 확인        2. 취소"
        );
    }
    public void foodMenuChooseCorrect(String foodName){
        System.out.println(foodName + " 가 장바구니에 추가되었습니다.");
    }
    // MainMenu 5번
    public void orderMenu(String orderMenu, double price){
        System.out.println(
                "아래와 같이 주문 하시겠습니까?\n\n" +
                        "[ Orders ]\n" +
                        orderMenu +
                        "\n[ Total ]\n"+
                        "W " + price +
                        "\n\n1. 주문      2. 메뉴판"
        );
    }
    // MainMenu 5 - 1
    public void orderMenuChoose(int waitingNumber){
        System.out.println(
                "주문이 완료되었습니다!\n" +
                        "\n" +
                        "대기번호는 [ "+waitingNumber+" ] 번 입니다.\n" +
                        "(3초후 메뉴판으로 돌아갑니다.)"
        );
    }
    // MainMenu 6번
    public void cancelMenu(){
        System.out.println(
                "진행하던 주문을 취소하시겠습니까?\n" +
                        "1. 확인        2. 취소"
        );
    }
    // MainMenu 0번 숨겨진 기능
    public void hideMenu(double salePrice, String saleMenu){
        System.out.println(
                "[ 총 판매금액 현황 ]\n" +
                        "현재까지 총 판매된 금액은 [ W "+salePrice+" ] 입니다.\n\n" +
                        "[ 총 판매상품 목록 현황 ]\n" +
                        "현재까지 총 판매된 상품 목록은 아래와 같습니다.\n" +
                        saleMenu +
                        "\n\n 버튼을 눌러 돌아가기"
        );
    }
}
