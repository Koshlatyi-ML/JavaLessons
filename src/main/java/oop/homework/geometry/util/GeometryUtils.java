package oop.homework.geometry.util;

import oop.homework.geometry.Point;

import static java.lang.Math.*;


public class GeometryUtils {
    private GeometryUtils() {
        throw new IllegalAccessError();
    }

    public static double getLineLength(Point a, Point b) {
        if (a == null) {
            throw new NullPointerException();
        }

        if (b == null) {
            throw new NullPointerException();
        }

        int xScaleLength =  a.getX() - b.getX();
        int yScaleLength =  a.getY() - b.getY();
        return sqrt(pow(xScaleLength, 2) + pow(yScaleLength, 2));
    }

    public static double multiplyVectors(Point firstVectorInitial, Point firstVectorTerminal,
                                         Point secondVectorInitial, Point secondVectorTerminal) {
        double firstXMagnitude =  firstVectorTerminal.getX() - firstVectorInitial.getX();
        double firstYMagnitude =  firstVectorTerminal.getY() - firstVectorInitial.getY();

        double secondXMagnitude =  secondVectorTerminal.getX() - secondVectorInitial.getX();
        double secondYMagnitude =  secondVectorTerminal.getY() - secondVectorInitial.getY();

        return firstXMagnitude * secondYMagnitude - firstYMagnitude * secondXMagnitude;
    }

    public static boolean isParallel(Point firstVectorInitial, Point firstVectorTerminal,
                                     Point secondVectorInitial, Point secondVectorTerminal) {
        double eps = 0.0001;
        return abs(multiplyVectors(firstVectorInitial, firstVectorTerminal,
                                    secondVectorInitial, secondVectorTerminal)) < eps;
    }
}
