package module1.homework;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class BinaryUtilsTest {

    @Test
    public void getPopulationCountZeroTest() {
        byte  byteZero  = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(byteZero));

        short shortZero = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(shortZero));

        int   intZero   = 0;
        assertEquals(0, BinaryUtils.getPopulationCount(intZero));

        long  longZero  = 0l;
        assertEquals(0, BinaryUtils.getPopulationCount(longZero));
    }

    @Test
    public void getPopulationCountMaxValueTest() {
        byte  byteMax  = Byte.MAX_VALUE;
        assertEquals(Byte.SIZE - 1, BinaryUtils.getPopulationCount(byteMax));

        short shortMax = Short.MAX_VALUE;
        assertEquals(Short.SIZE - 1, BinaryUtils.getPopulationCount(shortMax));

        int   intMax   = Integer.MAX_VALUE;
        assertEquals(Integer.SIZE - 1, BinaryUtils.getPopulationCount(intMax));

        long  longMax  = Long.MAX_VALUE;
        assertEquals(Long.SIZE - 1, BinaryUtils.getPopulationCount(longMax));
    }

    @Test
    public void getPopulationCountMinValueTest() {
        byte  byteMin  = Byte.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(byteMin));

        short shortMin = Short.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(shortMin));

        int   intMin   = Integer.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(intMin));

        long  longMin  = Long.MIN_VALUE;
        assertEquals(1, BinaryUtils.getPopulationCount(longMin));
    }

    @Test
    public void getPopulationCountSignedOneTest() {
        byte  byteSignedOne  = -1;
        assertEquals(Byte.SIZE, BinaryUtils.getPopulationCount(byteSignedOne));

        short shortSignedOne = -1;
        assertEquals(Short.SIZE, BinaryUtils.getPopulationCount(shortSignedOne));

        int   intSignedOne   = -1;
        assertEquals(Integer.SIZE, BinaryUtils.getPopulationCount(intSignedOne));

        long  longSignedOne  = -1l;
        assertEquals(Long.SIZE, BinaryUtils.getPopulationCount(longSignedOne));
    }

    @Test
    public void getPopulationCountRandomTest() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            byte byteRand = (byte) random.nextInt(1 << Byte.SIZE + Byte.MIN_VALUE);
            assertEquals(
                    "Byte argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(byteRand & 0xFF), "1"),
                    BinaryUtils.getPopulationCount(byteRand)
            );

            short shortRand = (short) random.nextInt(1 << Short.SIZE + Short.MIN_VALUE);
            assertEquals(
                    "Short argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(shortRand & 0xFFFF), "1"),
                    BinaryUtils.getPopulationCount(shortRand)
            );

            int intRand = random.nextInt();
            assertEquals(
                    "Int argument mismatch",
                    StringUtils.countMatches(Integer.toBinaryString(intRand), "1"),
                    BinaryUtils.getPopulationCount(intRand)
            );

            long longRand = random.nextLong();
            assertEquals(
                    "Long argument mismatch",
                    StringUtils.countMatches(Long.toBinaryString(longRand), "1"),
                    BinaryUtils.getPopulationCount(longRand)
            );
        }
    }
}
