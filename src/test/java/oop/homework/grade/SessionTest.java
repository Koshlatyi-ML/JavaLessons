package oop.homework.grade;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SessionTest {
    @Test
    public void getAverageMark() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 80));
        session.addExam(CreditFactory.createCredit("t3", 90));

        assertEquals(80, session.getAverageMark(), 0.0001);
    }

    @Test(expected = NoSuchElementException.class)
    public void getAverageMarkZero() throws Exception {
        assertEquals(0, new Session().getAverageMark(), 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void addExamNull() throws Exception {
        Session session = new Session();
        session.addExam(null);
    }

    @Test(expected = IllegalStateException.class)
    public void addExamOverflow() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 70));
        session.addExam(CreditFactory.createCredit("t4", 70));
        session.addExam(CreditFactory.createCredit("t5", 70));
        session.addExam(CreditFactory.createCredit("t6", 70));
    }

    @Test
    public void addExam() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 70));

        Credit credit = CreditFactory.createCredit("subj", 100);
        session.addExam(credit);

        assertEquals(credit, session.getExams().get(3));
    }

    @Test
    public void isFinishedTrue() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 70));
        session.addExam(CreditFactory.createCredit("t4", 70));
        session.addExam(CreditFactory.createCredit("t5", 70));

        assertTrue(session.isFinished());
    }

    @Test
    public void isFinishedFalse() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 70));

        assertFalse(session.isFinished());
    }


    @Test
    public void isPassedTrue() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 70));

        assertFalse(session.isPassed());
    }

    @Test
    public void isPassedFalse() throws Exception {
        Session session = new Session();
        session.addExam(CreditFactory.createCredit("t1", 70));
        session.addExam(CreditFactory.createCredit("t2", 70));
        session.addExam(CreditFactory.createCredit("t3", 59));

        assertFalse(session.isFinished());
    }
}