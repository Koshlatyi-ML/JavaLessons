package module1.homework;

import com.sun.istack.internal.NotNull;

import javax.xml.bind.DatatypeConverter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class RsaDecryptor {
    public static final int BIT_SIZE = 1024;

    private BigInteger prime1;
    private BigInteger prime2;

    private BigInteger modulus;
    private BigInteger publicExponent;
    private BigInteger secretExponent;

    private void initModulus() {
        prime1 = BigInteger.probablePrime(BIT_SIZE, new Random());
        prime2 = BigInteger.probablePrime(BIT_SIZE, new Random());

        this.modulus = prime1.multiply(prime2);
    }

    private BigInteger calculateTotient(BigInteger x, BigInteger y) {
        return x.subtract(BigInteger.ONE)
                .multiply(y.subtract(BigInteger.ONE));
    }

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
