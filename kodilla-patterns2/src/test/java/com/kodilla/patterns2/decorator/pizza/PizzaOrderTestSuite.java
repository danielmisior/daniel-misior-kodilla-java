package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    private PizzaOrder pizzaOrder;

    @BeforeEach
    void beforeEveryTest() {
        pizzaOrder = new BasicPizzaOrder();
    }

    @Test
    void testBasicPizzaOrder() {
        //Given
        //When
        BigDecimal cost = pizzaOrder.getCost();
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals(new BigDecimal(15), cost);
        assertEquals("Pizza with tomato sauce and cheese", ingredients);
    }

    @Test
    void testPizzaOrderWithSalamiAndExtraCheese() {
        //Given
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals(new BigDecimal(21), cost);
        assertEquals("Pizza with tomato sauce and cheese + salami + extra cheese", ingredients);
    }

    @Test
    void testPizzaOrderWithHamAndPineapple() {
        //Given
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new PineappleDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals(new BigDecimal(22), cost);
        assertEquals("Pizza with tomato sauce and cheese + ham + pineapple", ingredients);
    }

    @Test
    void testPizzaOrderWithSalamiHamAndRedPepper() {
        //Given
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new HamDecorator(pizzaOrder);
        pizzaOrder = new RedPepperDecorator(pizzaOrder);

        //When
        BigDecimal cost = pizzaOrder.getCost();
        String ingredients = pizzaOrder.getIngredients();

        //Then
        assertEquals(new BigDecimal(27), cost);
        assertEquals("Pizza with tomato sauce and cheese + salami + ham + red pepper", ingredients);
    }
}
