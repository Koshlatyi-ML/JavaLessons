package reflection.lection12;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Operation {
    int f(int a, int b);
}

class Add implements Operation {
    @Override
    public int f(int a, int b) {
        return a + b;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Operation op;

    public MyInvocationHandler(Operation op) {
        this.op = op;
    }

    public Operation getInstance() {
        return (Operation) Proxy.newProxyInstance(op.getClass().getClassLoader(),
                                                  op.getClass().getInterfaces(),
                                                  this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("f")) {
            int a = (int) args[0] * 2;
            int b = (int) args[1] * 2;
            return method.invoke(op, a, b);
        }
        return method.invoke(op, args);
    }
}

public class Proxies {
    public static void main(String[] args) {
        Operation operation = new MyInvocationHandler(new Add()).getInstance();
        System.out.println(operation.f(10, 20));
    }
}
