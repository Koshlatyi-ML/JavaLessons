package oop.homework.state.domain;

public class City implements Territory {
    String name;
    double area;

    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
