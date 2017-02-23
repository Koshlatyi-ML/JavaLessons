package oop.homework.state.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DistrictTest {
    @Test
    public void hasCityTrue() throws Exception {
        City city1 = new City("cuty1", 1);
        City city2 = new City("city2", 2);

        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);

        District district = DisctrictFactory.createDistrict(cities);

        assertTrue(district.hasCity(city1));
    }

    @Test
    public void hasCityFalse() throws Exception {
        City city1 = new City("cuty1", 1);
        City city2 = new City("city2", 2);
        City city3 = new City("city3", 3);

        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);

        District district = DisctrictFactory.createDistrict(cities);

        assertFalse(district.hasCity(city3));
    }


    @Test
    public void getArea() throws Exception {
        City city1 = new City("cuty1", 1);
        City city2 = new City("city2", 2);
        City city3 = new City("city3", 3);

        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);

        District district = DisctrictFactory.createDistrict(cities);

        assertEquals(6, district.getArea(), 0.0001);
    }
}