package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private double base;
    private double high;

    public Triangle(double base, double high) {
        this.base = base;
        this.high = high;
    }

    @Override
    public String getShapeName() {
        return "Triangle";

    }

    @Override
    public double getField() {
        return 0.5 * high * base;
    }

    public String toString() {
        return getShapeName() + " a = " + base + " h = " + high;
    }
}
