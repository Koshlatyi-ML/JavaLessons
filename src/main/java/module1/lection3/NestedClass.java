package module1.lection3;


class A {
    private int a = 10;
    private static int aa = 20;

    // can be child of some class (even A-class)
    static class B {
        private int b = 30;
        private static int bb = 40;

        //has access only to static
        public void fB() {
            aa = 15;
        }
    }

    public void fA() {
        // has access only to static (private fields too)
        B.bb = 50;
        // hass access for non-static (private fields too)
        B pB = new B();
        pB.b = 35;
    }
}

// class C does not inherits access for A-class fields
class C extends A.B {
    public void fC() {
        //A.aa = 42; compile-time error
    }
}

public class NestedClass {
    //Inner classes (static & NON-STATIC)
    // for composite relations (window & scrollbar - scrollbar used only in context of window)
    public static void main(String[] args) {
        A.B p = new A.B();
    }
}
