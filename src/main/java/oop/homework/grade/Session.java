package oop.homework.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Session {
    private List<Credit> exams = new ArrayList<>();

    private static final int NEEDED_EXAMS_COUNT = 5;

    public List<Credit> getExams() {
        return exams;
    }

    public double getAverageMark() {
        return exams.stream()
                    .mapToInt(Credit::getMark)
                    .average().orElseThrow(NoSuchElementException::new);
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
        return exams.stream().allMatch(Credit::isPassed);
    }
}
