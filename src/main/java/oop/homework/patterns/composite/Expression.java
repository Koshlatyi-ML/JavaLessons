package oop.homework.patterns.composite;

import java.util.Objects;

public class Expression implements Calculable {
    private Calculable leftChild;
    private Calculable rightChild;
    private Operation operation;

    private Expression(Calculable leftChild, Calculable rightChild,
                      Operation operation) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.operation = operation;
    }

    public static Expression createExpresion(Calculable leftChild,
                                             Calculable rightChild, Operation operation) {
        if (leftChild == null || rightChild == null
                || operation == null) {
            throw new NullPointerException();
        }

        return new Expression(leftChild, rightChild, operation);
    }

    @Override
    public int calculate() {
        return operation.perform(leftChild.calculate(),
                                 rightChild.calculate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return Objects.equals(leftChild, that.leftChild) &&
                Objects.equals(rightChild, that.rightChild) &&
                operation == that.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftChild, rightChild, operation);
    }
}
