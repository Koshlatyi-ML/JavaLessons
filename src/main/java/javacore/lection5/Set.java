package javacore.lection5;

import java.util.ArrayList;
import java.util.List;

class Table implements Comparable<Table> {
    int height;

    public Table(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Table other) {
        return this.height - other.height;
    }
}

class Chair implements Comparable<Chair> {
    int width;

    public Chair(int width) {
        this.width = width;
    }

    @Override
    public int compareTo(Chair other) {
        return this.width - other.width;
    }
}

class Armchair extends Chair { //can't implements Comparable<Armchair>
    public Armchair(int width) {
        super(width);
    }
}

interface Container<T extends Comparable<? super T>> extends Cloneable {
    Container<T> clone();

    boolean contains(T element);
    int size();

    T get(int index);
    void add(T element);
}

class MyArray<T extends Comparable<? super T>> implements Container<T> {
   List<T> elements = new ArrayList<T>();

   @Override
   public Container<T> clone() {
       Container<T> copy = new MyArray<T>();

       for (T element : elements) {
           copy.add(element);
       }

       return copy;
   }

    @Override
    public boolean contains(T element) {
        for (T t : elements) {
            if (t.compareTo(element) == 0) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public T get(int index) {
        return elements.get(index);
    }

    @Override
    public void add(T element) {
        elements.add(element);
    }
}

public class Set<T extends Comparable<? super T>> {
    Container<T> container;

    public Set(Container<T> container) {
        this.container = container;
    }

    public Set<T> union(Set<? extends T> other) {
        Set<T> result = new Set<T>(this.container.clone());

        for (int i = 0; i < this.container.size(); i++) {
            T element = other.container.get(i);

            if (!result.container.contains(element)) {
                result.container.add(element);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Container<Table> tableContainer = new MyArray<>();
        Table t1 = new Table(2);
        Table t2 = new Table(4);
        tableContainer.add(t1);
        tableContainer.add(t2);
        Set<Table> tableSet = new Set<>(tableContainer);

        Container<Chair> chairContainer = new MyArray<>();
        Chair c1 = new Chair(2);
        Chair c2 = new Chair(4);
        chairContainer.add(c1);
        chairContainer.add(c2);
        Set<Chair> chairSet = new Set<>(chairContainer);

        Container<Armchair> armchairContainer = new MyArray<>();
        Armchair a1 = new Armchair(2);
        Armchair a2 = new Armchair(4);
        armchairContainer.add(a1);
        armchairContainer.add(a2);
        Set<Armchair> armchairSet = new Set<>(armchairContainer);

//        tableSet.union(armchairSet);
//        tableSet.union(chairSet);
        tableSet.union(tableSet);

        chairSet.union(armchairSet);
//        armchairSet.union(chairSet);
    }
}
