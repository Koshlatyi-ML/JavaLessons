package main.java.module1.lection4;

public class CloneIssue {
}

class B {
    int b;

    public int getB() {
        return b;
    }

    public B setB(int b) {
        this.b = b;
        return this;
    }
}

class A_clone {
    private B pb;

    public A_clone(B pb) {
        this.pb = pb;
    }

    public B getPb() {
        // error: we return reference to the private field object (NON-ENCAPSULATIVE)
        return pb;
    }

    public A_clone setPb(B pb) {
        this.pb = pb;
        return this;
    }
}
