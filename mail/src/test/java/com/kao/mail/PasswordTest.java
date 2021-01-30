package com.kao.mail;

import org.springframework.beans.factory.annotation.Autowired;

public class PasswordTest extends  MailApplicationTests{
    @Autowired
    private StringEncryptor encryptor;

    /**
     * 生成加密密碼
     */
    @Test
    public void testGeneratePassword() {
        // 你的郵箱密碼
        String password = "Just4Test!";
        // 加密後的密碼(注意：配置上去的时候需要加 ENC(加密密码))
        String encryptPassword = encryptor.encrypt(password);
        String decryptPassword = encryptor.decrypt(encryptPassword);

        System.out.println("password = " + password);
        System.out.println("encryptPassword = " + encryptPassword);
        System.out.println("decryptPassword = " + decryptPassword);
    }
}
