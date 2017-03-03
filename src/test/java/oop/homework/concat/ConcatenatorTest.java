package oop.homework.concat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ConcatenatorTest {
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

    @Test
    public void concatAndSortNull() throws Exception {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Concatenator<String> concatenator = new Concatenator<>();
        List<String> list3
                =  concatenator.concatAndSort(list1, list2, Comparator.naturalOrder());
        assertTrue(list3.isEmpty());
    }

    @Test
    public void concatAndSortSize() throws Exception {
        List<String> list1 = new ArrayList<>();
        list1.add("str1");
        list1.add("str2");
        list1.add("str3");

        List<String> list2 = new ArrayList<>();
        list1.add("str4");
        list1.add("str5");
        list1.add("str6");

        Concatenator<String> concatenator = new Concatenator<>();
        List<String> list3
                =  concatenator.concatAndSort(list1, list2, Comparator.naturalOrder());
        assertEquals(list1.size() + list2.size(), list3.size());
    }

    @Test
    public void concatAndSort() {
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

        boolean isSorted = true;
        for (int i = 0; i < 5; i++) {
            if (bases.get(i).getI() > bases.get(i + 1).getI()) {
                isSorted = false;
                break;
            }
        }

        assertTrue(isSorted);
    }

}