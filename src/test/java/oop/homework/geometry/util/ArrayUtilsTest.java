package oop.homework.geometry.util;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayUtilsTest {
    @Test
    public void hasDistinctValuesFalse() throws Exception {
        Point p1 = new Point(0, 1);

        Point[] points = {p1, p1, p1};

        assertFalse(ArrayUtils.hasDistinctValues(points));
    }

    @Test
    public void hasDistinctValues() throws Exception {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(0, 1);

        Point[] points = {p1, p2, p3};

        assertFalse(ArrayUtils.hasDistinctValues(points));
    }

    @Test
    public void hasDistinctValuesStrFalse() throws Exception {
        String[] strings = {"32", "56", "88", "88"};

        assertFalse(ArrayUtils.hasDistinctValues(strings));
    }

    @Test
    public void hasDistinctStrValues() throws Exception {
        String[] strings = {"32", "56", "98", "88"};

        assertTrue(ArrayUtils.hasDistinctValues(strings));
    }

    @Test(expected = NullPointerException.class)
    public void hasDistinctValuesNull() throws Exception {
        ArrayUtils.hasDistinctValues(null);
    }
}