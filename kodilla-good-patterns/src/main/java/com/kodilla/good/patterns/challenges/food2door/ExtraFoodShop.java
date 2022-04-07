package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Shop {

    @Override
    public void process(Order order) {
        for(String product : order.getOrders().keySet()) {
            if(getProductList().containsKey(product) &&
                    order.getOrders().get(product) <= getProductList().get(product)) {
                System.out.println("Ordered: " + product +
                        "\n Delivery address: " + order.getAddress());
            } else {
                System.out.println(product + " is unavailable now.");
            }
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
