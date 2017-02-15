package oop.homework.list.doubly;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public T getFirst() {
        if (Objects.isNull(first)) {
            throw new NoSuchElementException();
        }

        return first.item;
    }

    public T getLast() {
        if (Objects.isNull(last)) {
            throw new NoSuchElementException();
        }

        return last.item;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        return getNode(index).item;
    }

    public void addFirst(T item) {
        final Node<T> oldFirst = first;
        final Node<T> newNode =  new Node<T>(item, null, oldFirst);
        first = newNode;

        if (oldFirst == null) {
            last = newNode;
        } else {
            oldFirst.previous = newNode;
        }

        size++;
    }

    public void add(T item) {
        final Node<T> oldLast = last;
        final Node<T> newNode =  new Node<T>(item, oldLast, null);
        last = newNode;

        if (oldLast == null) {
            first = newNode;
        } else {
            oldLast.next = newNode;
        }

        size++;
    }

    public void add(T item, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size) {
            add(item);
        } else {
            final Node<T> succeeding = getNode(index);
            final Node<T> preceding = succeeding.previous;
            Node<T> newNode = new Node<T>(item, preceding, succeeding);

            succeeding.previous = newNode;
            if (preceding == null) {
                first = newNode;
            } else {
                preceding.next = newNode;
            }
        }

        size++;
    }

    public void set(int index, T item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> oldNode = getNode(index);
        T oldValue = oldNode.item;
        oldNode.item = item;
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> erased = getNode(index);
        final T erasedItem = erased.item;
        final Node<T> succeeding = erased.next;
        final Node<T> preceding = erased.previous;

        if (preceding == null) {
            first = succeeding;
        } else {
            preceding.next = succeeding;
            erased.previous = null;
        }

        if (succeeding == null) {
            last = preceding;
        } else {
            succeeding.previous = preceding;
            erased.next = null;
        }

        erased.item = null;
        size--;
    }


    private Node<T> getNode(int index) {
        Node<T> node;

        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.next;
        } else {
            node = last;
            for (int i = size - 1; i > index; i--)
                node = node.previous;
        }

        return node;
    }

    private static class Node<T> {
        T item;
        Node<T> previous;
        Node<T> next;

        public Node(T item, Node<T> previous, Node<T> next) {
            LinkedList l = new LinkedList();
            l.add(null);
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }
}
