package com.hand.ln.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

public class Test {

    public static void main(String[] args) {
        StrongTextEncryptor ste = new StrongTextEncryptor();
        // 加密
        ste.setPassword("password");
        String encyptedResult = ste.encrypt("123456");
        System.out.println("encyptedResult:" + encyptedResult);
        // 解密
        String dencyptedResult = ste.decrypt(encyptedResult);
        System.out.println(dencyptedResult);

        StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
        enc.setPassword("123456");
        String result = enc.encrypt("hey");
        System.out.println("encyptedResult:" + result);
        String deresult = enc.decrypt(result);
        System.out.println(deresult);
    }

}
