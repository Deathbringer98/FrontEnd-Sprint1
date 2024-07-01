package com.keyin.http.cli;

import com.keyin.City;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityTest {

    @Test
    public void testCityCreation() {
        City city = new City("Toronto", "Ontario", 2800000);

        assertEquals("Toronto", city.getName());
        assertEquals("Ontario", city.getProvince());
        assertEquals(2800000, city.getPopulation());
    }

    @Test
    public void testSettersAndGetters() {
        City city = new City("Toronto", "Ontario", 2800000);
        city.setName("Vancouver");
        city.setProvince("British Columbia");
        city.setPopulation(675218);

        assertEquals("Vancouver", city.getName());
        assertEquals("British Columbia", city.getProvince());
        assertEquals(675218, city.getPopulation());
    }
}
