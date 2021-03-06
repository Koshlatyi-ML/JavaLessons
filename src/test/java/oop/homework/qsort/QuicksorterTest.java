package oop.homework.qsort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;


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

public class QuicksorterTest {


    @Test
    public void sortEmpty() throws Exception {
        List<String> list = new ArrayList<>();
        new Quicksorter<String>(list).sort(Comparator.naturalOrder());
        assertTrue(list.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sortNullComparator() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        list.add("astr3");

        List<String> sorted =  new Quicksorter<String>(list).sort(null);

    }
    @Test
    public void sort() {
        List<Base> list = new ArrayList<>();
        list.add(new Derive2(33, "d2"));
        list.add(new Derive2(39, "d3"));
        list.add(new Base(12));
        list.add(new Base(13));
        list.add(new Derive1(22, 1.01));
        list.add(new Derive1(23, 2.02));
        list.add(new Derive2(33, "d2"));
        list.add(new Derive2(33, "d3"));
        Quicksorter<Base> quicksorter = new Quicksorter<>(list);
        List<Base> sorted = quicksorter.sort(new BaseComparator());

        boolean isSorted = true;
        for (int i = 0; i < 2; i++) {
            if (sorted.get(i).getI() > sorted.get(i + 1).getI())  {
                isSorted = false;
                break;
            }
        }

        assertTrue(isSorted);
    }

}
