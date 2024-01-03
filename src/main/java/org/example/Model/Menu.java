package org.example.Model;


public class Menu {
    String name; // 메뉴 이름
    String description; // 메뉴 설명
    int price; // 메뉴 가격

    public Menu(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
