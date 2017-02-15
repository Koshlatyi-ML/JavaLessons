package oop.homework.grade;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class GradeBookTest {
    @Test(expected = NullPointerException.class)
    public void addExamNull() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(null);
    }

    @Test(expected = IllegalStateException.class)
    public void addExamOverflow() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 70));
        book.addExam(CreditFactory.createCredit("t2", 70));
        book.addExam(CreditFactory.createCredit("t3", 70));
        book.addExam(CreditFactory.createCredit("t4", 70));
        book.addExam(CreditFactory.createCredit("t5", 70));
        book.addExam(CreditFactory.createCredit("t6", 70));
    }


    @Test(expected = IllegalStateException.class)
    public void addExamFailedSession() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 70));
        book.addExam(CreditFactory.createCredit("t2", 50));
        book.addExam(CreditFactory.createCredit("t3", 90));
    }

    @Test(expected = IllegalStateException.class)
    public void addExamFailedCredit() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 70));
        book.addСredit(CreditFactory.createCredit("t2", 50));
        book.addExam(CreditFactory.createCredit("t3", 90));
    }

    @Test(expected = IllegalStateException.class)
    public void addExamNotFinishedСredits() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 80));
        book.addСredit(CreditFactory.createCredit("t2", 80));
        book.addСredit(CreditFactory.createCredit("t3", 80));
        book.addExam(CreditFactory.createCredit("у1", 70));
        book.addExam(CreditFactory.createCredit("у2", 90));
        book.addExam(CreditFactory.createCredit("у3", 70));
        book.addExam(CreditFactory.createCredit("у4", 70));
        book.addExam(CreditFactory.createCredit("у5", 70));
        book.addExam(CreditFactory.createCredit("у6", 70));
    }

    @Test
    public void addExamStartNewSemester() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 70));
        book.addExam(CreditFactory.createCredit("у2", 90));
        book.addExam(CreditFactory.createCredit("у3", 70));
        book.addExam(CreditFactory.createCredit("у4", 70));
        book.addExam(CreditFactory.createCredit("у5", 70));

        int semestersCount = book.getSemestersAmount();

        book.addExam(CreditFactory.createCredit("у6", 70));

        assertEquals(semestersCount + 1, book.getSemestersAmount());
    }

    @Test
    public void addСredit() throws Exception {

    }

    @Test(expected = NullPointerException.class)
    public void addCreditNull() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(null);
    }

    @Test(expected = IllegalStateException.class)
    public void addCreditOverflow() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 70));
        book.addСredit(CreditFactory.createCredit("t2", 70));
        book.addСredit(CreditFactory.createCredit("t3", 70));
        book.addСredit(CreditFactory.createCredit("t4", 70));
        book.addСredit(CreditFactory.createCredit("t5", 70));
        book.addСredit(CreditFactory.createCredit("t6", 70));
        book.addСredit(CreditFactory.createCredit("t7", 70));
        book.addСredit(CreditFactory.createCredit("t8", 70));
        book.addСredit(CreditFactory.createCredit("t9", 70));

    }


    @Test(expected = IllegalStateException.class)
    public void addCreditFailedSession() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 70));
        book.addExam(CreditFactory.createCredit("t2", 50));
        book.addСredit(CreditFactory.createCredit("t3", 90));
    }

    @Test(expected = IllegalStateException.class)
    public void addCreditFailedCredit() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 70));
        book.addСredit(CreditFactory.createCredit("t2", 50));
        book.addСredit(CreditFactory.createCredit("t3", 90));
    }

    @Test(expected = IllegalStateException.class)
    public void addCreditNotFinishedExams() throws Exception {
        GradeBook book = new GradeBook();
        book.addExam(CreditFactory.createCredit("t1", 80));
        book.addExam(CreditFactory.createCredit("t2", 80));
        book.addExam(CreditFactory.createCredit("t3", 80));
        book.addСredit(CreditFactory.createCredit("у1", 70));
        book.addСredit(CreditFactory.createCredit("у2", 90));
        book.addСredit(CreditFactory.createCredit("у3", 70));
        book.addСredit(CreditFactory.createCredit("у4", 70));
        book.addСredit(CreditFactory.createCredit("у5", 70));
        book.addСredit(CreditFactory.createCredit("у6", 70));
        book.addСredit(CreditFactory.createCredit("у7", 70));
        book.addСredit(CreditFactory.createCredit("у8", 70));
        book.addСredit(CreditFactory.createCredit("у9", 70));
    }

    @Test
    public void addCreditStartNewSemester() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 70));
        book.addExam(CreditFactory.createCredit("у2", 90));
        book.addExam(CreditFactory.createCredit("у3", 70));
        book.addExam(CreditFactory.createCredit("у4", 70));
        book.addExam(CreditFactory.createCredit("у5", 70));

        int semestersCount = book.getSemestersAmount();

        book.addСredit(CreditFactory.createCredit("у6", 70));

        assertEquals(semestersCount + 1, book.getSemestersAmount());
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageEmpty() {
        GradeBook book = new GradeBook();
        book.getAverageMark();
    }

    @Test
    public void getAverageMark() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 60));
        book.addExam(CreditFactory.createCredit("у2", 60));
        book.addExam(CreditFactory.createCredit("у3", 60));
        book.addExam(CreditFactory.createCredit("у4", 60));
        book.addExam(CreditFactory.createCredit("у5", 60));

        book.addСredit(CreditFactory.createCredit("t1", 70));
        book.addСredit(CreditFactory.createCredit("t2", 70));
        book.addСredit(CreditFactory.createCredit("t3", 70));
        book.addСredit(CreditFactory.createCredit("t4", 70));
        book.addСredit(CreditFactory.createCredit("t5", 70));
        book.addСredit(CreditFactory.createCredit("t6", 70));
        book.addСredit(CreditFactory.createCredit("t7", 70));
        book.addСredit(CreditFactory.createCredit("t8", 70));
        book.addExam(CreditFactory.createCredit("у1", 70));
        book.addExam(CreditFactory.createCredit("у2", 70));
        book.addExam(CreditFactory.createCredit("у3", 70));
        book.addExam(CreditFactory.createCredit("у4", 70));
        book.addExam(CreditFactory.createCredit("у5", 70));

        assertEquals(65, book.getAverageMark(), 0.0001);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageSemesterMarkEmpty() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSemesterMark(0);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageSemesterMarkIndexSmall() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSemesterMark(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageSemesterMarkIndexHuge() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSemesterMark(1);
    }

    @Test
    public void getAverageSemesterMark() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 60));
        book.addExam(CreditFactory.createCredit("у2", 60));
        book.addExam(CreditFactory.createCredit("у3", 60));
        book.addExam(CreditFactory.createCredit("у4", 60));
        book.addExam(CreditFactory.createCredit("у5", 60));

        book.addСredit(CreditFactory.createCredit("t1", 100));
        book.addСredit(CreditFactory.createCredit("t2", 100));

        assertEquals(60, book.getAverageSemesterMark(0), 0.0001);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageSessionMarkEmpty() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSessionMark(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageSessionMarkIndexSmall() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSessionMark(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageSessionMarkIndexHuge() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageSessionMark(1);
    }

    @Test
    public void getAverageSessionMark() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 90));
        book.addExam(CreditFactory.createCredit("у2", 90));
        book.addExam(CreditFactory.createCredit("у3", 90));
        book.addExam(CreditFactory.createCredit("у4", 90));
        book.addExam(CreditFactory.createCredit("у5", 90));

        book.addСredit(CreditFactory.createCredit("t1", 100));
        book.addСredit(CreditFactory.createCredit("t2", 100));

        assertEquals(90, book.getAverageSessionMark(0), 0.0001);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageCreditsMarkEmpty() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageCreditsMark(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageCreditsMarkIndexSmal() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageCreditsMark(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getAverageCreditsMarkIndexHuge() throws Exception {
        GradeBook book = new GradeBook();
        book.getAverageCreditsMark(1);
    }

    @Test
    public void getAverageCreditsMark() throws Exception {
        GradeBook book = new GradeBook();
        book.addСredit(CreditFactory.createCredit("t1", 60));
        book.addСredit(CreditFactory.createCredit("t2", 60));
        book.addСredit(CreditFactory.createCredit("t3", 60));
        book.addСredit(CreditFactory.createCredit("t4", 60));
        book.addСredit(CreditFactory.createCredit("t5", 60));
        book.addСredit(CreditFactory.createCredit("t6", 60));
        book.addСredit(CreditFactory.createCredit("t7", 60));
        book.addСredit(CreditFactory.createCredit("t8", 60));
        book.addExam(CreditFactory.createCredit("у1", 90));
        book.addExam(CreditFactory.createCredit("у2", 90));
        book.addExam(CreditFactory.createCredit("у3", 90));
        book.addExam(CreditFactory.createCredit("у4", 90));
        book.addExam(CreditFactory.createCredit("у5", 90));

        book.addСredit(CreditFactory.createCredit("t1", 100));
        book.addСredit(CreditFactory.createCredit("t2", 100));

        assertEquals(60, book.getAverageCreditsMark(0), 0.0001);
    }
}