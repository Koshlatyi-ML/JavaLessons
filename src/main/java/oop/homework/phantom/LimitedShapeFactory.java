package oop.homework.phantom;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.factory.ShapeFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class LimitedShapeFactory {
    private int limit;
    private volatile int count;

    private ReferenceQueue<Shape> referenceQueue = new ReferenceQueue<>();
    private Shape strongRef = null;

    public LimitedShapeFactory(int limit) {
        this.limit = limit;

        new Thread(() -> {
            while (true) {
                strongRef = null;
            }
        }).start();
    }

    public Shape createObject(ShapeFactory factory, Point[] points) {
        while (count >= limit) {
            clearObject();
        }

        Reference<? extends Shape> phantomRef;
        synchronized (this) {
            strongRef = factory.createShape(points);
            phantomRef = new PhantomReference<>(strongRef, referenceQueue);

            while (!phantomRef.isEnqueued()) {
                phantomRef.enqueue();
            }

            count++;
            return strongRef;
        }
    }

    private void clearObject() {
        Reference<? extends Shape> phantomRef = null;
        while (phantomRef == null) {
            try {
                phantomRef = referenceQueue.remove(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        phantomRef.clear();
        count--;
    }
}
