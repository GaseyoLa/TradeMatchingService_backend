package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.UserDto;
import com.rktpdyfk.TradingMatchingService.dto.UserDuplicateDto;
import com.rktpdyfk.TradingMatchingService.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    //아이디 중복 조회
    @PostMapping("/check_duplicate")
    public  ResponseEntity<Map<String,Boolean>> checkDuplicate(
            @Valid @RequestBody UserDuplicateDto userDuplicateDto) {
        return ResponseEntity.ok(userService.checkDuplicate(userDuplicateDto));
    }

    //UserDto를 파라미터로 받아서 UserService의 signup 메소드를 호출
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(
            @Valid @RequestBody UserDto userDto
    ) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')") //두가지 권한을 모두 허용
    public ResponseEntity<UserDto> getMyUserInfo(HttpServletRequest request) {
        return ResponseEntity.ok(userService.getMyUserWithAuthorities());
    }


    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')") //ADMIN권한만 호출가능
    public ResponseEntity<UserDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserWithAuthorities(username));
    }
}
