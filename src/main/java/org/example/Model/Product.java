package org.example.Model;

import java.util.ArrayList;

public class Product extends Menu{
    int price;
    int quantity;
    public Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
        this.quantity = 1;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
