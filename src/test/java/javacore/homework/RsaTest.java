package javacore.homework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Random;

public class RsaTest {
    private RsaEncryptor encryptor;
    private RsaDecryptor decryptor;

    @Before
    public void initRSA() {
        decryptor = new RsaDecryptor();
        encryptor = new RsaEncryptor(decryptor.getPublicExponent(), decryptor.getModulus());
    }

    @Test(expected = NullPointerException.class)
    public void rsaEncryptorNullExponentTest() {
        encryptor = new RsaEncryptor(null, new BigInteger("1"));
    }

    @Test(expected = NullPointerException.class)
    public void rsaEncryptorNullModulusTest() {
        encryptor = new RsaEncryptor(new BigInteger("1"), null);
    }

    @Test(expected = NullPointerException.class)
    public void rsaEncryptorAllNullTest() {
        encryptor = new RsaEncryptor(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void encryptTextNullTest() {
        encryptor = new RsaEncryptor(new BigInteger("1"), new BigInteger("2"));
        encryptor.encrypt(null);
    }

    @Test(expected = NullPointerException.class)
    public void decryptTextNullTest() {
        decryptor = new RsaDecryptor();
        decryptor.decrypt(null);
    }

    @Test
    public void rsaDecryptorGettersNotNullTest() {
        decryptor = new RsaDecryptor();
        assertNotNull("Exponent is null", decryptor.getPublicExponent());
        assertNotNull("Modulus is null", decryptor.getModulus());
    }

    @Test
    public void rsaSpecialTextTest() {
        String message = "";
        assertEquals(message, new String(decryptor.decrypt(encryptor.encrypt(message))));

        message = "    ";
        assertEquals(message, new String(decryptor.decrypt(encryptor.encrypt(message))));

        message = "$%)|}:!";
        assertEquals(message, new String(decryptor.decrypt(encryptor.encrypt(message))));
    }

    @Test
    public void rsaFeatureTest() {
        String randString;
        for (int i = 0; i < 10; i++) {
            randString = new BigInteger(1 << i, new Random()).toString(64);
            assertEquals(randString, new String(decryptor.decrypt(encryptor.encrypt(randString))));
        }
    }
}
