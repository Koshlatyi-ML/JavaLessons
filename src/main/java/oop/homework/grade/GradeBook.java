package oop.homework.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GradeBook {
    private List<SemesterGrade> grades;

    private static final int MAX_SEMESTER_COUNT = 12;

    public void addExam(Credit exam) {
        SemesterGrade semester = grades.get(grades.size() - 1);

        checkPassed(semester);

        if (semester.session.isFinished() && !semester.isCreditsFinished()) {
            throw new IllegalStateException("Semester is not finished yet." +
                    "Please finish all the credits before");
        }

        semester = checkFinished(semester);
        semester.addExam(exam);
    }


    public void addСredit(Credit exam) {
        SemesterGrade semester = grades.get(grades.size() - 1);

        checkPassed(semester);

        if (semester.isCreditsFinished() && !semester.session.isFinished()) {
            throw new IllegalStateException("Semester is not finished yet." +
                    "Please finish the session before");
        }

        semester = checkFinished(semester);
        semester.addCredit(exam);
    }

    private SemesterGrade checkFinished(SemesterGrade semester) {
        if (semester.isFinished() && semester.isPassed()) {
            if (grades.size() == 12) {
                throw new IllegalStateException("Congratulation! You have already graduated");
            }

            SemesterGrade newGrade = new SemesterGrade();
            semester = newGrade;

            grades.add(new SemesterGrade());
        }
        return semester;
    }

    private void checkPassed(SemesterGrade semester) {
        if (!semester.session.isPassed()) {
            throw new IllegalStateException("Sorry! You has failed your last session.");
        }

        if (!semester.isCreditsPassed()) {
            throw new IllegalArgumentException("Sorry! You has failed your last credits.");
        }
    }

    public double getAverageMark() {
        return grades.stream().mapToDouble(SemesterGrade::getAverageMark)
                .average().getAsDouble();
    }

    public double getAverageSemesterMark(int semesterIndex) {
        if (semesterIndex < 0 || semesterIndex > grades.size()) {
            throw new IndexOutOfBoundsException();
        }

        return grades.get(semesterIndex).getAverageMark();
    }

    public double getAverageSessionMark(int semesterIndex) {
        if (semesterIndex < 0 || semesterIndex > grades.size()) {
            throw new IndexOutOfBoundsException();
        }

        return grades.get(semesterIndex).session.getAverageMark();
    }

    public double getAverageCreditsMark(int semesterIndex) {
        if (semesterIndex < 0 || semesterIndex > grades.size()) {
            throw new IndexOutOfBoundsException();
        }

        return grades.get(semesterIndex).getCreditsAverageMark();
    }

    private static class SemesterGrade {
        Session session = new Session();
        List<Credit> credits = new ArrayList<>();

        private static final int NEEDED_CREDITS_COUNT = 8;

        void addExam(Credit exam) {
            if (exam == null) {
                throw new NullPointerException();
            }

            session.addExam(exam);
        }

        void addCredit(Credit credit) {
            if (credit == null) {
                throw new NullPointerException();
            }
            
            credits.add(credit);
        }

        boolean isCreditsFinished() {
            return credits.size() == NEEDED_CREDITS_COUNT;
        }

        boolean isCreditsPassed() {
            return credits.stream().allMatch(Credit::isPassed);
        }

        boolean isFinished() {
            return isCreditsFinished() && session.isFinished();
        }

        boolean isPassed() {
            return session.isPassed() && isCreditsPassed();
        }

        double getCreditsAverageMark() {
            return credits.stream().mapToInt(Credit::getMark)
                    .average().getAsDouble();
        }

        double getAverageMark() {
            Stream<Credit> sessionStream = session.getExams().stream();
            Stream<Credit> creditsStream = credits.stream();

            return Stream.concat(sessionStream, creditsStream)
                    .mapToInt(Credit::getMark).average().getAsDouble();
        }
    }
}
