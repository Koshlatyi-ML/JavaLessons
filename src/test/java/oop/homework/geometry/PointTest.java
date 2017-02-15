package oop.homework.geometry;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void setX() throws Exception {
        Point point1 = new Point(0, 2);
        int newX = -100;
        point1.setX(newX);
        assertTrue(newX == point1.getX());

    }

    @Test
    public void setY() throws Exception {
        Point point1 = new Point(0, 2);
        int newY = -100;
        point1.setY(newY);
        assertTrue(newY == point1.getY());
    }

    @Test
    public void equalsTest() throws Exception {
        Point point1 = new Point(0, 2);
        Point point2 = new Point(0, 2);
        assertTrue(point1.equals(point2));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Point point1 = new Point(0, 2);
        Point point2 = new Point(0, 2);
        assertTrue(point1.hashCode() == point2.hashCode());
    }

}