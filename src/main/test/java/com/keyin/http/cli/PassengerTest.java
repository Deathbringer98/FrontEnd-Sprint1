package com.keyin.http.cli;

import com.keyin.City;
import com.keyin.Passenger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PassengerTest {

    @Test
    public void testPassengerCreation() {
        City city = new City("Halifax", "NS", 50000);
        Passenger passenger = new Passenger("John", "Doe", "1234567890", city);

        assertEquals("John", passenger.getFirstName());
        assertEquals("Doe", passenger.getLastName());
        assertEquals("1234567890", passenger.getPhoneNum());
        assertEquals(city, passenger.getCity());
    }

    @Test
    public void testSettersAndGetters() {
        City city = new City("Toronto", "ON", 100020);
        Passenger passenger = new Passenger();
        passenger.setPassenger_id(1L);
        passenger.setFirstName("Jane");
        passenger.setLastName("Smith");
        passenger.setPhoneNum("0987654321");
        passenger.setCity(city);

        assertEquals(1L, passenger.getPassenger_id());
        assertEquals("Jane", passenger.getFirstName());
        assertEquals("Smith", passenger.getLastName());
        assertEquals("0987654321", passenger.getPhoneNum());
        assertEquals(city, passenger.getCity());
    }
}
