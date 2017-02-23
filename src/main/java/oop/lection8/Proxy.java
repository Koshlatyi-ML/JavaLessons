package oop.lection8;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

abstract class COmponent {
    abstract public int operation(int a, int b);
}

class Sum extends COmponent {
    @Override
    public int operation(int a, int b) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a + b;
    }
}

class ProxySum extends COmponent {
    COmponent cOmponent = new Sum();

    Map<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

    @Override
    public int operation(int a, int b) {
        Pair<Integer, Integer> pair = new Pair<>(a , b);
        Integer result = cache.get(pair);

        if (result == null) {
            result = cOmponent.operation(a, b);
            cache.put(pair, result);
        }

        return result;
    }
}



// Prevent heavy loading || simulate behaviour || caching
public class Proxy {
    public static void main(String[] args) {
        COmponent c = new ProxySum();
        c.operation(10, 20);
        System.out.println("Slow");
        c.operation(10, 20);
        System.out.println("Fast");
    }
}

