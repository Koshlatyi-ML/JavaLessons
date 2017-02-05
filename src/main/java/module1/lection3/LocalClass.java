package module1.lection3;

class LocalA {
    int aa = 40;
    public IC fA() {
        int a = 10;
        // doesn't have static
        // has access for all members (static & non-static)
        // if method static - only static fields
        class B implements IC { //implements need for access to B-class
            int b = 20;
            public void fB() {
                aa = 100;
                //a = 42; if a final (array?) or never changed is OK else !OK
            }
        }

        B pb = new B();
        return pb;
    }
}

interface IC {
    void fB();
}

public class LocalClass {
    public static void main(String[] args) {
        LocalA pa = new LocalA();
        IC o  = pa.fA();
        o.fB();


    }
}
