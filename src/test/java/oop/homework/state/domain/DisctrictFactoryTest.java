package oop.homework.state.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DisctrictFactoryTest {
    @Test
    public void createDistrict() throws Exception {
        City city1 = new City("cuty1", 1);
        City city2 = new City("city2", 2);

        List<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);

        District district = DisctrictFactory.createDistrict(cities);

        assertEquals(cities, district.getCities());

    }

    @Test(expected = NullPointerException.class)
    public void createDistrictNull() throws Exception {
        DisctrictFactory.createDistrict(null);
    }
}