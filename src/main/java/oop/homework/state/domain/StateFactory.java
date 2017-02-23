package oop.homework.state.domain;

import java.util.List;
import java.util.Objects;

public class StateFactory {
    private static final String NOT_COMPRISED_CITY_MSG
            = "state doesn't has a specified city";

    private StateFactory() {}

    public static State createState(List<Region> regions, City capital) {
        if (Objects.isNull(regions)) {
            throw new NullPointerException();
        }

        if (Objects.isNull(capital)) {
            throw new NullPointerException();
        }

        boolean hasCity = regions.stream()
                .anyMatch(region -> region.hasCity(capital));


        if (!hasCity) {
            throw new IllegalArgumentException(NOT_COMPRISED_CITY_MSG);
        }

        return new State(regions, capital);
    }
}
