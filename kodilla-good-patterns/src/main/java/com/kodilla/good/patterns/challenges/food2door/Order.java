package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<String, Integer> orders = new HashMap<>();
    private String address;

    public Order(Map<String, Integer> orders, String address) {
        this.orders = orders;
        this.address = address;
    }

    public Map<String, Integer> getOrders() {
        return orders;
    }

    public String getAddress() {
        return address;
    }
}
