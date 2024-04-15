package com.hana.util;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class StringEnc {
    static String key = "mykey";
    static StandardPBEStringEncryptor standardPBEStringEncryptor;
    static{
        standardPBEStringEncryptor =
                new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setPassword(key);
    }
    public static String encryptor(String msg){
        return standardPBEStringEncryptor.encrypt(msg);
    }
    public static String decryptor(String msg){
        return standardPBEStringEncryptor.decrypt(msg);
    }
}
