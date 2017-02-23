package oop.lection10;

// this class takes new functionality
class Acceptor {
    public void accept(VISITOR v) {
        v.visit(this);
    }
}

interface VISITOR {
    void visit(Acceptor a);
}

// we want to add new features to the class without rewriting(recompiling)
public class Visitor implements VISITOR {
    public void visit(Acceptor a) {
        System.out.println("Visitor");
    }
}

class Main {
    public static void main(String[] args) {
        Acceptor acceptor = new Acceptor();
        VISITOR visitor = new Visitor();
        acceptor.accept(visitor);
    }
}
