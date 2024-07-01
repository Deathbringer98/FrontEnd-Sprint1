"""

package com.keyin.http.cli;

import com.keyin.Aircraft;
import com.keyin.Airport;
import com.keyin.City;
import com.keyin.Passenger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AircraftTest {

    @Test
    public void testAircraftCreation() {
        City toronto = new City("Toronto", "Ontario", 2800000);
        City vancouver = new City("Vancouver", "British Columbia", 675218);

        Airport yyz = new Airport("Pearson", "YYZ", toronto);
        Airport yvr = new Airport("Vancouver International", "YVR", vancouver);

        Passenger passenger1 = new Passenger("John", "Doe", "1234567890", toronto);
        Passenger passenger2 = new Passenger("Jane", "Smith", "0987654321", vancouver);

        List<Airport> airports = Arrays.asList(yyz, yvr);
        List<Passenger> passengers = Arrays.asList(passenger1, passenger2);

        Aircraft aircraft = new Aircraft("Boeing 737", "Air Canada", 180, airports, passengers);

        assertEquals("Boeing 737", aircraft.getAircraftType());
        assertEquals("Air Canada", aircraft.getAirlineName());
        assertEquals(180, aircraft.getPassengerCapacity());
        assertEquals(airports, aircraft.getAirports());
        assertEquals(passengers, aircraft.getPassengers());
    }

    @Test
    public void testSettersAndGetters() {
        City calgary = new City("Calgary", "Alberta", 1239220);
        City montreal = new City("Montreal", "Quebec", 1760000);

        Airport yyc = new Airport("Calgary International", "YYC", calgary);
        Airport yul = new Airport("Montreal-Trudeau", "YUL", montreal);

        Passenger passenger1 = new Passenger("Alice", "Johnson", "1122334455", calgary);
        Passenger passenger2 = new Passenger("Bob", "Williams", "2233445566", montreal);

        List<Airport> airports = Arrays.asList(yyc, yul);
        List<Passenger> passengers = Arrays.asList(passenger1, passenger2);

        Aircraft aircraft = new Aircraft("Airbus A320", "WestJet", 150, airports, passengers);

        aircraft.setAircraftType("Boeing 787");
        aircraft.setAirlineName("Air Transit");
        aircraft.setPassengerCapacity(200);
        aircraft.setAirports(airports);
        aircraft.setPassengers(passengers);

        assertEquals("Boeing 787", aircraft.getAircraftType());
        assertEquals("Air Transit", aircraft.getAirlineName());
        assertEquals(200, aircraft.getPassengerCapacity());
        assertEquals(airports, aircraft.getAirports());
        assertEquals(passengers, aircraft.getPassengers());
    }
}
"""