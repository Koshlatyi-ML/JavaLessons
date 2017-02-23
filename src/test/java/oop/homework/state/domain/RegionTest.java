package oop.homework.state.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegionTest {
    private static Region testable;

    @BeforeClass
    public static void init() {
        City kyiv = CityFactory.createCity("Kyiv", 10);
        City chernihiv = CityFactory.createCity("Chernihiv", 10);

        List<City> cities1 = new ArrayList<City>() {{
            add(kyiv);
            add(chernihiv);
        }};

        City lviv = CityFactory.createCity("Lviv", 10);
        City kharkiv = CityFactory.createCity("Kharkiv", 10);

        List<City> cities2 = new ArrayList<City>() {{
            add(lviv);
            add(kharkiv);
        }};

        District district1 = DisctrictFactory.createDistrict(cities1);
        District district2 = DisctrictFactory.createDistrict(cities2);

        List<District> districts1 = new ArrayList<District>() {{
            add(district1);
            add(district2);
        }};

        testable = RegionFactory.createRegion(districts1, kyiv);

    }

    @Test
    public void hasCityTrue() throws Exception {
        City city = CityFactory.createCity("Lviv", 10);
        assertTrue(testable.hasCity(city));
    }

    @Test
    public void hasCityFalse() throws Exception {
        City city = CityFactory.createCity("NY", 10);
        assertFalse(testable.hasCity(city));
    }


    @Test
    public void getArea() throws Exception {
        assertEquals(40, testable.getArea(), 0.0001);
    }

}