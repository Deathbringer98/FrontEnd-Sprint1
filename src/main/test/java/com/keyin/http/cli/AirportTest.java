package com.keyin.http.cli;

import com.keyin.Airport;
import com.keyin.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @Test
    public void testAirportCreation() {
        City city = new City("Toronto", "Ontario", 2800000);
        Airport airport = new Airport("Pearson", "YYZ", city);

        assertEquals("Pearson", airport.getName());
        assertEquals("YYZ", airport.getCode());
        assertEquals(city, airport.getCity());
    }

    @Test
    public void testSettersAndGetters() {
        City city = new City("Vancouver", "British Columbia", 675218);
        Airport airport = new Airport();
        airport.setName("Vancouver International");
        airport.setCode("YVR");
        airport.setCity(city);

        assertEquals("Vancouver International", airport.getName());
        assertEquals("YVR", airport.getCode());
        assertEquals(city, airport.getCity());
    }
}
