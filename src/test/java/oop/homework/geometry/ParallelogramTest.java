package oop.homework.geometry;

import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParallelogramTest {
    ShapeFactory factory = ShapeFactories.getFactory(Figure.PARALLELOGRAM);

    @Test
    public void getAreaTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape parallelogram = factory.createShape(points);
        assertEquals(16, parallelogram.getArea(), 0.0001);
    }

    @Test
    public void addTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape parallelogram1 = factory.createShape(points);
        Shape parallelogram2 = factory.createShape(points);
        assertEquals(32, parallelogram1.add(parallelogram2), 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        Point[] points = {
                new Point(4,2),
                new Point(0, 0),
                new Point(4, -2)
        };
        Shape parallelogram = factory.createShape(points);
        parallelogram.add(null);
    }
}