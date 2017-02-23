package oop.homework.geometry;

import oop.homework.geometry.util.GeometryUtils;

public class Ring extends Shape {
    public Ring(Point[] points) {
        super(points);
    }

    public double getRadius() {
        return GeometryUtils.getLineLength(points[0], points[1]);
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }
}
