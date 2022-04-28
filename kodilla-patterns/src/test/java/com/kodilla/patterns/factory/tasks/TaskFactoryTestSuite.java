package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    private TaskFactory factory;

    @BeforeEach
    void beforeEveryTest() {
        factory = new TaskFactory();
    }

    @Test
    void testFactoryShoppingTask() {
        //Given
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);

        //Then
        assertEquals("Birthday shopping", shopping.getTaskName());
        assertEquals(true, shopping.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);

        //Then
        assertEquals("Rent car",driving.getTaskName());
        assertEquals(true, driving.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);

        //Then
        assertEquals("Painting room", painting.getTaskName());
        assertEquals(true, painting.isTaskExecuted());
    }
}
