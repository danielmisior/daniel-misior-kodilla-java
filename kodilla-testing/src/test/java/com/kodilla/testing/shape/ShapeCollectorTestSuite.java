package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTest() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Test #" + testCounter);
    }

    @Nested
    @DisplayName("Test about adding")
    class AddingTest {

        @Test
        void testAddFigure() {
            //Given
            Shape circle = new Circle(7.5);
            ShapeCollector shapeCollector = new ShapeCollector();

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("Test about removing")
    class RemovingTest {

        @Test
        void testRemoveFigure() {
            //Given
            Shape circle = new Circle(7.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.removeFigure(circle);

            //Then
            Assertions.assertEquals(0, shapeCollector.getShapesQuantity());
        }
    }

    @Nested
    @DisplayName("Test about getting")
    class GettingTest {

        @Test
        void testGetFigure() {

            //Given
            Shape circle = new Circle(7.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            shapeCollector.addFigure(circle);

            //Then
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("Test about showing")
    class ShowingTest {

        @Test
        void testShowFigure() {
            //Given
            Shape circle = new Circle(7.5);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(circle);

            //When
            String result = shapeCollector.showFigures();
            String expectedResult = "[Circle r = 7.5]";

            //Then
            Assertions.assertEquals(expectedResult, result);
        }
    }
}