package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public static void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Warsaw", true);
        airports.put("Amsterdam", true);
        airports.put("Paris", false);
        airports.put("Berlin", true);
        airports.put("London", false);

        if((!airports.containsKey(flight.getDepartureAirport())) || (!airports.containsKey(flight.getArrivalAirport()))) {
            throw new RouteNotFoundException("That Airport is not on the list.");
        } else {
            if(airports.get(flight.getDepartureAirport()) == false || airports.get(flight.getArrivalAirport()) == false) {
                System.out.println("Flight is not available.");
            } else {
                System.out.println("Flight is available.");
            }
        }

       /* if(!airports.containsKey(flight.getArrivalAirport())) {
            throw new RouteNotFoundException("That Arrival Airport is not on the list.");
        } else {
            if(airports.get(flight.getArrivalAirport()) == true) {
                System.out.println("Flight is available.");
            } else {
                System.out.println("Flight is not available.");
            }
        } */
    }
}
