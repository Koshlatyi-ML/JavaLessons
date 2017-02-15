package oop.homework.grade;

public class CreditFactory {
    private CreditFactory(){}

    public static Credit createCredit(String title, int mark) {
        if (title == null) {
            throw new NullPointerException();
        }

        if (mark < 0 || mark > 100) {
            throw new IllegalArgumentException();
        }

        return new Credit(title, mark);
    }
}
