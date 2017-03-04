package oop.homework.patterns.composite;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

@PrepareForTest(CalculableFactory.class)
public class CalculableFactoryTest {
    private static final CalculableFactory tested = CalculableFactory.getInstance();
    private static Method createExpression;
    private static Method parseOperatiot;
    private static Method parseRightParenthesis;
    private static Method shuntingYard;
    private static Method emptyStack;
    private Deque<Calculable> defaultTree = new LinkedList<>();

    @BeforeClass
    public static void initMethods() throws NoSuchMethodException {
        final Class<CalculableFactory> factoryClass = CalculableFactory.class;

        createExpression = factoryClass.getDeclaredMethod(
                "createExpression", String.class, Deque.class);
        parseOperatiot = factoryClass.getDeclaredMethod(
                "parseOperation", String.class, Deque.class, Deque.class);
        parseRightParenthesis = factoryClass.getDeclaredMethod(
                "parseRightParenthesis", Deque.class, Deque.class);
        shuntingYard = factoryClass.getDeclaredMethod(
                "shuntingYardScheme", String.class, Deque.class, Deque.class);
        emptyStack = factoryClass.getDeclaredMethod(
                "emptyStack", Deque.class, Deque.class);

        createExpression.setAccessible(true);
        parseOperatiot.setAccessible(true);
        parseRightParenthesis.setAccessible(true);
        shuntingYard.setAccessible(true);
        emptyStack.setAccessible(true);
    }

    @Before
    public void initDefaults() {
        Calculable one = new Number(1);
        Calculable two = new Number(2);
        Calculable left = Expression.createExpresion(one, two,
                Operation.ADDITION);
        Calculable right = new Number(3);

        defaultTree.push(new Number(1));
        defaultTree.push(new Number(1));
        defaultTree.push(left);
        defaultTree.push(right);
    }

    @Test
    public void createExpression() throws Exception{
        Calculable one = new Number(1);
        Calculable two = new Number(2);
        Calculable left = Expression.createExpresion(one, two,
                Operation.ADDITION);
        Calculable right = new Number(3);

        createExpression.invoke(tested, "*", defaultTree);

        assertEquals(3, defaultTree.size());

        Calculable desired = Expression.createExpresion(left,
                right, Operation.MULTIPLICATION);
        assertEquals(desired, defaultTree.poll());
    }

    @Test
    public void createExpressionNoSuchElementsInTree() {
        Calculable one = new Number(1);

        Deque<Calculable> tree = new LinkedList<Calculable>() {{
            push(one);
        }};

        try {
            createExpression.invoke(tested, "*", tree);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    public void parseOperationEmptyStackStack() throws Exception{
        Deque<String> emptyStack = new LinkedList<>();
        parseOperatiot.invoke(tested, "+", defaultTree, emptyStack);

        Deque<String> desired = new LinkedList<String>(){{
            push("+");
        }};

        assertEquals(desired, emptyStack);
    }

    @Test
    public void parseOperationEmptyStackTree() throws Exception{
        Deque<String> emptyStack = new LinkedList<>();
        Deque<Calculable> desired = new LinkedList<>(defaultTree);
        parseOperatiot.invoke(tested, "+", defaultTree, emptyStack);
        assertEquals(desired, defaultTree);
    }

    @Test
    public void parseOperationHighPrecedenceTree() throws Exception{
        Deque<String> stack = new LinkedList<String>(){{
                push("*");
                push("*");
            }};
        Deque<Calculable> desired = new LinkedList<>(defaultTree);
        parseOperatiot.invoke(tested, "+", defaultTree, stack);
        assertEquals(desired, defaultTree);
    }

    @Test
    public void parseOperationHighPrecedenceStack() throws Exception{
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("*");
        }};

        parseOperatiot.invoke(tested, "+", defaultTree, stack);

        Deque<String> desired = new LinkedList<String>(){{
            push("*");
            push("*");
            push("+");
        }};

        assertEquals(desired, stack);
    }

