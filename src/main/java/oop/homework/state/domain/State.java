package oop.homework.state.domain;

import java.util.List;
import java.util.stream.Collectors;

public class State implements Territory {
    private List<Region> regions;
    private City capital;

    State(List<Region> regions, City capital) {
        this.regions = regions;
        this.capital = capital;
    }

    public City getCapital() {
        return capital;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public int getRegionsCount() {
        return regions.size();
    }

    public List<City> getAllRegionCenters() {
        return regions.stream()
                .map(region -> region.getRegionCenter())
                .collect(Collectors.toList());
    }

    @Override
    public double getArea() {
        return regions.stream()
                .mapToDouble(Region::getArea)
                .sum();
    }
}
