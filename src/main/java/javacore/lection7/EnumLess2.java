package javacore.lection7;

enum Operation {
    PLUS {
        public int operation(int a, int b) {
            return a + b;
        }
    },

    MINUS {
        public int operation(int a, int b) {
            return a - b;
        }
    };

    public abstract int operation(int a, int b);
}

// equivalent code
abstract class Operation1 {
    public static final Operation1 PLUS = new Plus();
    public static final Operation1 MINUS = new Minus();

    abstract int operation(int a, int b);
}

class Plus extends Operation1 {
    @Override
    int operation(int a, int b) {
        return a + b;
    }
}

class Minus extends Operation1 {
    @Override
    int operation(int a, int b) {
        return a - b;
    }
}

public class EnumLess2 {
    public static void main(String[] args) {
        Operation e = Operation.PLUS;
        int res = e.operation(10, 20);

        // values -> array of constants
        for (Operation op : Operation.values()) {
            System.out.println(op.operation(10, 20));
        }

    }
}
