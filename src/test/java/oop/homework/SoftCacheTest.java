package oop.homework;

import oop.homework.cache.SoftCache;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;

public class SoftCacheTest {
    @Test
    public void get() throws Exception {
        SoftCache cache = new SoftCache();
        cache.put("DymnaSumish.zip");

        long firstTry = System.nanoTime();
        byte[] in = cache.get("DymnaSumish.zip");
        firstTry = System.nanoTime() - firstTry;
        in = null;

        StringBuffer stringBuffer = new StringBuffer("s");

        for (int l = 0; l < 53127849l; l++) {
            stringBuffer.append("sss");
        }
        stringBuffer.append("ss");

        cache.put("1.zip");
        cache.put("2.zip");
        Thread.sleep(2000);
        System.gc();
        Thread.sleep(2000);

        long secondTry = System.nanoTime();
        byte[] inputStream = cache.get("DymnaSumish.zip");
        secondTry = System.nanoTime() - secondTry;

        System.out.println(inputStream);
        System.out.println(secondTry - firstTry);

        assertTrue(secondTry > firstTry);
//        System.out.println(cache.get("DymnaSumish.zip") == null);
//        System.out.println(cache.get("1.zip") == null);
//        System.out.println(cache.get("2.zip") == null);
//        System.out.println(cache.get("3.zip") == null);
//        System.out.println(cache.get("4.zip") == null);
    }

}