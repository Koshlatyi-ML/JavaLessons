package multithread.lection14;

class MyThread extends Thread {
    Object object1;
    Object object2;
    int time;

    public MyThread(Object object1, Object object2, int time) {
        this.object1 = object1;
        this.object2 = object2;
        this.time = time;
    }

    @Override
    public void run() {
        synchronized (object1) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {}
        }
    }
}

//Different threads acquired their own objects and then, without releasing they want
// acquire another object

//Livelock - simultaneous releasing & acquiring
public class Deadlock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new MyThread(o1, o2, 1000);
        Thread t2 = new MyThread(o2, o1, 100);

        t1.start();
        t2.start();
    }
}
