package oop.homework.state.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StateFactoryTest {
    private static List<Region> regions;

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

        City odessa = CityFactory.createCity("Odessa", 10);
        City dnipro = CityFactory.createCity("Dnipro", 10);

        List<City> cities3 = new ArrayList<City>() {{
            add(odessa);
            add(dnipro);
        }};

        City donetsk = CityFactory.createCity("Donetsk", 10);
        City kryzhopil = CityFactory.createCity("Kryzhopil", 10);

        List<City> cities4 = new ArrayList<City>() {{
            add(donetsk);
            add(kryzhopil);
        }};

        District district1 = DisctrictFactory.createDistrict(cities1);
        District district2 = DisctrictFactory.createDistrict(cities2);
        District district3 = DisctrictFactory.createDistrict(cities3);
        District district4 = DisctrictFactory.createDistrict(cities4);

        List<District> districts1 = new ArrayList<District>() {{
            add(district1);
            add(district2);
        }};

        List<District> districts2 = new ArrayList<District>() {{
            add(district3);
            add(district4);
        }};

        Region region1 = RegionFactory.createRegion(districts1, kyiv);
        Region region2 = RegionFactory.createRegion(districts2, odessa);

        regions = new ArrayList<Region>() {{
            add(region1);
            add(region2);
        }};
    }

    @Test(expected = NullPointerException.class)
    public void createStateNull() throws Exception {
        StateFactory.createState(null, CityFactory.createCity("Name", 15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void createStateWrongCity() throws Exception {
        StateFactory.createState(regions, CityFactory.createCity("Name", 15));
    }

    @Test
    public void createState() throws Exception {
        City city = CityFactory.createCity("Kyiv", 10);
        State state =  StateFactory.createState(regions, city);

        assertEquals(city, state.getCapital());
        assertEquals(regions, state.getRegions());
    }


}