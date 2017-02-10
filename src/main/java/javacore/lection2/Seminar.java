package main.java.module1.lection2;

interface IfaceA {
    int a = 10; //implicitly to "public final static"

//    void f(); //Implicitly to "public anstract"

    //FROM JAVA 8
    default void g() {

    }

    static void p() {

    }

    //Functional interface contains ONLY 1 ABSTRACT METHOD
    //                (amount of default and static isn't bounded)
}

class ClassB implements IfaceA {

    public void g() {

    }
}

// implementing 2 or more interfaces with ambiguous default methods restricted
final class ClassC extends ClassB implements IfaceA {
    // OK - looks "linear"(left to right): first in class
    public void f(){

    }
}


//final modifier set the class unextendable
class A {
    int a;

    A(){
        a = 10;
    }

    A(int a) {
        this.a = a;
    }

    int f() {
        System.out.println(super.equals(this));
        return a;
    }
}

class B extends A {
    int a;

    B() {
        this(10);
    }

    B(int b) {
        super(b);
        //super(123); compile time object
    }

    int f() {
        System.out.println(super.equals(this));
        return a + super.a /* search srazu in parent (uzually in local, in object then in parent)*/;
        // super.super isn't allowed, because middle object doesn't know about this
    }
}

class C extends B {
    public void g() {
        System.out.println(super.equals(this)); // <- true //TODO
    }
}


class D {
    D() {
        f(); // implicitly this == pd (invokeVirtual (this, f))
    }

    public void f() {
        System.out.println("D");
    }
}

class E extends D {

  /*
    E() {
        super(); <- B.this sends to the D()
    }
  */

    public void f() {
        System.out.println("E");
    }
}

   /*
    public A(A.this) {
        this.f()
    }

     public B(B.this) {
         super(this)
     }

     "this" from B sends to the A (because B can be casted to A)
  */

/*
    public static void main(String[] args) {
        D pd = new E();
    }
*/

  // Mechanism of virtualization isn't available for fields //TODO super in java

public class Seminar {
    // labs and projects in different branches, build & run in terminal

    //static means there is no this //TODO
    // Permanent generation has class-info(name, address)
    // classloader table(addres of class for static members) + virtual methods table(method and shift)
    // this has address of object in table
    //byte code implicitly adds class reference in unstatic method: f() -> f(A.this)

    //f(int a, int b) -> f$int$int in PG
    // compiler search for all methods with appropriate signatures, then
    // for all which he can call, then it chooses bet candidate

    //in heap memory is allocating only for non-static fields (fields is copying in hierarchies)
    //sometimes JVM moves object from heap to thread cache (stack)

    //static fields are the antipattern (only for singleton e.g.) (constants is OK)

    //наследование относится только К КЛАССАМ(тип) а не обьектам
    //полиморфизм относится только К ТИПАМ а не методам
    // (в PG  инфо о классе-родителе, в хипе просто переменные)

    //Compiler can't see the object (because in compile-time object doesn't exist)
    //Only JVM can see the object

    //Local methods stores in thread stack

    //package
    //protected (package and from childern)

    public static void main(String[] args) {
        // base class ALWAYS load before it children
        //compiler implicitly adds "extends Object"
        A pa = new A();
        B pb = new B();

        A a = new B(); // Full object B (with it all fields) but API from A
        a.f(); //B type method -> invokeVirtual(a, f)
               // if f() static -> invokeStatic(A, f)
               // if f() private & psvm in the same class -> invokeSpecial(a, f, A) (lookup only in this class)

        pa.f();
        pb.f(); //-> B.f(pb)

    }




}
