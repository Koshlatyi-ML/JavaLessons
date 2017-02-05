package module1.lection1;

public class Seminar {
    public static void main(String[] args) {
        // byte : {-128;127}
        // 1010 | 0100 -> 1110
        // d = 1 : {0001} d = d<<2

        // >>  10100110 -> 11010011 бит знака клонируется
        // >>> 10100110 -> 01010011 без учета знака

        byte a = 10;
        byte b = 20;
        // byte c = d + b; Error

        // but
        a++; // d++ -> byte d = (byte) (d + 1)

        int a1 = Integer.MAX_VALUE;
        byte b1 = (byte) a1; // -1 {11111111}

        int a2 = Integer.MIN_VALUE;
        a2 =- a2; //Integer.MIN_VALUE

        //byte->short...
        //long->float->double

        System.out.println(0.3 == 0.1+0.1+0.1); //false период в двоичной
        // 0.125 = (a * 2^-1) + (b * 2^-2) ... -> 0.5, 0.25, 0. 125
        // 0.1 бесконечный период
        double a3 = 2.3;
        double b3 = 2.4;
        double eps = 0.01;

        System.out.println(Math.abs(a3 - b3) < eps);

        System.out.println(1.0 / 0.0); // при работе с действ. числами НИКАКИХ Exception не бросается
        System.out.println(1.0 / -0.0);

        double x = 0.0/0.0;
        System.out.println(x != x); // true ЕДИНСТВЕННЫЙ СЛУЧАЙ в языке

        System.out.println(1/2); // 0.0

        //10.125 -> 1010.001 (точа до первой 1)-> 1.01001b+3
        //1 бит - знак, 8 бит - степенб, 23 бита - всё остальное (единицу можно не сохранять)

        // 10 + 0.1 + 0.01 + .. Правильно справа налево

        // Нельзя привести ничего к или из boolean
        boolean a4 = true;
        boolean b4 = false;
        if (a4 = b4) {} // statment == right part

        char ch = 's';
        //char -> int  NOR '<-'

        // 4 нормализированные формы юникода (пример о букве 'й')

        //разядность систесмы - размер который выделяется под адрес
        //в куске памяти что заполняет класс есть служебная часть(длинна куска класса, тип класса, лок)
        //                                        остальное поля класса

        // Heap : (old generation, young generation : (eden))
        // Unsafe adds extra heap memory, but GB DOESN'T EMPTY IT

        //Permanent generation - bytecode holder, memory for static fields holder
        //One classloader can load class only 1 time

        //Если локал. переменная не инициализ. то ПАМЯТИ ПОД НЕЁ НЕ ВЫДЕЛЕНО

        System.out.println("--------------------------------------");
        System.out.println(B.b);
        System.out.println(C.c);
    }
}

    class A {
        static int a = 10;
        static final int b = 50; //constants first in the queue
        static {
            a = 40;
        }
    }

class B {
    static int b = C.fC();
    public static int fB() {
        return  b + 1;
    }
}

class C {
    static int c = B.fB();
    public static int fC() {
        return  c + 1;
    }
}

class D {
    int d = 10;
    {
        d = 90; // Блоки нестатиеской инициализации переносятся в начало конструктора
    }
    public D(int d) { // public void module1.lection1.D(int d) method not a constructor
        d = 100;
    }
}

