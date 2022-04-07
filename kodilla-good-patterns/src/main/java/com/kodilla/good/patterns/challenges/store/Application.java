package com.kodilla.good.patterns.challenges.store;

public class Application {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieveOrder();

        OrderProcessor orderProcessor = new OrderProcessor(new MailService(), new ProductOrderRepository(), new ProductOrderService());
        orderProcessor.process(orderRequest);
    }
}
