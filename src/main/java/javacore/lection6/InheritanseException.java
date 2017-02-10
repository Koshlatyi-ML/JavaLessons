package javacore.lection6;

class MyException2 extends MyException {

}

class AA {
    public void f(int a) throws MyException{
        if (a == 0) {
            throw new MyException();
        }
    }
}

class BB extends AA{
    public void f(int a) throws MyException/*1*/{ //nothing, error, unchecked and exceptions  (see psvm)
                                             // which can be handled with: try {MyException}
        if (a == 0) {
            throw new MyException();
        }
    }
}

public class InheritanseException {
    public static AA g() {
        return new BB();
    }

    public static void main(String[] args) {
        AA pa = g();
        try {
            pa.f(0);
        } catch (MyException e) {
            // MyException1 can't be processed
            e.printStackTrace();
        }
    }
}
