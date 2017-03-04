package reflection.lection12;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class A {
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public A() {}

    public A(int a) {
        this.a = a;
    }
}

// Field, Method, Constructor extends AccessableObject and implements Member
public class Reflection2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("reflection.lection12.A");
        A pa1 = null;
        A pa2 = null;

        try {
            pa1 = (A)c1.newInstance();

            Constructor<A> constructor = c1.getDeclaredConstructor(int.class);
            pa2 = constructor.newInstance(13);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(pa1.getA());
        System.out.println(pa2.getA());
    }
}
