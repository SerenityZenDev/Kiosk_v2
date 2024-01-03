package org.example.Controller;

import org.example.Model.Product;

import java.util.ArrayList;

public class ProductController {
    private ArrayList<Product> productArrayList;

    public ProductController(ArrayList<Product> productArrayList) {
        this.productArrayList = productArrayList;
        productArrayList.add(new Product("ShackBurger","토마토, 양상추, 쉑소스가 토핑된 치즈버거",6900));
        productArrayList.add(new Product("SmokeShack","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",8900));
        productArrayList.add(new Product("Shroom Burger","몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",9400));
        productArrayList.add(new Product("Cheeseburger","포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",6900));
        productArrayList.add(new Product("Hamburger","비프패티를 기반으로 야채가 들어간 기본버거",5400));
    }

    public ArrayList<Product> getProductArrayList() {
        return productArrayList;
    }
}
