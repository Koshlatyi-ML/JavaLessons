package oop.homework.geometry;

abstract public class Shape {
    Point[] points;

    public Shape(Point[] points) {
        this.points = points;
    }

    abstract public double getArea();

    public double add(Shape addend) {
        return this.getArea() + addend.getArea();
    }
}
