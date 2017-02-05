package module1.lection3;

interface F {
    void fA(int a, int b);
}

class B {
    public static void fB(int a, int b) {
        System.out.println(a - b);
    }
}

class FC {
    public void fC(int a, int b) {
        System.out.println(a * b);
    }
}

public class Lambda {
    public static void main(String[] args) {
        // There would be error if interface is not functional
        F pf1 = (a, b) -> System.out.println("I'm the lambda " + (a + b));

        pf1.fA(19, 96);

        class Noname implements F {
            @Override
            public void fA(int a, int b) {
                System.out.println("I'm the translation of lambda" + (a + b));
            }
        }
        F pf2 = new Noname();
        pf2.fA(19, 96);

        //////////////////////////////////////////////////////////////////////////////////

        F pf3 = B::fB; // for static
        pf3.fA(19, 96);

        class Noname2 implements F{
            @Override
            public void fA(int a, int b) {
                B.fB(a, b);
            }
        }
        F pf4 = new Noname2();
        pf4.fA(10, 20);

        ///////////////////////////////////////////////////////////////////////////////////

        FC pc = new FC();
        F pf5 = pc::fC; // non-static

        class Noname3 implements F{
            public FC pc;

            Noname3(FC pc) {
                this.pc = pc;
            }

            @Override
            public void fA(int a, int b) {
                pc.fC(a, b);
            }
        }
        F pf6 = new Noname3(pc);
        pf6.fA(10, 20);
    }
}
