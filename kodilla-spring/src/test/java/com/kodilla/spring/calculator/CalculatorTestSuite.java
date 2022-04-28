package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //Given
        //When
        double addResult = calculator.add(10, 20);
        double subResult = calculator.sub(10, 20);
        double mulResult = calculator.mul(10, 20);
        double divResult = calculator.div(10, 20);

        //Then
        assertEquals(addResult, 30);
        assertEquals(subResult, -10);
        assertEquals(mulResult, 200);
        assertEquals(divResult, 0.5);
    }

    @Test
    public void testWhenDividedBy0() {
        //Given
        //When & Then
        assertThrows(ArithmeticException.class, () -> calculator.div(10, 0));
    }
}
