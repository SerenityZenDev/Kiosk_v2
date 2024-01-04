package org.example.View;
import org.example.Controller.ProductController;
import org.example.Model.Product;

import java.util.ArrayList;

public class ProductView {
    private ProductController productController;

    public ProductView(ProductController productController) {
        this.productController = productController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void printProductList(ArrayList<Product> productArrayList){
        int number = 1;
        double price = 0;
        for (Product product : productArrayList){
            price = (double)product.getPrice()/1000;
            System.out.println(number++ +". " + product.getName() + "\t| W " + price + "\t| " + product.getDescription());
        }
    }
    public void printBeer(){
        int number = 1;
        double price = 0;
        for (Product Beer : productController.getBeerArrayList()){
            price = Beer.getPrice()/1000;
            System.out.println(number++ +". " + Beer.getName() + "\t| W " + price + "\t| " + Beer.getDescription());
        }
    }
}
