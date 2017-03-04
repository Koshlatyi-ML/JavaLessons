package oop.homework.patterns.composite;

public class Calculator {
    private static CalculableFactory factory = CalculableFactory.getInstance();

    public static double solve(String expression) {
        return factory.parseCalculable(expression).calculate();
    }
}
