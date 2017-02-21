package oop.homework.concat;

import oop.homework.qsort.Quicksorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Base {
    int i;

    public Base(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

class BaseComparator implements Comparator<Base> {
    @Override
    public int compare(Base o1, Base o2) {
        return o1.i - o2.i;
    }
}

class Derive1 extends Base{
    double d;

    public Derive1(int i, double d) {
        super(i);
        this.d = d;
    }
}

class Derive1Comparator implements Comparator<Derive1> {
    @Override
    public int compare(Derive1 o1, Derive1 o2) {
        return (int)(o1.d - o2.d);
    }
}

class Derive2 extends Base {
    String s;

    public Derive2(int i, String s) {
        super(i);
        this.s = s;
    }
}

class Derive2Comparator implements Comparator<Derive2> {
    @Override
    public int compare(Derive2 o1, Derive2 o2) {
        return o1.s.compareTo(o2.s);
    }
}

public class Concatenator<T> {
    public List<T> concatAndSort(List<T> list1, List<? extends T> list2,
                                 Comparator<? super T> comparator) {
        list1.addAll(list2);
        return new Quicksorter<>(list1).sort(comparator);

    }

    public static void main(String[] args) {
        List<Base> list = new ArrayList<Base>() {{
            add(new Base(12));
            add(new Base(22));
            add(new Base(33));
        }};

        List<Derive1> derive1List = new ArrayList<Derive1>() {{
            add(new Derive1(50, 50.01));
            add(new Derive1(70, 70.01));
            add(new Derive1(120, 120.01));
        }};

        List<Base> bases = new Concatenator<Base>()
                .concatAndSort(list, derive1List, new BaseComparator());
    }
}
