package multithread.lection15;

class MyThread3 implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("active");
        }
    }
}

public class ThrGroup {
    public static void main(String[] args) {
        ThreadGroup papka = new ThreadGroup("PAPA");
        ThreadGroup threadGroup = new ThreadGroup(papka, "name");
        MyThread3 myThread = new MyThread3();
        Thread thread = new Thread(threadGroup, myThread);
        thread.start();
    }
}
