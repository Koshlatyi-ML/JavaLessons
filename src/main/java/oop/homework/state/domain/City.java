package oop.homework.state.domain;

import java.util.Objects;

public class City implements Territory {
    private String name;
    private double area;

    City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Double.compare(city.getArea(), getArea()) == 0 &&
                Objects.equals(getName(), city.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getArea());
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
