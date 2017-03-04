package oop.homework.patterns.composite;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

public class CalculableFactory {

    private final Map<String, Operation> operationMap = new HashMap<>();
    private final Map<String, Integer> precedenceMap = new HashMap<>();
    {
        operationMap.put("+", Operation.ADDITION);
        operationMap.put("*", Operation.MULTIPLICATION);
        precedenceMap.put("+", 2);
        precedenceMap.put("*", 1);
    }

    private final static CalculableFactory INSTANCE = new CalculableFactory();
    public static CalculableFactory getInstance() {
        return INSTANCE;
    }

    private CalculableFactory(){}

    public Calculable parseCalculable(String expression) {
        expression = expression.replaceAll(" ", "");

        Deque<Calculable> tree = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();

        String token = null;
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                try {
                    token = String.valueOf(NumberFormat.getIntegerInstance()
                            .parse(expression.substring(i)).intValue());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                    i += token.length() - 1;
            } else {
                token = String.valueOf(expression.charAt(i));
            }

            shuntingYardScheme(token, tree, stack);
        }
        emptyStack(tree, stack);
        return tree.pop();
    }

    private void shuntingYardScheme(String token, Deque<Calculable> tree,
                            Deque<String> stack) {
        if (token.matches("\\d+")) {
            tree.add(new Number(Integer.valueOf(token)));
        } else if ("(".equals(token)) {
            stack.push(token);
        } else if (")".equals(token)) {
            parseRightParenthesis(tree, stack);
        } else if (operationMap.keySet().contains(token)) {
            parseOperation(token, tree, stack);
        } else {
            throw new IllegalArgumentException("Illegal token");
        }
    }

    private void parseRightParenthesis(Deque<Calculable> tree,
                                       Deque<String> stack) {
        String top = stack.pop();
        while (!"(".equals(top)) {
            if (stack.size() == 0) {
                throw new IllegalArgumentException("There are " +
                        "mismatched parentheses");
            }

            createExpression(top, tree);
            top = stack.pop();
        }
        // if left parenthesis has been found no exceptions would be thrown
    }

    private void parseOperation(String token, Deque<Calculable> tree,
                                Deque<String> stack) {
        String top = stack.peek();
        while (operationMap.keySet().contains(top)
                && precedenceMap.get(token) <= precedenceMap.get(top)) {

            createExpression(stack.pop(), tree);
            top = stack.peek();
        }
        stack.push(token);
    }

    private void emptyStack(Deque<Calculable> tree, Deque<String> stack) {
        String top;
        while (stack.size() > 0) {
            top = stack.pop();
            if ("(".equals(top)) {
                throw new IllegalArgumentException("Mismatched parenthesis");
            }
            createExpression(top, tree);
        }

        if (tree.size() > 1) {
            throw new IllegalArgumentException();
        }
    }

    private void createExpression(String top, Deque<Calculable> tree) {
        if (tree.size() < 2) {
            throw new IllegalArgumentException("Missed operand");
        }

        Calculable rigthChild = tree.pop();
        Calculable leftChild = tree.pop();
        tree.push(Expression.createExpresion(leftChild, rigthChild,
                                             operationMap.get(top)));
    }
}
