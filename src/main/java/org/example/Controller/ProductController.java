package org.example.Controller;

import org.example.Model.Product;

import java.util.ArrayList;

public class ProductController {
    private ArrayList<Product> BurgerArrayList;
    private ArrayList<Product> ForzenCustardArrayList;
    private ArrayList<Product> DrinkArrayList;
    private ArrayList<Product> BeerArrayList;

    public ProductController(ArrayList<Product> burgerArrayList, ArrayList<Product> forzenCustardArrayList,
                             ArrayList<Product> drinkArrayList, ArrayList<Product> beerArrayList) {
        BurgerArrayList = burgerArrayList;
        ForzenCustardArrayList = forzenCustardArrayList;
        DrinkArrayList = drinkArrayList;
        BeerArrayList = beerArrayList;

        initProducts();
    }

    private void initProducts(){
        // Burger 기본 상품 등록
        BurgerArrayList.add(new Product("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6900));
        BurgerArrayList.add(new Product("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8900));
        BurgerArrayList.add(new Product("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9400));
        BurgerArrayList.add(new Product("Cheeseburger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6900));
        BurgerArrayList.add(new Product("Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5400));

        // ForzenCustard 기본 상품 등록
        ForzenCustardArrayList.add(new Product("VanillaIceCream", "바닐라 향이 풍부한 아이스크림", 4500));
        ForzenCustardArrayList.add(new Product("ChocolateIceCream", "진한 초콜릿 향이 느껴지는 아이스크림", 5000));
        ForzenCustardArrayList.add(new Product("StrawberryIceCream", "신선한 딸기의 고소한 맛이 느껴지는 아이스크림", 5200));
        ForzenCustardArrayList.add(new Product("MintChocolateChipIceCream", "향긋한 민트와 초콜릿이 어우러진 아이스크림", 5500));
        ForzenCustardArrayList.add(new Product("CaramelPecanIceCream", "부드러운 캐러멜과 고소한 피칸이 들어간 아이스크림", 5800));

        // Drinks 기본 상품 등록
        DrinkArrayList.add(new Product("Cola", "시원한 콜라 음료", 2500));
        DrinkArrayList.add(new Product("OrangeJuice", "신선한 오렌지 주스", 3000));
        DrinkArrayList.add(new Product("IcedCoffee", "얼음이 들어간 시원한 아이스 커피", 3500));
        DrinkArrayList.add(new Product("Lemonade", "상큼한 레모네이드 음료", 2800));
        DrinkArrayList.add(new Product("MangoSmoothie", "달콤한 망고 스무디", 4000));

        // Beer 기본 상품 등록
        BeerArrayList.add(new Product("Brooklyn Lager", "브루클린 라거로 대표적인 브루클린 맥주", 7500));
        BeerArrayList.add(new Product("Brooklyn East IPA", "브루클린의 독특한 East Coast IPA", 7800));
        BeerArrayList.add(new Product("Brooklyn Brown Ale", "부드러운 맛이 특징인 브루클린 브라운 에일", 7200));
        BeerArrayList.add(new Product("Brooklyn Sorachi Ace", "소라치 에이스 홉 사용한 특별한 브루클린 맥주", 8500));
        BeerArrayList.add(new Product("Brooklyn Bel Air Sour", "상큼하고 산뜻한 벨에어 사워 에일", 8000));


    }

    public ArrayList<Product> getBurgerArrayList() {
        return BurgerArrayList;
    }

    public ArrayList<Product> getForzenCustardArrayList() {
        return ForzenCustardArrayList;
    }

    public ArrayList<Product> getDrinkArrayList() {
        return DrinkArrayList;
    }

    public ArrayList<Product> getBeerArrayList() {
        return BeerArrayList;
    }
}
