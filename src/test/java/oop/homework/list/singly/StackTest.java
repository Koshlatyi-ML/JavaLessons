package oop.homework.list.singly;

import oop.homework.geometry.Point;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void isEmptyTrue() throws Exception {
        assertTrue(new Stack<>().isEmpty());
    }

    @Test
    public void isEmptyFalse() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void sizeZero() throws Exception {
        assertEquals(0, new Stack<>().size());
    }

    @Test
    public void size() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.size());
    }

    @Test
    public void push() throws Exception {
        Stack<Point> stack = new Stack<>();

        Point point = new Point(0, 2);
        stack.push(point);

        assertEquals(point, stack.peek());
    }

    @Test
    public void pushSizeChanged() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int size = stack.size();

        stack.push(2);
        stack.push(3);

        assertEquals(size + 2, stack.size());
    }

    @Test
    public void pop() throws Exception {
        Stack<Point> stack = new Stack<>();

        Point point = new Point(0, 2);
        stack.push(point);

        assertEquals(point, stack.pop());
    }

    @Test
    public void popSizeChanged() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int size = stack.size();

        stack.pop();
        stack.pop();

        assertEquals(size - 2, stack.size());
    }

    @Test
    public void peek() throws Exception {
        Stack<Point> stack = new Stack<>();

        Point point = new Point(0, 2);
        stack.push(point);

        assertEquals(point, stack.peek());
    }

    @Test
    public void peekSizeNotChanged() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int size = stack.size();

        stack.peek();
        stack.peek();

        assertEquals(size, stack.size());
    }
}