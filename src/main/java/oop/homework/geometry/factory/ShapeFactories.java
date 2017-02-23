package oop.homework.geometry.factory;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactories {
    private static Map<Figure, ShapeFactory> figureFactoryMap
            = new HashMap<Figure, ShapeFactory>() {{
       put(Figure.RING, RingFactory.getInstance());
       put(Figure.TRIANGLE, TriangleFactory.getInstance());
       put(Figure.PARALLELOGRAM, ParallelogramFactory.getInstance());
       put(Figure.TRAPEZIUM, TrapeziumFactory.getInstance());
    }};

    public static ShapeFactory getFactory(Figure figure) {
        return figureFactoryMap.get(figure);
    }
}
