package oop.homework.state.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegionFactoryTest {
    private static List<District> districts;

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

        districts = new ArrayList<District>() {{
            add(district1);
            add(district2);
        }};

    }

    @Test(expected = NullPointerException.class)
    public void createRegionNull() throws Exception {
        RegionFactory.createRegion(null, CityFactory.createCity("kiev", 1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createRegionWrongCenter() {
        RegionFactory.createRegion(districts, CityFactory.createCity("NY", 500));
    }

    @Test
    public void createRegion() {
        City center = districts.get(0).getCities().get(0);
        Region region = RegionFactory.createRegion(districts, center);

        assertEquals(center, region.getRegionCenter());
        assertEquals(districts, region.districts);
    }
}