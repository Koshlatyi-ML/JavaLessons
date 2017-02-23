package oop.homework.state.domain;

import java.util.Objects;

public class CityFactory {
    private static final String NEGATIVE_AREA_MSG = "City area is negative" +
                                                    " value";

    private CityFactory() {}

    public static City createCity(String name, double area) {
        if (Objects.isNull(name)) {
            throw new NullPointerException();
        }

        if (area <= 0 ) {
            throw new IllegalArgumentException(NEGATIVE_AREA_MSG);
        }

        return new City(name, area);
    }
}
