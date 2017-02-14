package oop.lection7;

enum Factories {
    TRIANGLE_FACTORY,
    CIRCLE_FACTORY;
}

class Factory {
    public static FigureFactory getFactory(Factories factoryType) {
        switch (factoryType) {
            case CIRCLE_FACTORY:
                return CircleFactory.getInstance();
            case TRIANGLE_FACTORY:
                return TriangleFactory.getInstance();
            default:
                break;
        }
        return null;
    }
}

abstract class FigureFactory {
    abstract public Shape getShape();
}

class TriangleFactory extends FigureFactory {
    static FigureFactory instance = new TriangleFactory();
    // by fact Triangle is a singletone!!! how to set dao and service //todo !!!!!!!!!!!!!!!!!!!!
    Shape figure = new Triangle();

    public static FigureFactory getInstance() {
        return instance;
    }
    public Shape getShape() {
        return figure;
    }
}

class CircleFactory extends FigureFactory {
    static FigureFactory instance = new CircleFactory();
    public static FigureFactory getInstance() {
        return instance;
    }
    public Shape getShape() {
        return new Circle();
    }
}

abstract class Shape {
    abstract public void show();
}

class Triangle extends Shape {
    @Override
    public void show() {
        System.out.println("Show triangle");
    }
}

class Circle extends Shape {
    @Override
    public void show() {
        System.out.println("Show circle");
    }
}

// Check parameters, replace initialization logic from class
// FACTORY SHOULD BE SINGLETONE (DAO, SERVICES also)
public class AbstractFactory {
    public static void main(String[] args) {
        FigureFactory figureFactory = Factory.getFactory(Factories.TRIANGLE_FACTORY);
        Shape product = figureFactory.getShape();
        product.show();
    }
}
