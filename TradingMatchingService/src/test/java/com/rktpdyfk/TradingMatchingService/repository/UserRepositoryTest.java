package com.rktpdyfk.TradingMatchingService.repository;

import com.rktpdyfk.TradingMatchingService.dto.UserDto;
import com.rktpdyfk.TradingMatchingService.service.UserService;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest
{
    @Autowired UserRepository userRepository;
    @Autowired UserService userService;

    @AfterEach
    public void clean(){
        userRepository.deleteAll();
    }
    @Test
    public void 아이디_중복_조회_테스트_있을때(){

        UserDto userDto_one = new UserDto("user_one","user1234","user_nick","user@email.com",null,null,null);

        // when
        userService.signup(userDto_one);
        //userService.signup(userDto_two);
        Boolean result = userRepository.existsByUsername("user_one");

        Assertions.assertThat(result).isEqualTo(true);
    }

    @Test
    public void 아이디_중복_조회_테스트_없을때(){

        UserDto userDto_one = new UserDto("user_one","user1234","user_nick","user@email.com",null,null,null);

        // when
        userService.signup(userDto_one);
        //userService.signup(userDto_two);
        Boolean result = userRepository.existsByUsername("user_two");

        Assertions.assertThat(result).isEqualTo(false);
    }
}