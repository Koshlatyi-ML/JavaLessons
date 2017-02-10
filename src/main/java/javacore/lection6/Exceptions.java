package javacore.lection6;

class MyException extends Exception {
}

class A {
    public void f(int a) {
        try {
            if (a == 0) {
                throw new MyException();
            }
        } catch (MyException e) {

        } catch (Exception e) {

        } finally {

        }
    }
}

public class Exceptions {
    public static void main(String[] args) {

        // correct would work a bit slowly - every time would be initialized new const
        for (final int i : new int[]{1, 2, 3}) {
            System.out.println(i + 1);
        }

        label:
        {
            break label; //EXITS FROM LABEL
        }

        new A().f(0);
    }
}
