package oop.homework.geometry.factory;

import oop.homework.geometry.Point;
import oop.homework.geometry.Shape;

public interface ShapeFactory {
    Shape createShape(Point[] points);
}
