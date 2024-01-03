package org.example.View;
import org.example.Controller.ProductController;
import org.example.Model.Product;

public class ProductView {
    private ProductController productController;

    public ProductView(ProductController productController) {
        this.productController = productController;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void printBurger(){
        int number = 1;
        double price = 0;
        for (Product burger : productController.getProductArrayList()){
            price = burger.getPrice()/1000;
            System.out.println(number++ +". " + burger.getName() + "\t| W " + price + "\t| " + burger.getDescription());
        }
    }
}
