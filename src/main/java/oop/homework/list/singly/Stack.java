package oop.homework.list.singly;

import java.util.NoSuchElementException;
import java.util.Objects;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public boolean isEmpty() {
        return Objects.isNull(top);
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        final Node<T> oldTop = top;
        top = new Node<T>(item, oldTop);
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T item = top.item;
        top = top.next;
        size--;

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return top.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
