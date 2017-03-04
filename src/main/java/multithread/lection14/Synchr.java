package multithread.lection14;

import java.util.LinkedList;
import java.util.Queue;

class Producer extends Thread {
    private Queue<Object> queue;
    String name;

    public Producer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            // Every class has a lock (bit field) it means that this class has captured
            synchronized (queue) { // We can't lock method, we locks only object
                // if lock in the queue == 1 then wait, otherwise it sets it to 1 and do his stuff
                while (queue.size() >= 5) {
                    try {
                        //wait notify must be used only inside synchronized blocks
                        // RuntimeException would be thrown instead

                        //wait() should be only inside loop NOT IF STATEMENT

                        // first instruction after notifying would be lock acquiring

                        //independent out of wait() can be because of CAS, so we need to use it
                        // in while loop()

                        //wait calls only for object inside synchronized
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                queue.add(new Object());
                System.out.println("The thread " + this.name + " put the element into the queue.");
                queue.notify();
            }
        }
    }
}

class Consumer extends Thread {
    private Queue<Object> queue;
    String name;

    public Consumer(Queue<Object> queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            // Every class has a lock (bit field) it means that this class has captured
            synchronized (queue) { // We can't lock method, we locks only object
                // if lock in the queue == 1 then wait, otherwise it sets it to 1 and do his stuff
                while (queue.size() == 0) {
                    try {
                        //wait notify must be used only inside synchronized blocks
                        // RuntimeException would be thrown instead

                        //wait() should be only inside loop NOT IF STATEMENT

                        // first instruction after notifying would be lock acquiring

                        //independent out of wait() can be because of CAS, so we need to use it
                        // in while loop()

                        //wait calls only for object inside synchronized
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                queue.poll();
                System.out.println("The thread " + this.name + " consumed the element into the queue.");
                queue.notify();
            }
        }
    }
}

//make synchronized only public methods
public class Synchr {
    public static void main(String[] args) throws InterruptedException {
        Queue<Object> queue = new LinkedList<>();

        Producer p1 = new Producer(queue, "p1");
        Producer p2 = new Producer(queue, "p2");

        Consumer c1 = new Consumer(queue, "c1");
        Consumer c2 = new Consumer(queue, "c2");
        Consumer c3 = new Consumer(queue, "c3");

        p1.start();
        p2.start();

        c1.start();
        c2.start();
        c3.start();
    }
}
