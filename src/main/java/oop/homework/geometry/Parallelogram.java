package oop.homework.geometry;

import oop.homework.geometry.util.GeometryUtils;

public class Parallelogram extends Shape {
    public Parallelogram(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        return Math.abs(GeometryUtils.multiplyVectors(points[1],points[0],
                                                      points[1], points[2]));
    }
}
