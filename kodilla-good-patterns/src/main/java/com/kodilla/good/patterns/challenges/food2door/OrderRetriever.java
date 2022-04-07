package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderRetriever {

    public Order retrieve() {

        Map<String, Integer> order1 = new HashMap<>();
        order1.put("Water 1L", 4);
        order1.put("Garlic", 2);

        return new Order(order1, "Konopnicka 10, 50-452 Wroclaw");
    }
}
