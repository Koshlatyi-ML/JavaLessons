package main.java.module1.lection3;

interface F2 {
    void fA();
}

public class Lambda2 {
    public static void main(String[] args) {
        int c = 10;
        F2 pf = () -> {
            //c++ c must be final so we can't change it
            System.out.println("F " + (c + 1));
        };
    }
}
