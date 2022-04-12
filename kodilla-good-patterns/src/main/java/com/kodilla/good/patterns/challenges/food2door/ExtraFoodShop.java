package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Shop {

    @Override
    public void process(Order order) {
        System.out.println('\n' + "Order from ExtraFoodShop");

        try {
            for(String product : order.getOrders().keySet()) {
                if(order.getOrders().get(product) <= getProductList().get(product)) {
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
        } catch(Exception e) {
            System.out.println("Selected product is unavailable now or " +
                    "we don't have enough products in stock." +
                    "\nPlease, check your shopping cart.");
        }
    }

    public Map<String, Integer> getProductList() {

        Map<String, Integer> extraFoodProducts = new HashMap<>();
        extraFoodProducts.put("Butter", 30);
        extraFoodProducts.put("Water 1L", 50);
        extraFoodProducts.put("Sausages", 10);
        extraFoodProducts.put("Garlic", 15);

        return extraFoodProducts;
    }
}
