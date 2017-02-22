package oop.homework;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftCache {
    private Map<String, SoftReference<OutputStream>> map = new HashMap<>();

    public void put(String filename) throws FileNotFoundException {
        map.put(filename, new SoftReference<OutputStream>(
                new FileOutputStream(filename)));
    }

    public OutputStream get(String filename) throws FileNotFoundException {
        OutputStream out = map.get(filename).get();
        if (out == null) {
            out = new FileOutputStream(filename);
            put(filename);
        }

        return out;
    }
}
