package org.example.Model;


public class Menu {
    private String name; // 메뉴 이름
    private String description; // 메뉴 설명

    public Menu(String name, String description ) {
        this.name = name;
        this.description = description;
    }

    public Menu() {}

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
