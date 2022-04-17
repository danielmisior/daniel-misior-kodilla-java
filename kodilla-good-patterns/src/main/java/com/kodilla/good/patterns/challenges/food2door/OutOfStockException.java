package com.kodilla.good.patterns.challenges.food2door;

public class OutOfStockException extends IndexOutOfBoundsException {
    public OutOfStockException(final String s) {
        super(s);
    }
}