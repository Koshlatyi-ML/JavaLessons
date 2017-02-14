package oop.homework.geometry.util;

public class ArrayUtils {
    private ArrayUtils(){
        throw new IllegalAccessError();
    }

    public static <T> boolean hasDistinctValues(T[] values) {
        boolean hasUniqueValues = true;

        for (int i = 0; i < values.length - 1; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i].equals(values[j])) {
                    hasUniqueValues = false;
                    break;
                }
            }
        }

        return hasUniqueValues;
    }
}
