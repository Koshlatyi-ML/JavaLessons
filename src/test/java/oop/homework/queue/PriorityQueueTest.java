package oop.homework.queue;

import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.Assert.*;

public class PriorityQueueTest {
    @Test
    public void sizeZero() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        assertEquals(0, priorityQueue.size());
    }

    @Test
    public void size() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.tryAdd("stroka");
        priorityQueue.tryAdd("another");

        assertEquals(2, priorityQueue.size());
    }

    @Test
    public void clear() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.tryAdd("stroka");
        priorityQueue.tryAdd("another");

        priorityQueue.clear();

        assertEquals(0, priorityQueue.size());
    }

    @Test
    public void tryAddNull() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        assertFalse(priorityQueue.tryAdd(null));
    }

    @Test
    public void tryAdd() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        String input = "input";

        priorityQueue.tryAdd(input);

        assertEquals(input, priorityQueue.peek());
    }

    @Test
    public void poll() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        String input = "input";

        priorityQueue.tryAdd(input);

        assertEquals(input, priorityQueue.poll());
        assertEquals(0, priorityQueue.size());
    }

    @Test
    public void tryRemoveFalse() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        String input = "input";

        priorityQueue.tryAdd(input);

        assertFalse(priorityQueue.tryRemove("lalala"));
    }

    @Test
    public void tryRemoveTrue() throws Exception {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        String input = "input";

        priorityQueue.tryAdd(input);
        priorityQueue.tryAdd("str1");
        priorityQueue.tryAdd("str2");
        priorityQueue.tryAdd("str3");

        assertTrue(priorityQueue.tryRemove("input"));
        assertEquals(3, priorityQueue.size());

        boolean isRemoved = true;
        for (int i = 0; i < 3; i++) {
            if (priorityQueue.poll().equals(input)) {
                isRemoved = false;
                break;
            }
        }

        assertTrue(isRemoved);
    }

    @Test
    public void queueBehaviourComparable() {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        Random rand = new Random();
        for(int i=0; i<7; i++){
            integerPriorityQueue.tryAdd(new Integer(rand.nextInt(100)));
        }

        boolean isHigherPriority = true;
        Integer first = integerPriorityQueue.poll();
        Integer next = null;

        for(int i=0;i<6;i++){
            next = integerPriorityQueue.poll();
            if(first > next) {
                isHigherPriority = false;
                break;
            }

            first = next;
        }
    }

    @Test(expected = ClassCastException.class)
    public void queueNonComparable() {
        PriorityQueue<Base> integerPriorityQueue = new PriorityQueue<>();
        Random rand = new Random();
        for(int i=0; i<2; i++){
            integerPriorityQueue.tryAdd(new Base(new Integer(rand.nextInt(100))));
        }
    }

    @Test(expected = ClassCastException.class)
    public void queueComparator() {
        PriorityQueue<Base> integerPriorityQueue = new PriorityQueue<>();
        Random rand = new Random();
        for(int i=0; i<7; i++){
            integerPriorityQueue.tryAdd(new Base(new Integer(rand.nextInt(100))));
        }
        for(int i=0; i<7; i++){
            integerPriorityQueue.tryAdd(new Derive1(new Integer(rand.nextInt(100)),
                                                    new Double(rand.nextDouble())));
        }

        boolean isHigherPriority = true;
        Base first = integerPriorityQueue.poll();
        Base next = null;

        for(int i=0;i<6;i++){
            next = integerPriorityQueue.poll();
            if(first.getI() > next.getI()) {
                isHigherPriority = false;
                break;
            }

            first = next;
        }

    }

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

    class Derive1 extends Base {
        double d;

        public Derive1(int i, double d) {
            super(i);
            this.d = d;
        }
    }
}