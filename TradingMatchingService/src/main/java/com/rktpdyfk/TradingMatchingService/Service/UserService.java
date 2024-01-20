package com.rktpdyfk.TradingMatchingService.Service;

import com.rktpdyfk.TradingMatchingService.Entity.Authority;
import com.rktpdyfk.TradingMatchingService.Entity.User;
import com.rktpdyfk.TradingMatchingService.Dto.UserDto;
import com.rktpdyfk.TradingMatchingService.Repository.UserRepository;
import com.rktpdyfk.TradingMatchingService.Util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        //DB에 유저가 존재하면 에러출력
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //권한 정보 생성
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        //권한정보도 넣고 유저를 생성
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .email(userDto.getEmail())
                .nickname(userDto.getNickname())
                .discordId(userDto.getDiscordId())
                .worldsId(userDto.getWorldsId())
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        //유저,권한정보를 저장
        return UserDto.from(userRepository.save(user));
    }

    //username을 기준으로 정보를 가져옴
    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(
                SecurityUtil.getCurrentUsername()
                        .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                        .orElseThrow(() -> new RuntimeException("Member not found"))
        );
    }
}
