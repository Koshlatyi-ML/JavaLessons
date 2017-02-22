package oop.homework.phantom;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.Triangle;
import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

public class LimitedShapeFactory {
    private int limit;
    private volatile int count;

    private ReferenceQueue<Shape> referenceQueue = new ReferenceQueue<>();

//    private Thread cleaner = new Thread(() -> {
//        while (true) {
//            if (referenceQueue.poll() != null) {
//                count--;
//            }
//        }
//    });

    public LimitedShapeFactory(int limit) {
        this.limit = limit;
    }

//    private void startCleaner() {
//        cleaner.start();
//    }
//
//    private void stopCleaner() {
//        cleaner.interrupt();
//    }

    public Shape createObject(ShapeFactory factory, Point[] points) {
        while (count >= limit) {
            clearObject();
        }

        Reference<? extends Shape> phantomRef;
        Shape strongRef;
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

    public long getCount() {
        long result = -1;

        try {
            Field queueLength = referenceQueue.getClass()
                                              .getDeclaredField("queueLength");
            queueLength.setAccessible(true);
            result =  queueLength.getLong(referenceQueue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        LimitedShapeFactory factory = new LimitedShapeFactory(5);

        ShapeFactory shapeFactory = ShapeFactories.getFactory(Figure.RING);

        System.out.println(factory.getCount());

        factory.createObject(shapeFactory, new Point[]{new Point(1, 2),
                                                       new Point(3, 4)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(11, 2),
                new Point(3, 4)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(1, 21),
                new Point(3, 4)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(1, 2),
                new Point(3, 14)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(11, 21),
                new Point(3, 4)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(12, 2),
                new Point(3, 14)});
        System.out.println(factory.getCount());
        factory.createObject(shapeFactory, new Point[]{new Point(12, 2),
                new Point(3, 14)});
        System.out.println(factory.getCount());

        factory = null;
    }
}
