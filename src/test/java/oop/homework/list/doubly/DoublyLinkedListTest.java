package oop.homework.list.doubly;

import oop.homework.geometry.Point;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void getFirst() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        Point first = new Point(0, 0);
        linkedList.add(first);

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        assertEquals(first, linkedList.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        Point last = new Point(0, 0);
        linkedList.add(last);

        assertEquals(last, linkedList.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsSmall() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));
        linkedList.get(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsBig() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));
        linkedList.get(12);
    }


    @Test
    public void get() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        Point third = new Point(0, 0);
        linkedList.add(third);

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));


        assertEquals(third, linkedList.get(2));
    }

    @Test
    public void addFirst() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        Point first = new Point(0, 0);
        linkedList.addFirst(first);

        assertEquals(first, linkedList.getFirst());
    }

    @Test
    public void add() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        Point last = new Point(0, 0);
        linkedList.add(last);

        assertEquals(last, linkedList.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setLeftOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        linkedList.set(-2, new Point(1, 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setRightOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        linkedList.set(3, new Point(1, 1));
    }

    @Test
    public void set() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));
        linkedList.add(new Point(4, 4));

        Point setted = new Point(1, 1);
        linkedList.set(1, setted);

        assertEquals(setted, linkedList.get(1));
    }

    @Test
    public void containsTrue() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));
        linkedList.add(new Point(4, 4));

        assertTrue(linkedList.contains(new Point(3, 4)));

    }

    @Test
    public void containsFalse() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));
        linkedList.add(new Point(4, 4));

        assertFalse(linkedList.contains(new Point(30, 40)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLeftOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        linkedList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeRightOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1, 2));
        linkedList.add(new Point(3, 4));

        linkedList.remove(2);
    }

    @Test
    public void remove() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        linkedList.add(first);

        Point second = new Point(3, 4);
        linkedList.add(second);

        Point third = new Point(4, 4);
        linkedList.add(third);

        linkedList.remove(1);

        assertEquals(third, linkedList.get(1));
    }

    @Test
    public void tryRemoveNotExistent() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = new Point(3, 4);
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        assertFalse(linkedList.tryRemove(new Point(10, 10)));
    }

    @Test
    public void tryRemoveNullTrue() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = null;
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        assertTrue(linkedList.tryRemove(null));
    }

    @Test
    public void tryRemoveNullContainsFalse() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = null;
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(null);

        assertFalse(linkedList.contains(second));
    }

    @Test
    public void tryRemoveNullSizeChanged() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = null;
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(null);

        assertEquals(2, linkedList.size());
    }

    @Test
    public void tryRemoveNullElementsShifted() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = null;
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(null);

        assertEquals(third, linkedList.get(1));
    }

    @Test
    public void tryRemoveObjTrue() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = new Point(2, 2);
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(second);

        assertTrue(linkedList.tryRemove(new Point(4, 4)));
    }

    @Test
    public void tryRemoveObjContainsFalse() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = new Point(2, 2);
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(second);

        assertFalse(linkedList.contains(second));
    }

    @Test
    public void tryRemoveObjSizeChanged() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = new Point(2, 2);
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(second);

        assertEquals(2, linkedList.size());
    }

    @Test
    public void tryRemoveObjElementsShifted() {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1, 2);
        Point second = new Point(2, 2);
        Point third = new Point(4, 4);

        linkedList.add(first);
        linkedList.add(second);
        linkedList.add(third);

        linkedList.tryRemove(second);

        assertEquals(third, linkedList.get(1));
    }
}