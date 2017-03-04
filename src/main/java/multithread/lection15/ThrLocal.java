package multithread.lection15;

class MyThread2 extends Thread {
    ThreadLocal<Integer> threadLocal;
    int value;

    public MyThread2(ThreadLocal<Integer> threadLocal, int value) {
        this.threadLocal = threadLocal;
        this.value = value;
    }

    @Override
    public void run() {
        this.threadLocal.set(value);
        System.out.println(threadLocal.get());
    }
}

public class ThrLocal {
    public static void main(String[] args) {
        // local var for thread (for example some sort of cache), but they
        // stored in the heap not the local stack
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        MyThread2 thr1 = new MyThread2(threadLocal, 100);
        MyThread2 thr2 = new MyThread2(threadLocal, 200);
        thr1.start();
        thr2.start();
    }
}
