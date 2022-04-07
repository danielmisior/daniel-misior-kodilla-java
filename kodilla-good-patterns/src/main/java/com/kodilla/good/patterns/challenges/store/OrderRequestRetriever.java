package com.kodilla.good.patterns.challenges.store;

public class OrderRequestRetriever {

    public OrderRequest retrieveOrder() {
        User user = new User("John Smith", "john.smith123@example.com");
        Product product = new Product("Knife", 2, 15.99);

        return new OrderRequest(user, product);
    }
}
