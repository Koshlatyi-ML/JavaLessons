package module1.homework;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.util.Random;

/**
 * This class describes RSA-algorithm operator, which know his
 * secret key and is able to decrypt cipher by using this key.
 * @see "https://ru.wikipedia.org/wiki/RSA"
 */
public class RsaDecryptor {
    public static final int BIT_SIZE = 1024;

    private BigInteger prime1;
    private BigInteger prime2;

    private BigInteger modulus;
    private BigInteger publicExponent;
    private BigInteger secretExponent;

    /*
        Generate a modulus - mandatory part of the RSA keys
     */
    private void initModulus() {
        prime1 = BigInteger.probablePrime(BIT_SIZE, new Random());
        prime2 = BigInteger.probablePrime(BIT_SIZE, new Random());

        this.modulus = prime1.multiply(prime2);
    }

    /*
        Calculate Euler's totient function of two prime numbers
        "https://en.wikipedia.org/wiki/Euler%27s_totient_function"
     */
    private BigInteger calculateTotient(BigInteger x, BigInteger y) {
        return x.subtract(BigInteger.ONE)
                .multiply(y.subtract(BigInteger.ONE));
    }

    /*
        Generate a public exponent - part a the public key
        and calculate the secret exponent - part of a secret key
     */
    private void initExponents() {
        publicExponent = BigInteger.probablePrime(BIT_SIZE / 2, new Random());

        while (calculateTotient(prime1, prime2).gcd(publicExponent).compareTo(BigInteger.ONE) > 0
                && publicExponent.compareTo(calculateTotient(prime1, prime2)) < 0) {
            publicExponent.add(BigInteger.ONE);
        }

        secretExponent = publicExponent.modInverse(calculateTotient(prime1, prime2));
    }

    public BigInteger getPublicExponent() {
        return publicExponent;
    }

    public BigInteger getModulus() {
        return modulus;
    }

    public RsaDecryptor() {
        initModulus();
        initExponents();
    }

    /**
     * Perform decryption of the incoming message, using a secret key.
     *
     * @param cipher cipher to be encrypted
     * @return decrypted bytes
     */
    public byte[] decrypt(@NotNull byte[] cipher) {
        byte[] decoding;

        if (cipher.length == 0) {
            decoding = new byte[0];
        } else {
            decoding =  new BigInteger(cipher).modPow(secretExponent, modulus).toByteArray();
        }

        return decoding;
    }
}
