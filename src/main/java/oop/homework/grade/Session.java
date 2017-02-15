package oop.homework.grade;

import java.util.ArrayList;
import java.util.List;

public class Session {
    private List<Credit> exams = new ArrayList<>();

    private static final int NEEDED_EXAMS_COUNT = 5;

    public List<Credit> getExams() {
        return exams;
    }

    public double getAverageMark() {
        return exams.stream()
                    .mapToInt(Credit::getMark)
                    .average().getAsDouble();
    }

    public void addExam(Credit exam) {
        if (exam == null) {
            throw new NullPointerException();
        }

        if (exams.size() >= NEEDED_EXAMS_COUNT) {
            throw new IllegalStateException("Exam list is already overflow");
        }

        exams.add(exam);
    }

    public boolean isFinished() {
        return exams.size() == NEEDED_EXAMS_COUNT;
    }

    public boolean isPassed() {
        return isFinished() && exams.stream().allMatch(Credit::isPassed);
    }
}
