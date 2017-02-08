package module1.homework;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.*;

public class MathUtilsTest {
    @Test(expected = NullPointerException.class)
    public void multiplyKaratsubaAllNullTest() throws Exception {
        MathUtils.multiplyKaratsuba(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void multiplyKaratsubaFirstNullTest() throws Exception {
        MathUtils.multiplyKaratsuba(new BigInteger("1"), null);
    }

    @Test(expected = NullPointerException.class)
    public void multiplyKaratsubaSecondNullTest() throws Exception {
        MathUtils.multiplyKaratsuba(null, new BigInteger("1"));
    }

    @Test
    public void multiplyKaratsubaBoundValuesTest() {
        assertEquals(BigInteger.ZERO, MathUtils.multiplyKaratsuba(new BigInteger("0"), new BigInteger("0")));
        assertEquals(BigInteger.ZERO, MathUtils.multiplyKaratsuba(new BigInteger("1"), new BigInteger("0")));
        assertEquals(BigInteger.ZERO, MathUtils.multiplyKaratsuba(new BigInteger("0"), new BigInteger("1")));
        assertEquals(BigInteger.ONE, MathUtils.multiplyKaratsuba(new BigInteger("1"), new BigInteger("1")));
        assertEquals(BigInteger.ONE, MathUtils.multiplyKaratsuba(new BigInteger("-1"), new BigInteger("-1")));
        assertEquals(new BigInteger("-1"), MathUtils.multiplyKaratsuba(new BigInteger("1"), new BigInteger("-1")));
    }

    @Test
    public void multiplyKaratsubaFeatureTest() {
        BigInteger x;
        BigInteger y;
        for (int i = 0; i < 10; i++) {
            x = new BigInteger(1 << i, new Random());
            y = new BigInteger(1 << i, new Random());
            assertEquals(x.multiply(y), MathUtils.multiplyKaratsuba(x, y));
        }
    }

}