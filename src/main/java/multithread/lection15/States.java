package multithread.lection15;

class MyTHread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class States {
    public static void main(String[] args) throws InterruptedException {
        MyTHread myThread = new MyTHread();
        System.out.println(myThread.getState()); // NEW - created, not started yet
        myThread.start();
        System.out.println(myThread.getState()); // RUNNABLE - created, and started
        Thread.sleep(100);
        System.out.println(myThread.getState()); // TIMED_WAITING - thread is sleeping
        Thread.sleep(2500);
        System.out.println(myThread.getState() == Thread.State.BLOCKED); // TERMINATED - finished
                                                 // WAITING - wait() in synchronized block
                                                 // BLOCKED - thread wait for releasing of the lock
    }
}
