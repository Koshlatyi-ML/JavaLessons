package multithread.lection13;

import java.util.stream.IntStream;

public class Multithreading1 {
    // Process doesn't do any job it only acquires RAM
    // Thread is executor of a code inside a process

    //Process hasn't access to the address namespace of another process

    //Thread-scheduler choose thread and gives him the quantum of ALU time
    //After scheduler puts it to the end of threads' queue

    //Two architectures: symmetric multiprocessing (shared address namespace - WORK IN TAKT)
    //                   cluster: distributed address namespaces - NOT WORK IN TAKT

    public static void main(String[] args) {
        System.out.println(IntStream.range(1, 10001).parallel().sum());

        SummThread summThread1 = new SummThread(1, 500000000);
        SummThread summThread2 = new SummThread(500000000, 1000000001);

        summThread1.start();
//        summThread1.start(); exception
        summThread2.start();

        // isFinished optimized to false
//        while (!summThread1.isFinished() || !summThread2.isFinished()) {
            // PREVENT FREEZING 0_0
//            System.out.println(summThread1.isFinished() + " " + summThread2.isFinished());
//        }

        try {
            // stop thread, where summThread was invoked
            summThread1.join();
            summThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long total = summThread1.getResult() + summThread2.getResult();
        System.out.println(total);
    }
}

class SummThread extends Thread {
    private int begin;
    private int end;
    private long result = 0;
    // Command to the constructor - DONT MAKE OPTIMIZATION
//    private volatile boolean isFinished = false;

    public SummThread(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public long getResult() {
        return result;
    }

//    public boolean isFinished() {
//        return isFinished;
//    }

    @Override
    public void run() {
        for (int i = begin; i < end; i++) {
            result += i;
        }
//        isFinished = true;
    }
}
