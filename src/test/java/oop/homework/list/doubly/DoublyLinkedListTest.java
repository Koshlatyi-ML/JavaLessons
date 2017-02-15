package oop.homework.list.doubly;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoublyLinkedListTest {
    @Test
    public void getFirst() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        Point first = new Point(0,0);
        linkedList.add(first);

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        assertEquals(first, linkedList.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        Point last = new Point(0,0);
        linkedList.add(last);

        assertEquals(last, linkedList.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsSmall() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));
        linkedList.get(-2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsBig() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();
        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));
        linkedList.get(12);
    }


    @Test
    public void get() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        Point third = new Point(0,0);
        linkedList.add(third);

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));


        assertEquals(third, linkedList.get(2));
    }

    @Test
    public void addFirst() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        Point first = new Point(0,0);
        linkedList.addFirst(first);

        assertEquals(first, linkedList.getFirst());
    }

    @Test
    public void add() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        Point last = new Point(0,0);
        linkedList.add(last);

        assertEquals(last, linkedList.getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setLeftOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        linkedList.set(-2, new Point(1, 1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setRightOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        linkedList.set(3, new Point(1, 1));
    }

    @Test
    public void set() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));
        linkedList.add(new Point(4,4));

        Point setted = new Point(1,1);
        linkedList.set(1, setted);

        assertEquals(setted, linkedList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeLeftOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        linkedList.remove(-1);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeRightOutOfBounds() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        linkedList.add(new Point(1,2));
        linkedList.add(new Point(3,4));

        linkedList.remove(2);
    }

    @Test
    public void remove() throws Exception {
        DoublyLinkedList<Point> linkedList = new DoublyLinkedList<>();

        Point first = new Point(1,2);
        linkedList.add(first);

        Point second = new Point(3, 4);
        linkedList.add(second);

        Point third = new Point(4,4);
        linkedList.add(third);

        linkedList.remove(1);

        assertEquals(third, linkedList.get(1));
    }

}