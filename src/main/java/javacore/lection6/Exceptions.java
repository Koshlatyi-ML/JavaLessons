package javacore.lection6;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

class MyException extends Exception {
    int i;

    public MyException() {};

    public MyException(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

class MyException1 extends Exception {
    // You always need to define this type of constructor!!!
    public MyException1(Throwable cause) {
        super(cause);
    }
}

class A {
    public void f(int a) throws MyException {
//        try {
            if (a == 0) {
                throw new MyException(a);
            }
//        } catch (MyException e) {
//
//        } catch (Exception e) {
//
//        } finally {
//
//        }
    }
    public void f2(int a) throws MyException {
        try {
            if (a == 0 || a == 1) {
                throw new MyException(a);
            }
        } catch (MyException e) {
            if (e.getI() == 0) {
                throw e;
            }

            throw new RuntimeException(e);
        } finally {

        }
    }

    public void f3(int a) throws MyException1 {
        try {
            if (a == 0 || a == 1) {
                throw new MyException(a);
            }
        } catch (MyException e) {
            throw new MyException1(e);
        }
    }
}

public class Exceptions {
    public static void main(String[] args) {

        // correct would work a bit slowly - every time would be initialized new const
//        for (final int i : new int[]{1, 2, 3}) {
//            System.out.println(i + 1);
//        }

        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now().plusMonths(12)));

        label:
        {
            break label; //EXITS FROM LABEL
        }

        try {
            new A().f3(0);
        } catch (MyException1 e) {
            e.printStackTrace();
        }

//        Unchecked: Error & co + RuntimeException & co
//        All Error objects (OutOfMemory, etc...)  created in the start of JVM
    }
}
