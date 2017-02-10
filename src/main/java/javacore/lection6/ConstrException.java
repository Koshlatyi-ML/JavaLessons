package javacore.lection6;

import java.io.Closeable;
import java.io.IOException;

class A2 {
    public static A2 instance;
    int b;
    int c;
    public A2(int a) throws Exception {
        instance = this;
        b = 10;

        if (a == 0) {
            throw new Exception(); //reason why we shouldn't throw exception in constructors
        }

        c = a;
    }
}

class A3 implements Closeable {
    public void f(int a) {
        if (a == 0) {
            throw new RuntimeException();
        }
    }

    @Override
    public void close() {
        System.out.println("! close !");
    }
}

public class ConstrException {
    public static void main(String[] args) {
        A2 pa = null;

        try {
            pa = new A2(0);
        } catch (Exception e) {
        }

        System.out.println(pa); //null
        System.out.println(pa.instance); // not fully initialized data, GC can't collect it

//    ------------------------------------------------------------------------------------------
//    ------------------------------------------------------------------------------------------

        A3 p2 = new A3();
        try {
            p2.f(0);
        } finally {
            /*see also try-with-resources*/
            p2.close();
        }

        try(A3 p3 = new A3()) { //equals finally{p3.close()}
            p3.f(0);
        }
    }
}
