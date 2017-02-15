package oop.homework.state.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {
    @Test
    public void equalsTrue() throws Exception {
        City city1 = new City("city", 1);
        City city2 = new City("city", 1);
        assertTrue(city1.equals(city2));
    }

    @Test
    public void equalsFalse() throws Exception {
        City city1 = new City("city", 2);
        City city2 = new City("City", 2);
        assertFalse(city1.equals(city2));
    }


    @Test
    public void hashCodeTest() throws Exception {
        City city1 = new City("city", 1);
        City city2 = new City("city", 1);
        assertTrue(city1.hashCode() == city2.hashCode());
    }

}