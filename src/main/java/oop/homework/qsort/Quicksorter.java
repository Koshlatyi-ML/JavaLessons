package oop.homework.qsort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Quicksorter<T> {
    private List<T> list;
    private Comparator<? super T> comparator;

    public Quicksorter(List<T> list) {
        this.list = list;
    }

    public List<? extends T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<T> sort(Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException();
        }

        if (!list.isEmpty()) {
            this.comparator = comparator;
            quickSort(0, list.size() - 1);
        }

        return list;
    }

    private void quickSort(int begin, int end) {
        int partitionIndex = partition(begin, end);

        if (begin < partitionIndex - 1) {
            quickSort(begin, partitionIndex - 1);
        }

        if (partitionIndex < end) {
            quickSort(partitionIndex, end);
        }
    }

    private int partition(int begin, int end) {
        // Get the pivot element using the Sedgewick technique.
        T pivot = getMedianOfThree(begin, end);

        int left = begin;
        int right = end;

        while (left <= right) {
            while (comparator.compare(list.get(left), pivot) < 0) {
                left++;
            }

            while (comparator.compare(list.get(right), pivot) > 0) {
                right--;
            }

            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private T getMedianOfThree(int begin, int end) {
        int middle = (end + begin) / 2;

        List<T> elements = new ArrayList<T>() {{
                add(list.get(begin));
                add(list.get(middle));
                add(list.get(end));
            }};
        elements.sort(comparator);

        return elements.get(1);
    }
}
