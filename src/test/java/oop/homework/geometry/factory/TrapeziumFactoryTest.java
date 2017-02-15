package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrapeziumFactoryTest {
    TrapeziumFactory trapeziumFactory = TrapeziumFactory.getInstance();

    @Test(expected = NullPointerException.class)
    public void createShapeTestNull() {
        trapeziumFactory.createShape(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestLessPoints() {
        trapeziumFactory.createShape(new Point[]{new Point(1, 1), new Point(0, 0)});
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestExaggeratePoints() {
        Point[] points = {
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(3, 3),
                new Point(0, 0)
        };
        trapeziumFactory.createShape(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestIdenticalPoints() {
        Point[] points = {
                new Point(2, 2),
                new Point(3, 2),
                new Point(0, 0),
                new Point(0, 0)
        };
        trapeziumFactory.createShape(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestNonParallelBases() {
        Point[] points = {
                new Point(0, 0),
                new Point(-3, -2),
                new Point(1, 1),
                new Point(5, 6)
        };
        trapeziumFactory.createShape(points);
    }

    @Test()
    public void createShape() {
        Exception exception = null;

        Point[] points = {
                new Point(0, 0),
                new Point(2, 2),
                new Point(3, 2),
                new Point(5, 0),
        };
        try {
            trapeziumFactory.createShape(points);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals(null, exception);
    }

}