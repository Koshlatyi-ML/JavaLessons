package javacore.lection5;

import java.util.ArrayList;

class A2<T> {
    T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

class B2{

}

class C2 extends B2{

}


public class Generic2 {
    public static void f(ArrayList<?> pa) {
//        it mentions that we would only write and delete
    }

    public static void f(A2<? super/*extends*/ B2> pa) {
//        it mentions that we would only write and delete
        C2 pc = new C2();
        pa.setA(pc); //we can use writers for classes upper tha super
    }

    //  "super" available only for wildcard
//    public static void f(A2<? extends B2> pa) {
//        it mentions that nothing would be written new
//        C2 pc = new C2();
//        /*pa.setA(pc);*/ //we can use writers for classes upper tha super
//    }

    public static void main(String[] args) {
//         ? can be casted to any type, but nothing can be casted to ?
        A2<?> pa = new A2<>();
//        pa.setA(12); - doesn't work because of we can't cast arg to ?

        A2<B> pa1 = new A2<>(); //we can initialize var as usually
//        f(pa);                  // but there nothing would be rewrited
    }
}
