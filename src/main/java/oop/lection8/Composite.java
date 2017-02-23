package oop.lection8;

abstract class Component {
    abstract public int calculate();
}

class Number extends Component {
    int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}

class OperationPlus extends Component{
    Component left;
    Component rigth;

    public OperationPlus(Component left, Component rigth) {
        this.left = left;
        this.rigth = rigth;
    }

    @Override
    public int calculate() {
        return left.calculate() + rigth.calculate();
    }
}

class OperationMult extends Component{
    Component left;
    Component rigth;

    public OperationMult(Component left, Component rigth) {
        this.left = left;
        this.rigth = rigth;
    }

    @Override
    public int calculate() {
        return left.calculate() * rigth.calculate();
    }
}

class TreeFactory {
    public static Component getCalculateTree(/*String expression*/) {
        Component plus1 = new OperationPlus(new Number(1), new Number(2));
        Component mult1 = new OperationMult(plus1, new Number(3));
        Component mult2 = new OperationMult(new Number(4), new Number(5));
        Component calculateTree = new OperationPlus(mult1, mult2);

        return calculateTree;
    }
}

public class Composite {
    public static void main(String[] args) {
        Component c = TreeFactory.getCalculateTree();
        System.out.println(c.calculate());
    }
}
