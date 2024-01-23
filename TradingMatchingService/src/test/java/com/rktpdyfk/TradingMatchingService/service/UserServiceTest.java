package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.UserDto;
import com.rktpdyfk.TradingMatchingService.dto.UserDuplicateDto;
import com.rktpdyfk.TradingMatchingService.entity.Authority;
import com.rktpdyfk.TradingMatchingService.repository.UserRepository;
import com.rktpdyfk.TradingMatchingService.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired UserRepository userRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired UserService userService;

    @Test
    public void 암호_인코딩_테스트(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String rawPassword = "admin1234";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        assertNotNull(encodedPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }

    @Test
    public void signup_아이디_중복_테스트(){

        //given
        Authority authority = Authority.builder().authorityName("ROLE_USER").build();

        UserDto userDto_one = new UserDto("user_one","user1234","user_nick","user@email.com",null,null,null);
        UserDto userDto_two = new UserDto("user_one","user1234","user2_nick","user2@email.com",null,null,null);

        // when
        userService.signup(userDto_one);
        RuntimeException e = assertThrows(RuntimeException.class, () ->
            userService.signup(userDto_two));

        // then
        assertThat(e.getMessage()).isEqualTo("이미 가입되어 있는 유저입니다. 아이디 중복");
    }

    @Test
    public void 회원가입시_중복체크_테스트(){

        UserDuplicateDto user_real = new UserDuplicateDto("user","user","user@email.com");

        Map<String,Boolean> result = userService.checkDuplicate(user_real);

        // Assertions.assertThat(result).isEqualTo("");
        // Check that all values in the map are false
        Assertions.assertThat(result.values()).allMatch(value -> value);
    }
}