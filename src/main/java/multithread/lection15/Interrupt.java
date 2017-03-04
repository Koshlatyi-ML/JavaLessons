package multithread.lection15;

class MyThread extends Thread {
    @Override
    public void run() {
        // Interrupted() resets flag to false also if it true
        while (!isInterrupted()) {
            System.out.println("Thread works");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // flag sets to false when exception has invoked (specific for sleep)
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
