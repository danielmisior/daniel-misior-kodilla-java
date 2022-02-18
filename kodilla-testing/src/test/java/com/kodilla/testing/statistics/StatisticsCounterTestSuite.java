package com.kodilla.testing.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@DisplayName("Statistics Counter Test Suite")
@ExtendWith(MockitoExtension.class)
public class StatisticsCounterTestSuite {

    private static int testCounter = 0;
    private StatisticsCounter statisticsCounter;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The beginning of tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are done");
    }

    @BeforeEach
    public void testNumbers() {
        testCounter++;
        System.out.println("Test #" + testCounter);
    }

    @BeforeEach
    public void beforeEach() {
        statisticsCounter = new StatisticsCounter();
        statisticsCounter.calculateAdvStatistics(statistics);
    }

    private List<String> generateListOfNUsers(int users) {
        List<String> userList = new ArrayList<>();
        for(int i = 0; i < users; i++) {
            userList.add("User" + i);
        }
        return userList;
    }

    @Mock
    private Statistics statistics;

    @Test
    void test0Posts() {
        //Given
        when(statistics.postsCount()).thenReturn(0);

        //When
        int result = statisticsCounter.getPostsQuantity();

        //Then
        Assertions.assertEquals(0, result);
    }

    @Test
    void test1000Posts() {
        //Given
        when(statistics.postsCount()).thenReturn(1000);

        //When
        int result = statisticsCounter.getPostsQuantity();

        //Then
        Assertions.assertEquals(1000, result);
    }

    @Test
    void test0Comments() {
        //Given
        when(statistics.commentsCount()).thenReturn(0);

        //When
        int result = statisticsCounter.getCommentsQuantity();

        //Then
        Assertions.assertEquals(0, result);
    }

    @Test
    void testCommentsLessThanPosts() {
        //Given
        when(statistics.commentsCount()).thenReturn(10);
        when(statistics.postsCount()).thenReturn(20);

        //When
        double result = statisticsCounter.getAverageCommentsPerPost();

        //Then
        Assertions.assertEquals(0.5, result);
    }

    @Test
    void testCommentsMoreThanPosts() {
        //Given
        when(statistics.commentsCount()).thenReturn(20);
        when(statistics.postsCount()).thenReturn(10);

        //When
        double result = statisticsCounter.getAverageCommentsPerPost();

        //Then
        Assertions.assertEquals(2, result);
    }

    @Test
    void test0Users() {
        //Given
        when(statistics.usersNames()).thenReturn(generateListOfNUsers(0));

        //When
        List<String> resultList = statisticsCounter.getUsers();
        List<String> expectedList = new ArrayList<>();

        //Then
        Assertions.assertEquals(expectedList, resultList);
    }

    @Test
    void test100Users() {
        //Given
        when(statistics.usersNames()).thenReturn(generateListOfNUsers(100));

        //When
        int result = statisticsCounter.getUsersQuantity();

        //Then
        Assertions.assertEquals(100, result);
    }
}
