package module1.homework;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

public class MathUtils {
    private static final String NULL_ARGUMENT_MSG = "Method parameters was null";

    /**
     * Perform the Karatsuba multiplication
     * @see "https://en.wikipedia.org/wiki/Karatsuba_algorithm"
     *
     * @param x
     * @param y
     * @return result of a multiplication
     */
    public static BigInteger multiplyKaratsuba(BigInteger x, BigInteger y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            throw new NullPointerException(NULL_ARGUMENT_MSG);
        }

        int maxBitLength = Math.max(x.bitLength(), y.bitLength());

        if (maxBitLength <= 1) {
            return x.multiply(y);
        }

        int halfBitLength = (maxBitLength / 2) + (maxBitLength % 2);

        //x = a*2^n + b;
        BigInteger a = x.shiftRight(halfBitLength);
        BigInteger b = x.subtract(a.shiftLeft(halfBitLength));

        //x = c*2^n + d;
        BigInteger c = y.shiftRight(halfBitLength);
        BigInteger d = y.subtract(c.shiftLeft(halfBitLength));

        BigInteger ac = multiplyKaratsuba(a, c);
        BigInteger bd = multiplyKaratsuba(b, d);
        BigInteger abcd = multiplyKaratsuba(a.add(b), c.add(d));

        return ac.shiftLeft(halfBitLength * 2)
                .add(bd)
                .add(abcd
                        .subtract(ac)
                        .subtract(bd)
                        .shiftLeft(halfBitLength));
    }

    /**
     * Find a greatest common divider of two numbers using the
     * binary GCD algorithm.
     * @see "https://en.wikipedia.org/wiki/Binary_GCD_algorithm"
     *
     * @param x
     * @param y
     * @return greatest common divisor
     */
    public static BigInteger findGCD(BigInteger x, BigInteger y) {
        if (Objects.isNull(x) || Objects.isNull(y)) {
            throw new NullPointerException(NULL_ARGUMENT_MSG);
        }

        x = (x.signum() == -1) ? x.negate() : x;
        y = (y.signum() == -1) ? y.negate() : y;

        if (x.equals(y)) {
            return x;
        }

        if (x.equals(BigInteger.ZERO)) {
            return y;
        }

        if (y.equals(BigInteger.ZERO)) {
            return x;
        }

        boolean isEvenX = x.and(BigInteger.ONE).equals(BigInteger.ZERO);
        boolean isEvenY = y.and(BigInteger.ONE).equals(BigInteger.ZERO);

        x = (isEvenX) ? x.shiftRight(1) : x;
        y = (isEvenY) ? y.shiftRight(1) : y;

        BigInteger greaterCommonDivisor = null;

        // if one of arguments is even, but another is not
        if ((isEvenX && !isEvenY) || (!isEvenX  && isEvenY)) { // todo check braces
            greaterCommonDivisor = findGCD(x, y);
        }

        // if both even, the GCD = 2*(x/2, y/2);
        if (isEvenX && isEvenY) {
            greaterCommonDivisor = findGCD(x, y).shiftLeft(1);
        }

        // if both even, the GCD = 2*(x/2, y/2);
        if (!isEvenX && !isEvenY) {
            BigInteger greater;
            BigInteger lower;

            if (x.compareTo(y) >= 0) {
                greater = x;
                lower = y;
            } else {
                greater = y;
                lower = x;
            }

            greaterCommonDivisor = findGCD((greater.subtract(lower).shiftRight(1)), lower);
        }

        return greaterCommonDivisor;
    }
    }
