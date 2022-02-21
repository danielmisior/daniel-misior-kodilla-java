package com.kodilla.stream.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Array Operations Test")
public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        //Given
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        array[5] = 6;
        array[6] = 7;
        array[7] = 8;
        array[8] = 9;
        array[9] = 10;

        //When
        double result = ArrayOperations.getAverage(array);

        //Then
        assertEquals(5.5, result);
    }
}
