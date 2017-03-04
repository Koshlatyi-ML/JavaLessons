package reflection.lection12;

import java.io.*;
import java.lang.reflect.Field;

interface MyInterface {
    void f();
}

class Adi {
    MyInterface myInterface;

    public void g(){
        myInterface.f();
    }
}

class B implements MyInterface {
    @Override
    public void f() {
        System.out.println("B implementation");
    }
}

class C implements MyInterface {
    @Override
    public void f() {
        System.out.println("C implementation");
    }
}

class Factory {
    public static Adi getInstance(String filename) throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchFieldException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        String[] strings = bufferedReader.readLine().split(":");

        Class aClass = Class.forName("reflection.lection12." + strings[0]);
        Adi pa = (Adi) aClass.newInstance();

        Field field = aClass.getDeclaredField(strings[1]);
        field.setAccessible(true);

        Class c = Class.forName("reflection.lection12." + strings[2]);
        Object o = c.newInstance();

        field.set(pa, o);

        return pa;
    }
}

public class DependencyInjection {
    public static void main(String[] args) {
        try {
            Adi pa = Factory.getInstance("congif.txt");
            pa.g();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
