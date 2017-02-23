package oop.lection10;

class Common {
    public void algorithm() {
        System.out.println("Common Part");
    }
}

class AlgorithmA extends Common {
    @Override
    public void algorithm() {
        super.algorithm();
        System.out.println("A part");
    }
}

class AlgorithmB extends Common {
    @Override
    public void algorithm() {
        super.algorithm();
        System.out.println("B part");
    }
}

//We have different algorithms with same parts, to prevent copypast
// push same part to the top of the hierarchy
public class TemplateMethod {
    public static void main(String[] args) {
        Common common = new AlgorithmA();
        common.algorithm();
    }
}
