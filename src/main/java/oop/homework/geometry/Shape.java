package oop.homework.geometry;

abstract public class Shape {
    Point[] points;

    public Shape(Point[] points) {
        this.points = points;
    }

    abstract public double getArea();

    public double add(Shape addend) {
        if (addend == null) {
            throw new NullPointerException();
        }

        return this.getArea() + addend.getArea();
    }
}
