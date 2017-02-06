package main.java.module1.lection3;

interface IA {
    //automatically psf
    B pb = new B();

    // automatically "static"
    class B {
        int x = 10;
    }
}

public class InnerInInterface {
    public static void main(String[] args) {
        //non-final field in interface LOL
        IA.pb.x = 300;
        IA.pb.x = 42;
    }
}
