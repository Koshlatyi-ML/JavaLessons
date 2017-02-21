package oop.homework.queue.compare;

import java.util.Comparator;

public class ComparatorStrategy<T> implements ComparisonStrategy<T>{
    private Comparator<? super T> comparator;

    public ComparatorStrategy(Comparator<? super T> comparator) {
        this.comparator = comparator;


    }

    @Override
    public int compare(T obj1, T obj2) {
        return comparator.compare(obj1, obj2);
    }
}
