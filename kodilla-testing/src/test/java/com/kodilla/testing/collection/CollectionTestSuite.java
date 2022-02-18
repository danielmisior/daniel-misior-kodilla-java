package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test List: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test List: end");
    }

    @DisplayName("when created empty list of numbers")

    @Test
    void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(emptyList);
        System.out.println("Empty List test - OK");

        //Then
        Assertions.assertEquals(emptyList, resultList);
    }

    @DisplayName("when created normal list of numbers")

    @Test
    void testOddNumberExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        List<Integer> fullList = new ArrayList<>();
        fullList.add(2);
        fullList.add(10);
        fullList.add(12);
        fullList.add(35);
        fullList.add(51);
        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(2);
        expectedList.add(10);
        expectedList.add(12);

        //When
        List<Integer> resultList = oddNumbersExterminator.exterminate(fullList);
        System.out.println("Test Normal List - OK");

        //Then
        Assertions.assertEquals(expectedList, resultList);
    }
}
