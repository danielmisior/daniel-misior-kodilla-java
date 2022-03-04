package com.kodilla.exception.test;

public class FlightFinderRunner {

    public static void main(String[] args) {

        Flight flight1 = new Flight("Warsaw", "Berlin");
        Flight flight2 = new Flight("Paris", "London");
        Flight flight3 = new Flight("Cracow", "Tokyo");
        FlightFinder flightFinder = new FlightFinder();

        try{
            System.out.println("\nSearching flight: " + flight1);
            flightFinder.findFlight(flight1);

            System.out.println("\nSearching flight: " + flight2);
            flightFinder.findFlight(flight2);

            System.out.println("\nSearching flight: " + flight3);
            flightFinder.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("Something went wrong: " + '\n' + e);
        } finally {
            System.out.println("\nThank you for using our app.");
        }
    }
}
