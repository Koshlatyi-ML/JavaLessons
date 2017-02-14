package oop.homework.geometry;

import oop.homework.geometry.util.GeometryUtils;

public class Trapezium extends Shape{
    public Trapezium(Point[] points) {
        super(points);
    }

    @Override
    public double getArea() {
        double topBaseLength = GeometryUtils.getLineLength(points[1], points[2]);
        double bottomBaseLength = GeometryUtils.getLineLength(points[0], points[3]);

        double altitudeLength
                = GeometryUtils.multiplyVectors(points[0], points[1], points[0], points[3])
                  / GeometryUtils.getLineLength(points[0], points[3]);

        return (topBaseLength + bottomBaseLength) / 2.0 * altitudeLength;
    }
}
