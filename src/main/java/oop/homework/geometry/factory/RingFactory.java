package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import oop.homework.geometry.Ring;
import oop.homework.geometry.Shape;

import java.util.Objects;

public class RingFactory implements ShapeFactory {
    private static final String WRONG_POINTS_AMOUNT_MSG
            = "points array argument should be the length of 3.";

    private static final String IDENTICAL_POINTS_MSG
            = "points array argument has identical values.";

    private static RingFactory instance = new RingFactory();

    private RingFactory(){}

    public static RingFactory getInstance() {
        return instance;
    }

    @Override
    public Shape createShape(Point[] points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        if (points.length != 2) {
            throw new IllegalArgumentException(WRONG_POINTS_AMOUNT_MSG);
        }

        if (points[0].equals(points[1])) {
            throw new IllegalArgumentException(IDENTICAL_POINTS_MSG);
        }

        return new Ring(points);
    }
}
