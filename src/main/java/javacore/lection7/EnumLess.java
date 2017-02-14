package javacore.lection7;

// enum translates into abstract class
enum MyEnum {
    // enum elements should go first, else compile-time error
    RED(10),
    BLACK(20),
    WHITE(30);

    int a;
    static int b = 100;

    //non-private constructor is compile time error
    private MyEnum(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

public class EnumLess {
    public static void f(MyEnum s) {

    }

    public static void main(String[] args) {
        MyEnum e = MyEnum.BLACK;
        // 0, 1, 2 ...
        System.out.println(e.ordinal());
        // 10, 20, 30
        System.out.println(e.getA());
    }
}
