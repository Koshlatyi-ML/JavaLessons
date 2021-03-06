package oop.homework.phantom;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.Triangle;
import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class LimitedShapeFactory {
    private int limit;
    private volatile int count;
    private PhantomReference<Shape>[] phantomReferences;
    private ReferenceQueue<Shape> referenceQueue = new ReferenceQueue<>();

    public LimitedShapeFactory(int limit) {
        this.limit = limit;
        phantomReferences = new PhantomReference[limit];
    }

    public Shape createObject(ShapeFactory factory, Point[] points) {
        while (count >= limit) {
            clearObject();
        }

        Shape strongRef;
        synchronized (this) {
            strongRef = factory.createShape(points);
            phantomReferences[count] = new PhantomReference<>(strongRef, referenceQueue);
            count++;
            return strongRef;
        }
    }

    private void clearObject() {
        Reference<? extends Shape> phantomRef = null;
        while (phantomRef == null) {
            System.gc();
            phantomRef = referenceQueue.poll();
        }
        count--;
    }

    public ReferenceQueue<Shape> getReferenceQueue() {
        return referenceQueue;
    }


    public static long getCount(LimitedShapeFactory factory) {
        long result = -1;
        ReferenceQueue<Shape> referenceQueue = factory.getReferenceQueue();


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
        List<StringBuffer> phantomReferences
                = new ArrayList<>();
        ReferenceQueue<StringBuffer> queue = new ReferenceQueue<>();


        while (true) {
            phantomReferences.add(new StringBuffer("vladik"));
        }
    }
}
