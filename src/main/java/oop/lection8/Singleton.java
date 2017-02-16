package oop.lection8;

class Single {
    private static Single instance = new Single();

    private Single(){}

    public static Single getInstance() {
       /* if (instance == null) {
            // multiply threads can simultaneously check is null
            instance = new Single();
        }
      */
        return instance;
    }
}

public class Singleton {
}
