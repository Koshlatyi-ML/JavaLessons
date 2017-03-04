package oop.homework.patterns.composite;

public enum Operation {
    MULTIPLICATION {
        @Override
        public int perform(int a, int b) {
            return a * b;
        }
    },
    ADDITION {
        @Override
        public int perform(int a, int b) {
            return a + b;
        }
    };

    public abstract int perform(int a, int b);
}
