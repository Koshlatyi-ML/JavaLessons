package oop.homework.queue.compare;

public class ComparableStrategy<T> implements ComparisonStrategy<T> {
    @Override
    public int compare(T obj1, T obj2) {
        return ((Comparable<? super T>) obj1).compareTo(obj2);
    }
}
