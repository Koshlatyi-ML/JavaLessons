package oop.lection10;

public abstract class Strategy {
   abstract void sort();
}

class InsertSort extends Strategy {
    @Override
    public void sort() {
        System.out.println("Insert Sort");
    }
}

class QuickSort extends Strategy {
    @Override
    public void sort() {
        System.out.println("Quick Sort");
    }
}

class Mainn {
    public static void f(Strategy strategy) {
        strategy.sort();
    }
    public static void main(String[] args) {
        Strategy strategy = new InsertSort();
        f(strategy);
    }
}



