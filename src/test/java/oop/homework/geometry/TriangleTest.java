package oop.homework.geometry;

import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleTest {
    ShapeFactory factory = ShapeFactories.getFactory(Figure.TRIANGLE);

    @Test
    public void getAreaTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape triangle = factory.createShape(points);
        assertEquals(8, triangle.getArea(), 0.0001);
    }

    @Test
    public void addTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape triangle1 = factory.createShape(points);
        Shape triangle2 = factory.createShape(points);
        assertEquals(16, triangle1.add(triangle2), 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape triangle = factory.createShape(points);
        triangle.add(null);
    }

}