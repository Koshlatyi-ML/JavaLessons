package oop.homework.state.domain;

import java.util.List;

public class Region implements Territory {
    List<District> districts;
    City regionCenter;

    public Region(List<District> districts, City regionCenter) {
        this.districts = districts;
        this.regionCenter = regionCenter;
    }

    public City getRegionCenter() {
        return regionCenter;
    }

    public void setRegionCenter(City regionCenter) {
        this.regionCenter = regionCenter;
    }

    public boolean hasCity(City city) {
        return districts.stream().anyMatch(district -> district.hasCity(city));
    }

    @Override
    public double getArea() {
        return districts.stream()
                .mapToDouble(District::getArea)
                .sum();
    }
}
