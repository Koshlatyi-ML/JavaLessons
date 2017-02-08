package module1.homework;

import java.math.BigInteger;
import java.util.Objects;
import java.util.Random;

public class MathUtils {
    private static final String NULL_ARGUMENT_MSG = "Method parameters was null";

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

    public static void main(String[] args) {
        multiplyKaratsuba(null, new BigInteger(100, new Random()));
    }
}
