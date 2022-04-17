package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Shop {

    @Override
    public void process(Order order) throws OutOfStockException {
        System.out.println('\n' + "Order from HealthyShop");
        for(String product : order.getOrders().keySet()) {
            if(order.getOrders().get(product) <= getProductList().get(product)) {
                System.out.println("Ordered: " + product +
                        "\nDelivery address: " + order.getAddress());
            } else if(getProductList().containsKey(product) &&
                    order.getOrders().get(product) > getProductList().get(product)) {
                System.out.println(product + ": ");
                throw new OutOfStockException(product +
                        " is out of stock or we don't have enough products." +
                        "\nActual number of " + product + ": " + getProductList().get(product));
            } else {
                System.out.println(product + " is unavailable now.");
            }
        }
    }

    public Map<String, Integer> getProductList() {

        Map<String, Integer> healthyShopProducts = new HashMap<>();
        healthyShopProducts.put("Salad", 5);
        healthyShopProducts.put("Cucumber", 10);
        healthyShopProducts.put("Tomato", 25);
        healthyShopProducts.put("Sunflower seeds", 10);

        return healthyShopProducts;
    }
}
