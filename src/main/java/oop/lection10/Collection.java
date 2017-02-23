package oop.lection10;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Collection {
    //ArrayList<>() allocates memory for 10 elements,
    //when capacity overflows allocate capacity *= 3/2 + 1
    //(new array is creating and copy old array to the new System.arraycopy)
    //insert new element -> shift array and arraycopy
    //delete -> call arraycopy of index - 1
    //insert/add/delete/find by index[we has addres of begin and index*64bit] O(1)
    //find by object 0(n)

    //LinkedList has [first; last], each node has [next; prev]
    //Add first, Add last O(1), Add O(n)
    //LinkedList is good for queues, because it has more convenient
    //toolkit for processing with the end of list (ArrayList CAN CALL RESIZING)!!!

    //PriorityQueue based on binary tree, comparation not only on equals
    //by default has memory for 11 elements

    //Map isn't implements Collection<T> beacause it hasn't iterator
    //Default capacity = 16 (*= 2), loadFactor (elements / free space)
    //put -> fast check is key == null -> hashcode(key) -> hash(result)
    // -> find index for hash -> put element {final int hash; K,V; next}
    //put(null, null) -> hash == 0 -> put to 0 index

    //try to make keys immutable

    //Red-Black tree (black is root, red can't has red child,
    // route to any leaf takes same number of black nodes)
}


class A {
    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof A)) return false;
        A a = (A) o;
        return getValue() == a.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}

class B {
    public static void main(String[] args) {
        Map<A, Integer> map = new HashMap<>();
        A pa = new A();
        pa.setValue(12);
        map.put(pa, 100);
        System.out.println(map.get(pa)); //100
        pa.setValue(25);
        System.out.println(map.get(pa)); //null
        pa.setValue(12);
        System.out.println(map.get(pa)); //100
    }
}