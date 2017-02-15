package oop.homework.grade;

public class Credit {
    private String title;
    private int mark;

    public Credit(String title, int mark) {
        this.title = title;
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public int getMark() {
        return mark;
    }

    public boolean isPassed() {
        return mark > 60;
    }
}
