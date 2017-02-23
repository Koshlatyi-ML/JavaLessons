package oop.homework.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class SoftCache {
    private Map<String, SoftReference<byte[]>> map = new HashMap<>();

    public void put(String filename) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        map.put(filename, new SoftReference<>(bytes));
    }

    public byte[] get(String filename) throws IOException {
        byte[] out = map.get(filename).get();
        if (out == null) {
            synchronized (this) {
                put(filename);
                out = map.get(filename).get();
            }
        }
        return out;
    }

    public int size() {
        return map.size();
    }
}
