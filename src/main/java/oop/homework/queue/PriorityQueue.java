package oop.homework.queue;

import oop.homework.queue.compare.ComparableStrategy;
import oop.homework.queue.compare.ComparatorStrategy;
import oop.homework.queue.compare.ComparisonStrategy;

import java.util.*;

public class PriorityQueue<T> {
    private Object[] heap;
    private int size;
    private Comparator<? super T> comparator;
    private ComparisonStrategy strategy;

    private final int DEFAULT_SIZE = 11;

    public PriorityQueue() {
        this(null);
    }

    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new Object[DEFAULT_SIZE];
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++)
            heap[i] = null;
        size = 0;
    }

    public boolean tryAdd(T item) {
        if (item == null)
            return false;

        if (size >= heap.length)
            resizeHeap();

        size += 1;
        heap[size - 1] = item;

        if (size > 1) {
            siftUp(size - 1);
        }

        return true;
    }

    private void resizeHeap() {
        if (heap.length == Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        }
        int oldCapacity = heap.length;
        int newCapacity = oldCapacity * 2;

        if (newCapacity < 0) {
            newCapacity = Integer.MAX_VALUE;
        }

        heap = Arrays.copyOf(heap, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (size == 0) ? null : (T) heap[0];
    }

    @SuppressWarnings("unchecked")
    public T poll() {
        if (size == 0)
            return null;

        T result = (T) heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        if (size != 0)
            siftDown(0);

        return result;
    }

    public boolean tryRemove(Object o) {
        int i = indexOf(o);
        if (i == -1)
            return false;
        else {
            removeAt(i);
            return true;
        }
    }

    private void removeAt(int i) {
        if (i == size - 1) { // removed last element
            size--;
            heap[i] = null;
        }
        else {
            heap[i] = heap[size - 1];
            heap[size - 1] = null;
            size--;
            siftDown(i);
        }
    }

    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++)
                if (o.equals(heap[i]))
                    return i;
        }
        return -1;
    }

    private void siftUp(int i) {
        setStrategy();

        Object item = heap[i];
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            Object parentItem = heap[parentIndex];
            if (strategy.compare(item, parentItem) >= 0)
                break;
            heap[i] = parentItem;
            i = parentIndex;
        }
        heap[i] = item;
    }

    private void siftDown(int i) {
        setStrategy();

        Object item = heap[0];
        while (2 * i + 1 < size) {
            int left = i * 2 + 1;
            int right = left + 1;

            int leastIndex = left; // assume left child is least
            if (right < size && strategy.compare(heap[right], heap[leastIndex]) < 0) {
                leastIndex = right;
            }

            Object least = heap[leastIndex];

            if (strategy.compare(item, least) <= 0)
                break;

            heap[i] = least;
            i = leastIndex;
        }
        heap[i] = item;
    }


    @SuppressWarnings("unchecked")
    private void setStrategy() {
        if (comparator != null) {
            strategy = new ComparatorStrategy(comparator);
        } else {
            strategy = new ComparableStrategy();
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        Random rand = new Random();
        for(int i=0; i<7; i++){
            integerPriorityQueue.tryAdd(new Integer(rand.nextInt(100)));
        }
        for(int i=0;i<7;i++){
            Integer in = integerPriorityQueue.poll();
            System.out.println("Обрабатываем Integer:"+in);
        }

        //Пример PriorityQueue с компаратором
        PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(idComparator);
        addDataToQueue(customerPriorityQueue);

        pollDataFromQueue(customerPriorityQueue);

    }

    //Анонимный класс компаратора
    public static Comparator<Customer> idComparator = new Comparator<Customer>(){

        @Override
        public int compare(Customer c1, Customer c2) {
            return (int) (c1.getId() - c2.getId());
        }
    };

    // служебный метод добавления элементов в очередь
    private static void addDataToQueue(PriorityQueue<Customer> customerPriorityQueue) {
        Random rand = new Random();
        for(int i=0; i<7; i++){
            int id = rand.nextInt(100);
            customerPriorityQueue.tryAdd(new Customer(id, "Pankaj "+id));
        }
    }

    //служебный метод для обработки данных очереди
    private static void pollDataFromQueue(PriorityQueue<Customer> customerPriorityQueue) {
        while(true){
            Customer cust = customerPriorityQueue.poll();
            if(cust == null) break;
            System.out.println("Обработка клиента с id=" + cust.getId());
        }
    }

    static class Customer {

        private int id;
        private String name;

        public Customer(int i, String n){
            this.id=i;
            this.name=n;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

    }
}
