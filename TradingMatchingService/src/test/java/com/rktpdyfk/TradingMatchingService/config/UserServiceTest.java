package com.rktpdyfk.TradingMatchingService.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    @Test
    public void 암호_인코딩_테스트(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "admin1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        assertNotNull(encodedPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }

}
