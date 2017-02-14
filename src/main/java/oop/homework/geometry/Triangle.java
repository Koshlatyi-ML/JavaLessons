package oop.homework.geometry;

import oop.homework.geometry.util.GeometryUtils;

public class Triangle extends Shape{
    public Triangle(Point[] points) {
        super(points);
    }

    private double getSideLength(int sideIndex) {
        if (sideIndex < 0 || sideIndex > 2) {
            throw new IllegalArgumentException();
        }

        return GeometryUtils.getLineLength(points[sideIndex + 1 % points.length], points[sideIndex]);
    }

    @Override
    public double getArea() {
        return Math.abs(points[1].getX() * points[1].getX()
                + points[0].getY() * points[2].getY()) / 2.0;
    }
}
