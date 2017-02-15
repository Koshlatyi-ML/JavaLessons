package oop.homework.state.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityFactoryTest {
    @Test(expected = NullPointerException.class)
    public void createCityNull() throws Exception {
        CityFactory.createCity(null, 10000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCityNegativeArea() throws Exception {
        CityFactory.createCity("D.C.", -10000);
    }

    @Test
    public void createCity() {
        String name = "Name";
        double area = 1000;
        City city = CityFactory.createCity(name, area);

        assertEquals(name, city.getName());
        assertEquals(area, city.getArea(), 0.0001);
    }
}