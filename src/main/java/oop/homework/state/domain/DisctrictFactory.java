package oop.homework.state.domain;

import java.util.List;
import java.util.Objects;

public class DisctrictFactory {
    private DisctrictFactory() {}

    public static District createDistrict(List<City> cities) {
        if (Objects.isNull(cities)) {
            throw new NullPointerException();
        }

        return new District(cities);
    }
}
