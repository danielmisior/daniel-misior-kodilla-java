package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    TaskQueue maxQueue;
    TaskQueue carolineQueue;
    TaskQueue davidQueue;
    Mentor frankSinatra;
    Mentor morganFreeman;

    @BeforeEach
    void before() {
        maxQueue = new StudentMaxQueue();
        carolineQueue = new StudentCarolineQueue();
        davidQueue = new StudentDavidQueue();
        frankSinatra = new Mentor("Frank Sinatra");
        morganFreeman = new Mentor("Morgan Freeman");
    }

    @Test
    void testUpdateTask() {
        //Given
        maxQueue.registerObserver(frankSinatra);
        carolineQueue.registerObserver(morganFreeman);
        davidQueue.registerObserver(morganFreeman);
        //When
        maxQueue.addTask("Builder");
        maxQueue.addTask("Facade");
        carolineQueue.addTask("Decorator");
        carolineQueue.addTask("Builder");
        carolineQueue.addTask("Observer");
        davidQueue.addTask("Factory");
        //Then
        assertEquals(2, frankSinatra.getUpdateTaskCount());
        assertEquals(4, morganFreeman.getUpdateTaskCount());
    }

    @Test
    void removeObserverTest() {
        //Given
        maxQueue.registerObserver(frankSinatra);
        carolineQueue.registerObserver(frankSinatra);
        carolineQueue.registerObserver(morganFreeman);
        //When
        maxQueue.addTask("Builder");
        maxQueue.addTask("Facade");

        carolineQueue.removeObserver(frankSinatra);
        carolineQueue.addTask("Decorator");
        carolineQueue.addTask("Builder");
        carolineQueue.addTask("Observer");
        //Then
        assertEquals(2, frankSinatra.getUpdateTaskCount());
        assertEquals(3, morganFreeman.getUpdateTaskCount());
    }
}
