package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParallelogramFactoryTest {
    ParallelogramFactory parallelogramFactory = ParallelogramFactory.getInstance();

    @Test(expected = NullPointerException.class)
    public void createShapeTestNull() {
        parallelogramFactory.createShape(null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestLessPoints() {
        parallelogramFactory.createShape(new Point[]{new Point(1, 1)});
    }
    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestExaggeratePoints() {
        Point[] points =  {
                new Point(1, 2),
                new Point(2, 2),
                new Point(3, 2),
                new Point(1, 0),
                new Point(1, -2)
        };
        parallelogramFactory.createShape(points);
    }
    @Test(expected = IllegalArgumentException.class)
    public void createShapeTestIdenticalPoints() {
        Point[] points =  {
                new Point(1, 2),
                new Point(2, 2),
                new Point(2, 2),
        };
        parallelogramFactory.createShape(points);
    }

    @Test()
    public void createShape() {
        Exception exception = null;

        Point[] points = {
                new Point(1, 2),
                new Point(2, 2),
                new Point(2, 5),
        };
        try {
            parallelogramFactory.createShape(points);
        } catch (Exception e) {
            exception = e;
        }

        assertEquals(null, exception);
    }
}