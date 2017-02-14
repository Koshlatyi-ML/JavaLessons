package oop.homework.geometry.util;

import oop.homework.geometry.Point;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.sqrt;

public class GeometryUtils {
    private GeometryUtils() {
        throw new IllegalAccessError();
    }

    public static double getLineLength(Point a, Point b) {
        int xScaleLength =  a.getX() - b.getX();
        int yScaleLength =  a.getY() - b.getY();
        return sqrt((abs(xScaleLength) << 1) + (abs(yScaleLength) << 1));
    }

    public static double multiplyVectors(Point firstVectorInitial, Point firstVectorTerminal,
                                         Point secondVectorInitial, Point secondVectorTerminal) {
        double firstXMagnitude =  firstVectorTerminal.getX() - firstVectorInitial.getX();
        double firstYMagnitude =  firstVectorTerminal.getY() - firstVectorInitial.getY();

        double secondXMagnitude =  firstVectorTerminal.getX() - firstVectorInitial.getX();
        double secondYMagnitude =  firstVectorTerminal.getY() - firstVectorInitial.getY();



        return firstXMagnitude * secondXMagnitude + firstYMagnitude * secondYMagnitude;
    }

    public static double getAngleOfTwoLines(Point vertex, Point leftRay, Point rightRay) {
        double leftRayLength = getLineLength(vertex, leftRay);
        double rightRayLength = getLineLength(vertex, rightRay);

        double raysMultiplication = multiplyVectors(vertex, leftRay, vertex, rightRay);

        return acos(raysMultiplication / (leftRayLength * rightRayLength));
    }

    public static boolean isParallel(Point firstVectorInitial, Point firstVectorTerminal,
                                     Point secondVectorInitial, Point secondVector) {
        double firstXMagnitude =  firstVectorTerminal.getX() - firstVectorInitial.getX();
        double firstYMagnitude =  firstVectorTerminal.getY() - firstVectorInitial.getY();

        double secondXMagnitude =  firstVectorTerminal.getX() - firstVectorInitial.getX();
        double secondYMagnitude =  firstVectorTerminal.getY() - firstVectorInitial.getY();

        double eps = 0.0001;
        return abs(firstXMagnitude / secondXMagnitude
                   - firstYMagnitude / secondYMagnitude) < eps;
    }
}
