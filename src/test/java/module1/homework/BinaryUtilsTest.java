package module1.homework;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;
import static org.junit.Assert.*;

public class BinaryUtilsTest {

    private Random random;

    @Test
    public void getPopulationCountZeroTest() {
        byte byteZero = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(byteZero));

        short shortZero = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(shortZero));

        int intZero = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(intZero));

        long longZero = 0l;
        assertEquals(0, BinaryUtils.getPopulationCount(longZero));
    }

    @Test
    public void getPopulationCountMaxValueTest() {
        byte byteMax = Byte.MAX_VALUE;
        assertEquals(Byte.SIZE - 1, BinaryUtils.getPopulationCount(byteMax));

        short shortMax = Short.MAX_VALUE;
        assertEquals(Short.SIZE - 1, BinaryUtils.getPopulationCount(shortMax));

        int intMax = Integer.MAX_VALUE;
        assertEquals(Integer.SIZE - 1, BinaryUtils.getPopulationCount(intMax));

        long longMax = Long.MAX_VALUE;
        assertEquals(Long.SIZE - 1, BinaryUtils.getPopulationCount(longMax));
    }

    @Test
    public void getPopulationCountMinValueTest() {
        byte byteMin = Byte.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(byteMin));

        short shortMin = Short.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(shortMin));

        int intMin = Integer.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(intMin));

        long longMin = Long.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(longMin));
    }

    @Test
    public void getPopulationCountSignedOneTest() {
        byte byteSignedOne = -1;
        assertEquals(Byte.SIZE, BinaryUtils.getPopulationCount(byteSignedOne));

        short shortSignedOne = -1;
        assertEquals(Short.SIZE, BinaryUtils.getPopulationCount(shortSignedOne));

        int intSignedOne = -1;
        assertEquals(Integer.SIZE, BinaryUtils.getPopulationCount(intSignedOne));

        long longSignedOne = -1l;
        assertEquals(Long.SIZE, BinaryUtils.getPopulationCount(longSignedOne));
    }

    @Test
    public void getPopulationCountRandomTest() {
        random = new Random();
        byte byteRand;
        short shortRand;
        int intRand;
        long longRand;

        for (int i = 0; i < 10000; i++) {
            byteRand = (byte) random.nextInt(1 << Byte.SIZE + Byte.MIN_VALUE);
            assertEquals(
                    "Byte argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(byteRand & 0xFF), "1"),
                    BinaryUtils.getPopulationCount(byteRand)
            );

            shortRand = (short) random.nextInt(1 << Short.SIZE + Short.MIN_VALUE);
            assertEquals(
                    "Short argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(shortRand & 0xFFFF), "1"),
                    BinaryUtils.getPopulationCount(shortRand)
            );

            intRand = random.nextInt();
            assertEquals(
                    "Int argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(intRand), "1"),
                    BinaryUtils.getPopulationCount(intRand)
            );

            longRand = random.nextLong();
            assertEquals(
                    "Long argument mismatch",
                    StringUtils.countMatches(Long.toBinaryString(longRand), "1"),
                    BinaryUtils.getPopulationCount(longRand)
            );
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBitToOneLosePositionTest() {
        BinaryUtils.setBitToOne(1111, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBitToOneExceedPositionTest() {
        BinaryUtils.setBitToOne(1111, 33);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBitToZeroLosePositionTest() {
        BinaryUtils.setBitToZero(1111, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setBitToZeroExceedPositionTest() {
        BinaryUtils.setBitToZero(1111, 33);
    }

    @Test
    public void setBitToOneFunctionalityTest(){
        //todo smarter tests
        assertEquals(1 << 0, BinaryUtils.setBitToOne(0, 1));
        assertEquals(1 << 9, BinaryUtils.setBitToOne(0, 10));
        assertEquals(1 << 31, BinaryUtils.setBitToOne(0, 32));

        assertEquals(Integer.MAX_VALUE, BinaryUtils.setBitToOne(Integer.MAX_VALUE, 1));
        assertEquals(Integer.MAX_VALUE, BinaryUtils.setBitToOne(Integer.MAX_VALUE, 16));

        assertEquals(-1, BinaryUtils.setBitToOne(Integer.MAX_VALUE, 32));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.setBitToOne(Integer.MIN_VALUE, 32));

        for (int i = 0; i < 100; i++) {
            int randomNumber = new Random().nextInt();
            int randomPosition = new Random().nextInt(32) + 1;
            BigInteger bigInteger = new BigInteger(Integer.toString(randomNumber), 10);

            assertEquals(bigInteger.setBit(randomPosition - 1).intValue(),
                    BinaryUtils.setBitToOne(randomNumber, randomPosition));
        }
    }

    @Test
    public void setBitToZeroFunctionalityTest(){
        assertEquals(0, BinaryUtils.setBitToZero(0, 1));
        assertEquals(0, BinaryUtils.setBitToZero(0, 10));
        assertEquals(0, BinaryUtils.setBitToZero(0, 32));

        assertEquals(Integer.MIN_VALUE, BinaryUtils.setBitToZero(Integer.MIN_VALUE, 1));
        assertEquals(Integer.MIN_VALUE, BinaryUtils.setBitToZero(Integer.MIN_VALUE, 31));

        assertEquals(0, BinaryUtils.setBitToZero(Integer.MIN_VALUE, 32));
        assertEquals(Integer.MAX_VALUE - 1, BinaryUtils.setBitToZero(Integer.MAX_VALUE, 1));

        for (int i = 0; i < 100; i++) {
            int randomNumber = new Random().nextInt();
            int randomPosition = new Random().nextInt(32) + 1;
            BigInteger bigInteger = new BigInteger(Integer.toString(randomNumber), 10);

            assertEquals(bigInteger.clearBit(randomPosition - 1).intValue(),
                    BinaryUtils.setBitToZero(randomNumber, randomPosition));
        }
    }
}
