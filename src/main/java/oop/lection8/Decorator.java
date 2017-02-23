package oop.lection8;

abstract class Element {
    abstract public void show();
}

class Picture extends Element{
    @Override
    public void show() {
        System.out.println("Picture!");
    }
}

abstract class DecOrator extends Element {
    Element element;

    public DecOrator(Element element) {
        this.element = element;
    }
}

class Frame extends DecOrator {
    public Frame(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("Frame!");
    }
}

class Pattern extends DecOrator {
    public Pattern(Element element) {
        super(element);
    }

    @Override
    public void show() {
        element.show();
        System.out.println("Pattern!");
    }
}

public class Decorator {
    public static void main(String[] args) {
        Element picture = new Picture();
        Element pictureInFrame = new Frame(picture);
        Element pictureInFrameWithPattern = new Pattern(pictureInFrame);
        pictureInFrameWithPattern.show();

    }
}
