package com.kodilla.good.patterns.challenges.food2door;

public class Food2DoorApp {

    public static void main(String[] args) {

        OrderRetriever orderRetriever = new OrderRetriever();
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();

        try {
            extraFoodShop.process(orderRetriever.retrieve());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Not enough products in stock.");
        }
    }
}
