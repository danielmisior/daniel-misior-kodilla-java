package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(10, 20);

        //Then
        assertEquals(result, 30);
    }

    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(20, 10);

        //Then
        assertEquals(result, 10);
    }

    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(12, 12);

        //Then
        assertEquals(result, 144);
    }

    @Test
    public void testDiv() {
        try {
            //Given
            //When
            double result = calculator.div(5, 5);
            double exceptionExpected = calculator.div(5, 0);

            //Then
            assertEquals(result, 25);
            assertEquals(exceptionExpected, "The division by 0 is forbidden.");
        } catch (ArithmeticException e) {
            System.out.println("The division by 0 is forbidden.");
        }
    }
}
