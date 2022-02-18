package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature: temperatures.getTemperatures().entrySet()) {

            //adding 1 celsius degree to current value
            //as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage() {
        Map<String, Double> averageMap = new HashMap<>();
        double sum = 0;

        for(Map.Entry<String, Double> temp: temperatures.getTemperatures().entrySet()) {
            sum += temp.getValue();
        }
        double average = sum / temperatures.getTemperatures().size();
        return average;
    }

    public double calculateMedian() {
        List<Double> medianList = new ArrayList<>(temperatures.getTemperatures().values());
        double median = 0;

        Collections.sort(medianList);

        if(medianList.size() % 2 == 0) {
            double average = medianList.get(medianList.size() / 2) + medianList.get((medianList.size() / 2 ) - 1) ;
            median = average / 2;
        }
        else {
            int i = medianList.size() / 2;
            median = medianList.get(i);
        }
        return median;
    }
}
