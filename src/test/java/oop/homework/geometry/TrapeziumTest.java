package oop.homework.geometry;

import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrapeziumTest {
    ShapeFactory factory = ShapeFactories.getFactory(Figure.TRAPEZIUM);

    @Test
    public void getAreaTest() throws Exception {
        Point[] points = {
                new Point(0,0),
                new Point(1, 5),
                new Point(4, 5),
                new Point(7, 0)
        };
        Shape trapezium = factory.createShape(points);

        assertEquals(25, trapezium.getArea(), 0.0001);
    }

    @Test
    public void addTest() throws Exception {
        Point[] points = {
                new Point(0,0),
                new Point(1, 5),
                new Point(4, 5),
                new Point(7, 0)
        };
        Shape trapezium1 = factory.createShape(points);
        Shape trapezium2 = factory.createShape(points);

        assertEquals(50, trapezium1.add(trapezium2), 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void addNull() throws Exception {
        Point[] points = {
                new Point(0,0),
                new Point(1, 5),
                new Point(4, 5),
                new Point(7, 0)
        };
        Shape trapezium = factory.createShape(points);
        trapezium.add(null);
    }

}