package oop.homework.geometry.util;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class GeometryUtilsTest {
    @Test(expected = NullPointerException.class)
    public void getLineLengthNullAll() throws Exception {
        GeometryUtils.getLineLength(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void getLineLengthNullRight() throws Exception {
        GeometryUtils.getLineLength(new Point(0,0), null);
    }

    @Test(expected = NullPointerException.class)
    public void getLineLengthNullLeft() throws Exception {
        GeometryUtils.getLineLength(null, new Point(0, 0));
    }

    @Test
    public void getLineLength() {
        Point a = new Point(3, 4);
        Point b = new Point(0, 0);

        double length = GeometryUtils.getLineLength(a,b);

        assertEquals(5, length, 0.0001);
    }

    @Test
    public void getLineLengthZero() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);

        double length = GeometryUtils.getLineLength(a,b);

        assertEquals(0, length, 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void myltiplyVectorsNull() throws Exception {
        GeometryUtils.multiplyVectors(null, new Point(0,1),
                new Point(1,1), new Point(2,2));
    }

    @Test
    public void myltiplyVectors() throws Exception {
        double mult =  GeometryUtils.multiplyVectors(new Point(2,4), new Point(6,6),
                                                     new Point(1,1), new Point(5,-1));
        assertEquals(-16, mult, 0.0001);
    }


    @Test(expected = NullPointerException.class)
    public void isParallelNull() throws Exception {
        GeometryUtils.isParallel(null, new Point(0,1),
                new Point(1,1), new Point(2,2));
    }

    @Test
    public void isParallelTrue() throws Exception {
        boolean result = GeometryUtils.isParallel(new Point(0,0), new Point(7,0),
                                                  new Point(4,5), new Point(1,5));
        assertTrue(result);
    }

    @Test
    public void isParallelFalse() throws Exception {
        boolean result = GeometryUtils.isParallel(new Point(-1,-7), new Point(1,5),
                new Point(4,5), new Point(7,0));
        assertFalse(result);
    }

}