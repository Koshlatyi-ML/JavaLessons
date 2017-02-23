package oop.homework.grade;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditTest {
    @Test
    public void isPassedTrue() throws Exception {
        assertTrue(CreditFactory.createCredit("subject", 60).isPassed());
    }

    @Test
    public void isPassedFalse() throws Exception {
        assertFalse(CreditFactory.createCredit("subject", 59).isPassed());
    }

}