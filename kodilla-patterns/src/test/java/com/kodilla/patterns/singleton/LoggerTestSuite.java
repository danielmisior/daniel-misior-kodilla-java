package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLastLog() {
        //Given
        Logger.getInstance().log("Last log");

        //When
        String lastLog = Logger.getInstance().getLastLog();

        //Then
        assertEquals("Last log", lastLog);
    }
}
