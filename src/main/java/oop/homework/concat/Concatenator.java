package oop.homework.concat;

import oop.homework.qsort.Quicksorter;

import java.util.Comparator;
import java.util.List;

public class Concatenator<T> {
    public List<T> concatAndSort(List<T> list1, List<? extends T> list2,
                                 Comparator<? super T> comparator) {
        list1.addAll(list2);
        return new Quicksorter<>(list1).sort(comparator);
    }
}
