package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING TASK";
    public static final String PAINTING = "PAINTING TASK";
    public static final String SHOPPING = "SHOPPING TASK";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case DRIVING:
                return new DrivingTask("Rent car", "Cracow", "Tour");
            case PAINTING:
                return new PaintingTask("Painting room", "Green", "Walls");
            case SHOPPING:
                return new ShoppingTask("Birthday shopping", "Balloons and confetti", 5);
            default:
                return null;
        }
    }
}
