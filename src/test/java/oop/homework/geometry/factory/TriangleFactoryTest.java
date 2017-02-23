package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleFactoryTest {
    TriangleFactory triangleFactory = TriangleFactory.getInstance();

    @Test(expected = NullPointerException.class)
    public void createShapeTestNull() {
        triangleFactory.createShape(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestLessPoints() {
        triangleFactory.createShape(new Point[]{new Point(1, 1), new Point(0, 0)});
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestExaggeratePoints() {
        Point[] points = {
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(3, 3)
        };
        triangleFactory.createShape(points);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestIdenticalPoints() {
        Point[] points = {
                new Point(2, 2),
                new Point(0, 0),
                new Point(0, 0)
        };
        triangleFactory.createShape(points);
    }

    @Test()
    public void createShape() {
        Exception exception = null;

        Point[] points = {
                new Point(0, 0),
                new Point(2, 2),
                new Point(3, 2),
        };
        try {
            triangleFactory.createShape(points);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals(null, exception);
    }
}