package oop.homework.geometry;

import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RingTest {
    ShapeFactory factory = ShapeFactories.getFactory(Figure.RING);
    @Test
    public void getRadiusTest() {
        Point[] points = {
                new Point(0,0),
                new Point(2, -3)
        };

        Shape ring = factory.createShape(points);
        assertEquals(Math.sqrt(13), ((Ring)ring).getRadius(), 0.0001);
    }
    @Test
    public void getAreaTest() {
        Point[] points = {
                new Point(0,0),
                new Point(2, -3)
        };

        Shape ring = factory.createShape(points);
        assertEquals(Math.PI * 13, ring.getArea(), 0001);
    }

    @Test
    public void addTest() {
        Point[] points = {
                new Point(0,0),
                new Point(2, -3)
        };
        Shape ring1 = factory.createShape(points);
        Shape ring2 = factory.createShape(points);
        assertEquals(Math.PI * 13 * 2, ring1.add(ring2), 0.0001);
    }

    @Test
    public void addNullTest() {
        Point[] points = {
                new Point(0,0),
                new Point(2, -3)
        };
        Shape ring = factory.createShape(points);
        ring.add(null);
    }
}