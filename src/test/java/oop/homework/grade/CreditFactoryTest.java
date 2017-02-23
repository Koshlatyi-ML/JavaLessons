package oop.homework.grade;

import org.junit.Test;

import static org.junit.Assert.*;

public class CreditFactoryTest {
    @Test(expected = NullPointerException.class)
    public void createCreditNull() throws Exception {
        CreditFactory.createCredit(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCreditNegativeMark() throws Exception {
        CreditFactory.createCredit("subj", -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCreditHugeMark() throws Exception {
        CreditFactory.createCredit("subj", 101);
    }

    @Test
    public void createCredit() throws Exception {
        String subject = "subj";
        int mark = 75;
        Credit credit = CreditFactory.createCredit(subject, mark);

        assertEquals(subject, credit.getTitle());
        assertEquals(mark, credit.getMark());
    }


}