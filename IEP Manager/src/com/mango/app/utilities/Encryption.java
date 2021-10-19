package com.mango.app.utilities;

import java.security.MessageDigest;

public class Encryption {
    public Encryption(){
    }
    //https://stackoverflow.com/questions/5531455/how-to-hash-some-string-with-sha256-in-java
    public static String encryptPassword(String password){
        try{
            MessageDigest message = MessageDigest.getInstance("SHA-256");
            message.update(password.getBytes());
            return bytesToHex(message.digest());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    private static String bytesToHex(byte[] bytes){
        StringBuffer encryption = new StringBuffer();
        for(byte b: bytes){
            encryption.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        return encryption.toString();
    }
}
