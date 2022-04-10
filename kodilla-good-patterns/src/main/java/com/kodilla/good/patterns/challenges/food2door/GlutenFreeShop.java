package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Shop {

    @Override
    public void process(Order order) {
        System.out.println('\n' + "Order from GlutenFreeShop");

        for(String product : order.getOrders().keySet()) {
            if(getProductList().containsKey(product) &&
                    order.getOrders().get(product) <= getProductList().get(product)) {
                System.out.println("Ordered: " + product +
                        "\nDelivery address: " + order.getAddress());
            } else if(getProductList().containsKey(product) &&
                    order.getOrders().get(product) > getProductList().get(product)){
                System.out.println("We don't have enough " + product +
                        '\n' + product + " in stock: " + getProductList().get(product));
            } else {
                System.out.println(product + " is unavailable now.");
            }
        }
    }

    public Map<String, Integer> getProductList() {

        Map<String, Integer> glutenFreeShopProducts = new HashMap<>();
        glutenFreeShopProducts.put("Gluten free bread", 10);
        glutenFreeShopProducts.put("Gluten free rolls", 60);
        glutenFreeShopProducts.put("Gluten free rolls with butter", 20);
        glutenFreeShopProducts.put("Gluten free hawaiian pizza", 5);

        return glutenFreeShopProducts;
    }
}