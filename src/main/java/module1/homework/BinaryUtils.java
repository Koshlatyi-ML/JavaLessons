package module1.homework;

public class BinaryUtils {
    /**
     * This method counts number of positive bits in binary (also known
     * as Hamming Weight, population count, etc.)
     * @see "https://en.wikipedia.org/wiki/Hamming_weight"
     *
     * @param bitNumber byte primitive binary
     *
     * @return hamming weight of bitNUmber
     */
    public static int getPopulationCount(byte bitNumber) {
        final byte[] masks = {
                0x55, //binary: 01010101
                0x33, //binary: 00110011
                0x0f  //binary: 00001111
        };

        int popCount = bitNumber;

        /*
         Use tree pattern schema
         https://en.wikipedia.org/wiki/Hamming_weight#Efficient_implementation
        */
        for (int i = 0; i < Math.log(Byte.SIZE) / Math.log(2); i++) {
            popCount = (popCount & masks[i]) + ((popCount >> (1 << i)) & masks[i]);
        }

        return popCount;
    }

    /**
     * This method counts number of positive bits in binary (also known
     * as Hamming Weight, population count, etc.)
     * @see "https://en.wikipedia.org/wiki/Hamming_weight"
     *
     * @param bitNumber short primitive binary
     *
     * @return hamming weight of bitNUmber
     */
    public static int getPopulationCount(short bitNumber) {
        final short[] masks = {
                0x5555,
                0x3333,
                0x0f0f,
                0x00ff  //binary: 8 zeros, 8 ones
        };

        int popCount = bitNumber;

        for (int i = 0; i < Math.log(Short.SIZE) / Math.log(2); i++) {
            popCount = (popCount & masks[i]) + ((popCount >> (1 << i)) & masks[i]);
        }

        return popCount;
    }

    /**
     * This method counts number of positive bits in binary (also known
     * as Hamming Weight, population count, etc.)
     * @see "https://en.wikipedia.org/wiki/Hamming_weight"
     *
     * @param bitNumber int primitive binary
     *
     * @return hamming weight of bitNUmber
     */
    public static int getPopulationCount(int bitNumber) {
        final int[] masks = {
                0x55555555,
                0x33333333,
                0x0f0f0f0f,
                0x00ff00ff,
                0x0000ffff  //binary: 16 zeros, 16 ones
        };

        int popCount = bitNumber;

        for (int i = 0; i < Math.log(Integer.SIZE) / Math.log(2); i++) {
            popCount = (popCount & masks[i]) + ((popCount >> (1 << i)) & masks[i]);
        }

        return popCount;
    }

    /**
     * This method counts number of positive bits in binary (also known
     * as Hamming Weight, population count, etc.)
     * @see "https://en.wikipedia.org/wiki/Hamming_weight"
     *
     * @param bitNumber long primitive binary
     *
     * @return hamming weight of bitNUmber
     */
    public static int getPopulationCount(long bitNumber) {
        final long[] masks = {
                0x5555555555555555l,
                0x3333333333333333l,
                0x0f0f0f0f0f0f0f0fl,
                0x00ff00ff00ff00ffl,
                0x0000ffff0000ffffl,
                0x00000000ffffffffl  //binary: 32 zeros, 32 ones
        };

        long popCount = bitNumber;

        for (int i = 0; i < Math.log(Long.SIZE) / Math.log(2); i++) {
            popCount = (popCount & masks[i]) + ((popCount >> (1 << i)) & masks[i]);
        }

        return (int) popCount;
    }

    private static final String OUT_OF_RANGE_MSG
            = "Position should be a number in range from 1 to 32, both inclusive";

    /**
     * This method sets the specified bit of number to 0.
     * Bit position starts from the right.
     *
     * @param bitNumber number to change the bit
     * @param position position of desired bit
     *
     * @throws IllegalArgumentException if position < 1 or position > 32
     *
     * @return resulting number
     */
    public static int setBitToZero(int bitNumber, int position) {
        if (position < 1 || position > 32) {
            throw new IllegalArgumentException (OUT_OF_RANGE_MSG);
        }

        int mask = ~(1 << (position - 1));

        return (bitNumber & mask) ;
    }

    /**
     * This method sets the specified bit of number to 1.
     * Bit position starts from the right.
     *
     * @param bitNumber number to change the bit
     * @param position position of desired bit
     *
     * @throws IllegalArgumentException if position < 1 or position > 32
     *
     * @return resulting number
     */
    public static int setBitToOne(int bitNumber, int position) {
        if (position < 1 || position > 32) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MSG);
        }

        int mask = 1 << (position - 1);

        return (bitNumber | mask);
    }
}
