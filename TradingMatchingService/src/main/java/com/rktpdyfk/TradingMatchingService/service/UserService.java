package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.UserDto;
import com.rktpdyfk.TradingMatchingService.dto.UserDuplicateDto;
import com.rktpdyfk.TradingMatchingService.entity.Authority;
import com.rktpdyfk.TradingMatchingService.entity.User;
import com.rktpdyfk.TradingMatchingService.repository.UserRepository;
import com.rktpdyfk.TradingMatchingService.util.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입시 중복 검사 - 중복이면 true, 아니면 false를 입력해서 반환한다.
    @Transactional
    public Map<String, Boolean> checkDuplicate(UserDuplicateDto userDto) {
        Map<String, Boolean> duplicateStatus = new HashMap<>();

        // Check duplicate username
        duplicateStatus.put("username", userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).isPresent());

        // Check duplicate email
        duplicateStatus.put("email", userRepository.existsByEmail(userDto.getEmail()));

        // Check duplicate nickname
        duplicateStatus.put("nickname", userRepository.existsByNickname(userDto.getNickname()));

        // Log the duplicate status
        logger.info("Duplicate check status: {}", duplicateStatus);

        return duplicateStatus;
    }
    @Transactional
    public UserDto signup(UserDto userDto) {

        //DB에 유저가 존재하면 에러출력
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다. 아이디 중복");
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
