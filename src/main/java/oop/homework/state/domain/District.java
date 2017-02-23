package oop.homework.state.domain;

import java.util.List;

public class District implements Territory {
    List<City> cities;

    District(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public boolean hasCity(City city) {
        return cities.stream().anyMatch(c -> c.equals(city));
    }

    @Override
    public double getArea() {
        return cities.stream()
                .mapToDouble(City::getArea)
                .sum();
    }
}
