package com.kodilla.testing.shape;

public class Square implements Shape {

    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "Square";

    }

    @Override
    public double getField() {
        return width * width;
    }

    public String toString() {
        return getShapeName() + " width = " + width;
    }
}
