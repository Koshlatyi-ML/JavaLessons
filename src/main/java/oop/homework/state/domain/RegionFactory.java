package oop.homework.state.domain;

import java.util.List;
import java.util.Objects;

public class RegionFactory {
    private static final String NOT_COMPRISED_CITY_MSG
            = "region doesn't has a specified city";

    private RegionFactory() {}

    public static Region createRegion(List<District> districts,
                                      City regionCenter) {
        if (Objects.isNull(districts)) {
            throw new NullPointerException();
        }

        if (Objects.isNull(regionCenter)) {
            throw new NullPointerException();
        }

        boolean hasCity = districts.stream()
                .anyMatch(district -> district.hasCity(regionCenter));

        if (!hasCity) {
            throw new IllegalArgumentException(NOT_COMPRISED_CITY_MSG);
        }

        return new Region(districts, regionCenter);
    }
}
