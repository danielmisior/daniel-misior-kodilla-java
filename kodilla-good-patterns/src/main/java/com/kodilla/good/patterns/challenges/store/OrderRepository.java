package com.kodilla.good.patterns.challenges.store;

public interface OrderRepository {
    void makeOrder(User user, Product product);
}
