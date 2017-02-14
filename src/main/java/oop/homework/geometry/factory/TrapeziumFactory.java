package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.Trapezium;
import oop.homework.geometry.util.ArrayUtils;
import oop.homework.geometry.util.GeometryUtils;

import java.util.Objects;

public class TrapeziumFactory implements ShapeFactory {
    private static final String WRONG_POINTS_AMOUNT_MSG
            = "points array argument should be the length of 3.";

    private static final String IDENTICAL_POINTS_MSG
            = "points array argument has identical values.";

    private static final String  NON_PARALLEL_BASES_MSG
            = "points array argument describes non-parallel bases.";

    private static TrapeziumFactory instance = new TrapeziumFactory();

    private TrapeziumFactory() {}

    public static TrapeziumFactory getInstance() {
        return instance;
    }

    @Override
    public Shape createShape(Point[] points) {
        if (Objects.isNull(points)) {
            throw new NullPointerException();
        }

        if (points.length != 4) {
            throw new IllegalArgumentException(WRONG_POINTS_AMOUNT_MSG);
        }

        if (ArrayUtils.hasDistinctValues(points)) {
            throw new IllegalArgumentException(IDENTICAL_POINTS_MSG);
        }

        if (!GeometryUtils.isParallel(points[0], points[3], points[1],
                                      points[2])) {
            throw new IllegalArgumentException(NON_PARALLEL_BASES_MSG);
        }

        return new Trapezium(points);
    }
}
