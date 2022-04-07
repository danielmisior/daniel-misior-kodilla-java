package com.kodilla.good.patterns.challenges.store;

public class ProductOrderService implements OrderService{

    @Override
    public boolean order(final User user, final Product product) {
        System.out.println("User: " + user.getName() +
                " \n Ordered: " + product.getProductName() +
                " \n Price: " + product.getPrice() +
                " \n Quantity: " + product.getQuantity() +
                "\n Total: " + (product.getPrice() * product.getQuantity()));
        return true;
    }
}
