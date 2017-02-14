package oop.homework.geometry;

public class Parallelogram extends Shape {
    public Parallelogram(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        return Math.abs(points[1].getX() * points[1].getX()
                        + points[0].getY() * points[2].getY());
    }
}
