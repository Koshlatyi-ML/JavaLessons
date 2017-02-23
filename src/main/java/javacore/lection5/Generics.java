package javacore.lection5;

// В метод параметры передаются только по значению (либо копируется примтив,
// либо копируется адрес ссылки на объект)

import java.util.Objects;

//switch - case принимает только литералы и объекты String, другие объекты: НЕТ
class A<T /*,U*/> { //<- класс-шаблон (template class)
    T a;
    /*U b*/;

    public T getA() {
        return a;
    }

    public A setA(T a) {
        this.a = a;
        return this;
    }
}

class B {
    Integer b;

    public <T> B(T b) {
        this.b = (Integer) b;
    }

    public Integer getB() {
        return b;
    }

    public <T> void setB(T b) {
        this.b = (Integer) b;
    }
}

interface IA {
    void f();
}
interface IB {
    void g();
}

//only extends, word "imlements" is restricted
class C<T extends IA & IB/*.inte..*/ , B/*another parameter*/ > {
    T a;

    public void g() {
        a.f(); //because of "extends IA"
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

interface IC extends IA {
    @Override
    void f();
}

public class Generics {
    public static void main(String[] args) {
        //JVM load only one class, where T would be Object
        A<Integer> pa = new A<>();
        A<Double> pa1 = new A<>();
                             // How compiler implements:
        int res = pa.getA(); // (Integer) pa.getA() <- SLOW
        pa.setA(100);        // (Integer) 100       <- SLOW

        B pb = new /*<Object>*/ B(20); // see below (Object is OK IntelliJ is too smart =)
        pb.<Integer>setB(100); // if do not write, type automatically inferred from value

//        C<IC> pc = new C<IC>();
    }
}


