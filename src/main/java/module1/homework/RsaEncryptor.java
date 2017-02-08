package module1.homework;

import com.sun.istack.internal.NotNull;

import java.math.BigInteger;
import java.util.Base64;
import java.util.Objects;

public class RsaEncryptor {
    private BigInteger modulus;
    private BigInteger publicExponent;

    public RsaEncryptor(@NotNull BigInteger publicExponent, @NotNull BigInteger modulus) {
        if (Objects.isNull(publicExponent) || Objects.isNull(modulus)) {
            throw new NullPointerException();
        }

        this.publicExponent = publicExponent;
        this.modulus = modulus;
    }

    public byte[] encrypt(@NotNull String message) {
        byte[] cipher;

        if (message.equals("")) {
            cipher = message.getBytes();
        } else {
            cipher = new BigInteger(message.getBytes()).modPow(publicExponent, modulus).toByteArray();
        }

        return cipher;
    }

}
