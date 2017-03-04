package multithread.lection15;

class MyThr extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("active");
        }
    }
}

public class Daemon {
    public static void main(String[] args) {
        MyThr thr = new MyThr();
        thr.setDaemon(true); // setDaemon only BEFORE start
        thr.start(); //Users thread
    }
}
