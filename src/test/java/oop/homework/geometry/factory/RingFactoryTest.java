package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class RingFactoryTest {
    RingFactory ringFactory = RingFactory.getInstance();

    @Test(expected = NullPointerException.class)
    public void createShapeTestNull() {
        ringFactory.createShape(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestLessPoints() {
        ringFactory.createShape(new Point[]{new Point(1, 1)});
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestExaggeratePoints() {
        Point[] points = {
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
        };
        ringFactory.createShape(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestIdenticalPoints() {
        Point[] points = {
                new Point(0, 0),
                new Point(0, 0),
        };
        ringFactory.createShape(points);
    }

    @Test()
    public void createShape() {
        Exception exception = null;

        Point[] points = {
                new Point(1, 2),
                new Point(2, 2),
        };
        try {
            ringFactory.createShape(points);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals(null, exception);
    }
}