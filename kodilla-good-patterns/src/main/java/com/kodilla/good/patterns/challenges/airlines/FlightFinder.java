package com.kodilla.good.patterns.challenges.airlines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {

    public List<Flight> getFlights() {
        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Berlin", "Paris"));
        flights.add(new Flight("Tokyo", "Cracow"));
        flights.add(new Flight("Madrid", "Amsterdam"));
        flights.add(new Flight("Warsaw", "Barcelona"));
        flights.add(new Flight("Warsaw", "Paris"));

        return flights;
    }

    public void findFlightFrom(String from) {
        List<Flight> result = getFlights().stream()
                .filter(f -> f.getDepartureAirport().equals(from))
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.out.println("The flight cannot be founded. Try again.");
        } else {
            System.out.println("Available flights from the selected airport:");
            for(Flight flight : result) {
                System.out.println(flight.toString());
            }
        }
    }

    public void findFlightTo(String to) {
        List<Flight> result = getFlights().stream()
                .filter(f -> f.getArrivalAirport().equals(to))
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.out.println("\nThe flight cannot be founded. Try again.");
        } else  {
            System.out.println("\nAvailable flights to the selected airport:");
            for(Flight flight : result) {
                System.out.println(flight.toString());
            }
        }
    }

    public void findFlightVia(String to, String via) {
        List<Flight> result = getFlights().stream()
                .filter(f -> f.getArrivalAirport().equals(to))
                .filter(f -> f.getDepartureAirport().equals(via))
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.out.println("\nThe flight cannot be founded. Try again.");
        } else {
            for(Flight flight : result) {
                System.out.println("\nAvailable flights to " + flight.getArrivalAirport() + " via " + flight.getDepartureAirport());
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
