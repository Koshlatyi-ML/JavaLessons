package oop.lection10;

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
    //toolkit for processing with the end of list (ArrayList can call capacity resizing)

    //PriorityQueue based on binary tree, comparation not only on equals
    //by default has memory for 11 elements

    //Map isn't implements Collection<T> beacause it hasn't iterator

}
