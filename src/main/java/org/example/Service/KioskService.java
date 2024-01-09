package org.example.Service;

import org.example.Dto.ProductDto;
import org.example.Model.Order;
import org.example.Model.Product;


public class KioskService {

    private final ProductDto productDto = new ProductDto();
    private Product product = new Product();
    private final Order order = new Order();
    private final Order afterOrder = new Order();

    public void selectProduct(int mainMenuInputValue, int subMenuInputValue){
        switch (mainMenuInputValue){
            case 1 -> product = productDto.getSingleBurgerArrayList().get(subMenuInputValue);
            case 2 -> product = productDto.getForzenCustardArrayList().get(subMenuInputValue);
            case 3 -> product = productDto.getDrinkArrayList().get(subMenuInputValue);
            case 4 -> product = productDto.getBeerArrayList().get(subMenuInputValue);
            default -> throw new IllegalStateException("Unexpected value: " + mainMenuInputValue);
        }
    }

    public void menuOptionDouble(int subMenuInputValue, int menuOptionInputValue){
        if (menuOptionInputValue == 2){ // 더블일 경우 상품 더블로 변경
            product = productDto.getDoubleBurgerArrayList().get(subMenuInputValue);
        }
    }

    public void addBasket(){
        order.addOrder(product);
    }

    public void moveAfterOrder(){
        for (Product afterProduct : order.getOrderList()){
            afterOrder.addOrder(new Product(afterProduct));
        }
        afterOrder.addTotalSaleAmount(order.orderPrice());
    }

    public void orderListInit(){
        order.orderListQuantityZero();
        order.deleteOrder();
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    public Order getAfterOrder() {
        return afterOrder;
    }

    public void plusWaitingNumber(){
        order.plusWaitingNumber();
    }

    public void deleteOrder(){
        order.deleteOrder();
    }
}
