package main.java.module1.lection3;

class AA {
    private int a = 10;
    private static int aa = 20;

    // has 2 "this" (AA & B)
    // in the heap B-class has reference to class A inside
    //              - so class B is instantiating after class A
    class B {
        private int b = 30;

        public void fB() {
            AA.this.a = 300;
            B.this.b = 50;
        }
    }

    public void fA() {
        B pB = this.new B();
        pB.fB();
    }
}

// compiler needs guaranties that AA-class instance would exist
class CC extends AA.B {
    //static AA pa = new AA(); or this way
    public CC(AA pa) {
        // super of class B not AA beacuse we extends AA.{!B!} //todo
        pa.super(); // after that error would disappear
    }
}

// only IF REALLY NECESSARY
public class Inner {
    //AA.B pb = new AA.B(); error because there is no A object
    public static void main(String[] args) {
        AA pa = new AA();
        AA.B pb = pa.new B();
        CC с = new CC(pa);
        ((AnonC) pa).fC();
    }
}
