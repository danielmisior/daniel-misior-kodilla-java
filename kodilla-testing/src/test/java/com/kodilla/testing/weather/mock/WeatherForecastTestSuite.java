package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@DisplayName("Weather Forecast Test Suite")
@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The Beginning of tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are done");
    }

    @BeforeEach
    public void testNumbers() {
        testCounter++;
        System.out.println("Test number: " + testCounter);
    }

    @Nested
    @DisplayName("Calculate Forecast Testing")
    class CalculateForecastTest {

        @Mock
        private Temperatures temperaturesMock;

        @Test
        void testCalculateForecastWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();

            temperaturesMap.put("Rzeszów", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(5, quantityOfSensors);
        }
    }

    @Nested
    @DisplayName("Average Calculation Test")
    class CalculateAverageTest {

        @Mock
        private Temperatures temperaturesMock;
        @Test
        void testCalculateAverageWithMock() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();

            temperaturesMap.put("Rzeszów", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            double result = weatherForecast.calculateAverage();
            double expectedResult = 25.56;

            //Then
            Assertions.assertEquals(expectedResult, result);
        }
    }

    @Nested
    @DisplayName("Median Calculation Test")
    class CalculateMedianTest {

        @Mock
        private Temperatures temperaturesMock;

        @Test
        void testCalculateMedianWithMockForUneven() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();

            temperaturesMap.put("Rzeszów", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            temperaturesMap.put("Gdansk", 26.1);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            List<Double> unevenList = new ArrayList<>();
            unevenList.add(25.5);
            unevenList.add(26.2);
            unevenList.add(24.8);
            unevenList.add(25.2);
            unevenList.add(26.1);

            //When
            double result = weatherForecast.calculateMedian();
            double expectedResult = 25.5;

            //Then
            Assertions.assertEquals(expectedResult, result);
        }

        @Test
        void testCalculateMedianWithMockForEven() {
            //Given
            Map<String, Double> temperaturesMap = new HashMap<>();

            temperaturesMap.put("Rzeszów", 25.5);
            temperaturesMap.put("Krakow", 26.2);
            temperaturesMap.put("Wroclaw", 24.8);
            temperaturesMap.put("Warszawa", 25.2);
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            List<Double> evenList = new ArrayList<>();
            evenList.add(25.5);
            evenList.add(26.2);
            evenList.add(24.8);
            evenList.add(25.2);

            //When
            double result = weatherForecast.calculateMedian();
            double expectedResult = 25.35;

            //Then
            Assertions.assertEquals(expectedResult, result);
        }
    }
}
