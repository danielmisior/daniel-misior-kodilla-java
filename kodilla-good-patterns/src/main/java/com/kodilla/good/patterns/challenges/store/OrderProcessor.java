package com.kodilla.good.patterns.challenges.store;

public class OrderProcessor {

    private InformationService informationService;
    private OrderRepository orderRepository;
    private  OrderService orderService;

    public OrderProcessor(final InformationService informationService,
                          final OrderRepository orderRepository,
                          final OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct());
        if(isOrdered) {
            informationService.sendMessage(orderRequest.getUser());
            orderRepository.makeOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
