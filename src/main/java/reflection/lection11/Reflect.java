package reflection.lection11;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class A {
    private int value;

    public A() {
    }

    public A(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException,
            NoSuchFieldException, IllegalAccessException {
        A pa = new A();

        Class c1 = Class.forName("reflection.lection11.A");
        Class c2 = A.class;
        Class c3 = pa.getClass();

        System.out.println(c1 == c2 && c2 == c3);

        Field field = c1.getDeclaredField("value");
        System.out.println(field.getType());
        System.out.println(Modifier.toString(field.getModifiers()));

        field.setAccessible(true);
        field.set(pa, 666);
    }
}
