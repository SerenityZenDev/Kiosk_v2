package org.example.Model;

import org.example.Dto.ProductDto;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Product extends Menu{
    private int price;
    private int quantity;
    public Product(String name, String description, int price) {
        super(name, description);
        this.price = price;
        this.quantity = 0;
    }
    public Product(Product other){
        super(other.getName(), other.getDescription());
        this.price = other.getPrice();
        this.quantity = other.getQuantity();
    }

    public Product() {}
    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return getName() + "   | W "+(double)price/1000+" | "+ getDescription();
    }


    public String productText(ArrayList<Product> productArrayList){
        String text = "";
        int number = 1;
        for (Product product : productArrayList){
            text += number++ + ". " + product.toString() + "\n";
        }
        return text;
    }
    public void quantityPlus(){
        quantity++;
    }

    public void quantityZero(){
        quantity = 0;
    }
}
