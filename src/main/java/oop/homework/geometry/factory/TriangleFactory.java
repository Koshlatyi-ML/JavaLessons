package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.Triangle;
import oop.homework.geometry.util.ArrayUtils;

import java.util.Objects;

public class TriangleFactory implements ShapeFactory {
    private static final String WRONG_POINTS_AMOUNT_MSG
            = "points array argument should be the length of 3.";

    private static final String IDENTICAL_POINTS_MSG
            = "points array argument has identical values.";

    private static TriangleFactory instance = new TriangleFactory();

    private TriangleFactory(){}

    static TriangleFactory getInstance() {
        return instance;
    }

    @Override
    public Shape createShape(Point[] points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        if (points.length != 3) {
            throw new IllegalArgumentException(WRONG_POINTS_AMOUNT_MSG);
        }

        if (!ArrayUtils.hasDistinctValues(points)) {
            throw new IllegalArgumentException(IDENTICAL_POINTS_MSG);
        }

        return new Triangle(points);
    }
}
