package org.example.Model;


public class Menu {
    String name; // 메뉴 이름
    String description; // 메뉴 설명

    public Menu(String name, String description ) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