    @Test
    public void parseOperationLowPrecedenceStack() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("*");
            push("+");
        }};

        parseOperatiot.invoke(tested, "*", defaultTree, stack);

        Deque<String> desired = new LinkedList<String>(){{
            push("*");
        }};

        assertEquals(desired, stack);
    }

    @Test
    public void parseOperationLowPrecedenceTree() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("+");
        }};

        Deque<Calculable> desired = new LinkedList<>(defaultTree);
        createExpression.invoke(tested, "+", desired);
        createExpression.invoke(tested, "*", desired);

        parseOperatiot.invoke(tested, "*", defaultTree, stack);

        assertEquals(desired, defaultTree);
    }

    @Test
    public void parseRightParenthesisNoLeftParenthesis() {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("+");
        }};

        try {
            parseRightParenthesis.invoke(tested, defaultTree, stack);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    public void parseRightParenthesisStack() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("(");
            push("+");
        }};

        parseRightParenthesis.invoke(tested, defaultTree, stack);

        Deque<String> desired = new LinkedList<String>(){{
            push("*");
        }};

        assertEquals(desired, stack);
    }

    @Test
    public void parseRightParenthesisTree() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("(");
            push("+");
        }};

        Deque<Calculable> tree = new LinkedList<Calculable>(){{
            push(new Number(1));
            push(new Number(1));
        }};

        parseRightParenthesis.invoke(tested, tree, stack);

        Deque<Calculable> desired = new LinkedList<Calculable>(){{
            push(Expression.createExpresion(new Number(1), new Number(1),
                    Operation.ADDITION));
        }};

        assertEquals(desired, tree);
    }

    @Test
    public void shuntingYardWrongToken() {
        Deque<String> emptyStack = new LinkedList<>();
        try {
            shuntingYard.invoke(tested, "-", defaultTree, emptyStack);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    public void emptyStackFoundLeftParenthesis() {
        Deque<String> stack = new LinkedList<String>(){{
            push("(");
        }};
        try {
            emptyStack.invoke(tested, defaultTree, stack);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    public void emptyStackLoseNode(){
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("+");
        }};

        try {
            emptyStack.invoke(tested, defaultTree, stack);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            assertEquals(IllegalArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    public void emptyStackStackSize() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("*");
            push("+");
        }};

        emptyStack.invoke(tested, defaultTree, stack);
        assertEquals(0, stack.size());
    }

    @Test
    public void emptyStackTree() throws Exception {
        Deque<String> stack = new LinkedList<String>(){{
            push("*");
            push("*");
            push("+");
        }};

        Deque<Calculable> desired = new LinkedList<>(defaultTree);
        createExpression.invoke(tested, "+", desired);
        createExpression.invoke(tested, "*", desired);
        createExpression.invoke(tested, "*", desired);

        emptyStack.invoke(tested, defaultTree, stack);

        assertEquals(desired, defaultTree);
    }

    @Test(expected = NullPointerException.class)
    public void parseCalculableNull() throws Exception {
        tested.parseCalculable(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseCalculableUnclosedLeftParenthesis() throws Exception {
        tested.parseCalculable("((1 * 2)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseCalculableUnclosedRightParenthesis() throws Exception {
        tested.parseCalculable("((1 * 2)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseCalculableIllegalNum() throws Exception {
        tested.parseCalculable("(1 * 2)2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseCalculableIllegalOper() throws Exception {
        tested.parseCalculable("(1 *+ 2)");
    }

    @Test
    public void parseCalculableSingleDigitNums() throws Exception {
        int testedResult = tested.parseCalculable("(3+7) * 4 * (0 + 2*5)").calculate();
        assertEquals(400, testedResult);
    }

    @Test
    public void parseCalculableMultiDigitNums() throws Exception {
        int testedResult = tested.parseCalculable("10").calculate();
        assertEquals(10, testedResult);
    }
}
