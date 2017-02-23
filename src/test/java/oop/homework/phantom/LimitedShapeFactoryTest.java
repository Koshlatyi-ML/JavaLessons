package oop.homework.phantom;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;
import oop.homework.geometry.factory.Figure;
import oop.homework.geometry.factory.ShapeFactories;
import oop.homework.geometry.factory.ShapeFactory;
import org.junit.Test;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class LimitedShapeFactoryTest {
    public long getCount(LimitedShapeFactory factory) {
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

    @Test
    public void createObject() throws Exception {
        LimitedShapeFactory factory = new LimitedShapeFactory(5);

        ShapeFactory shapeFactory = ShapeFactories.getFactory(Figure.RING);

        for (int i = 0; i < 100; i++) {
            factory.createObject(shapeFactory, new Point[]{new Point(i + 10, 2),
                                               new Point(3, i - 10)});
            System.out.println(getCount(factory));
            assertTrue(getCount(factory) <= 5);
        }
    }

}