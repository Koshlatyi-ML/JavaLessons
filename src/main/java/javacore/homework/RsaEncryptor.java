package javacore.homework;

import java.math.BigInteger;
import java.util.Objects;

/**
 * This class describes RSA-algorithm operator, which know only
 * public key so it is able only to encrypt cipher by using this key.
 * @see "https://ru.wikipedia.org/wiki/RSA"
 */
public class RsaEncryptor {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RsaEncryptor(BigInteger publicExponent, BigInteger modulus) {
        if (Objects.isNull(publicExponent) || Objects.isNull(modulus)) {
            throw new NullPointerException();
        }
        // Get and write public key from their owner
        this.publicExponent = publicExponent;
        this.modulus = modulus;
    }

    /**
     * Perform encryption of the message, using a public key.
     *
     * @param message message to be encrypted
     * @return encrypted bytes
     */
    public byte[] encrypt(String message) {
        byte[] cipher;

        if ("".equals(message)) {
            cipher = message.getBytes();
        } else {
            cipher = new BigInteger(message.getBytes()).modPow(publicExponent, modulus).toByteArray();
        }

        return cipher;
    }

}
