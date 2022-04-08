package com.kodilla.good.patterns.challenges.airlines;

public class FlightFinderApp {

    public static void main(String[] args) {
        FlightFinder flightFinder = new FlightFinder();

        flightFinder.findFlightFrom("Warsaw");
        flightFinder.findFlightTo("Paris");
        flightFinder.findFlightVia("Amsterdam", "Madrid");
    }
}
