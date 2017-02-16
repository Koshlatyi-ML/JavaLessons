package oop.lection8;

class A {
    int a;

    private A(int a) {
        this.a = a;
    }

    public static A getInstance(int a) {
        if (a == 0) {
            throw new IllegalArgumentException();
        }

        return new A(a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        A pa = A.getInstance(10);
    }
}
