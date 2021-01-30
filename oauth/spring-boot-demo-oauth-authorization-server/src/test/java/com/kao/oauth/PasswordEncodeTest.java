package com.kao.oauth;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void getPasswordWhenPassed() {
        System.out.println(passwordEncoder.encode("oauth2"));
        System.out.println(passwordEncoder.encode("123456"));
    }
}
