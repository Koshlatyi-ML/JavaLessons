package oop.homework.patterns.composite;

import java.util.Objects;

public class Number implements Calculable {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
