package multithread.lection15;

class MyHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
    }
}

class MYthread extends Thread {
    @Override
    public void run() {
        if (true) {
            throw new RuntimeException();
        }
    }
}

public class Exceptions {
    public static void main(String[] args) {
        MYthread myThread = new MYthread();
        myThread.start(); //in web project create queue for exceptions
    }
}
