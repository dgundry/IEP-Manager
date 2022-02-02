package com.mango.prjmango.utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * References:
 * (1): https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
 *
 * @author  Devin Gundry
 * @version 1.0
 * @since   2021-11-11
 */
public class Encryption {

    /**
     * Encrypts the provided password to SHA-256.
     *
     * @param  password the password you want encrypted
     * @return an encrypted {@link String}
     * @throws NoSuchAlgorithmException if there's an error encrypting the {@link String}
     */
    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest message = MessageDigest.getInstance("SHA-256");
        message.update(password.getBytes());
        return bytesToHex(message.digest());
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder encryption = new StringBuilder();
        for (byte b : bytes) {
            encryption.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return encryption.toString();
    }
}
