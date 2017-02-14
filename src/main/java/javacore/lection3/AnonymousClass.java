package javacore.lection3;

import java.util.ArrayList;

interface AnonC {
    void fC();
}

class AnonA {
    public void fA() {
        AnonC pc = new AnonC() {
            @Override
            public void fC() {
                System.out.println("C");
            }
        };

        pc.fC();
    }
}

class A1 {
    public void fA() {
        class Noname implements AnonC{
            @Override
            public void fC() {
                System.out.println("noname");
            }
        }

        AnonC pc = new Noname();
        pc.fC();
    }
}

//anonymous class not only local
class D {
    AnonC pc = new AnonC() {
        @Override
        public void fC() {
            System.out.println("inner");
        }
    };
}

public class AnonymousClass {
    public static void main(String[] args) {
        //double brace
        // first braces: anon class inherited ArrayList
        // second braces: initializaton block
        ArrayList a1 = new ArrayList(){{
                add(10);
                add(20);
                add(30);
        }};

        class Noname extends ArrayList {
            {
                super.add(10);
                super.add(20);
                super.add(30);
            }
        }
        ArrayList a2 = new Noname();
    }
}
