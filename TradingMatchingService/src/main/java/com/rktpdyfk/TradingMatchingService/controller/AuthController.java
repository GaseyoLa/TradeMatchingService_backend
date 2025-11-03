package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.LoginDto;
import com.rktpdyfk.TradingMatchingService.dto.TokenDto;
import com.rktpdyfk.TradingMatchingService.jwt.JwtFilter;
import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
import com.rktpdyfk.TradingMatchingService.redis.RedisService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//로그인 API
@RestController
@RequestMapping("/api")
public class AuthController {
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final RedisService redisService;

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, RedisService redisService) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.redisService = redisService;
    }

    //로그인
    @PostMapping("/authenticate")
    public ResponseEntity<TokenDto> authorize(@Valid @RequestBody LoginDto loginDto) {

        //LoginDto 값을 파라미터로 받아 authToken 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        //토큰을 이용해 Auth객체를 생성하려고 할때 userDetailsService-loadUserByUsername이 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //그렇게 생성된 Auth객체로 아래 SCH생성
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //해당 인증정보를 기반으로 jwt token 생성
        String accessToken = tokenProvider.createToken(authentication);
        String refreshToken = tokenProvider.createRefreshToken(authentication);

        System.out.println("Generated JWT accessToken: " + accessToken);
        System.out.println("Generated JWT refreshToken: " + refreshToken);

        //refresh Token을 Redis에 저장
        redisService.saveRefreshToken(loginDto.getUsername(), refreshToken);

        //jwt 토큰을 헤더에 삽입
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + accessToken);
        System.out.println("Headers: " + httpHeaders);

        //TokenDto를 사용해 Body에 리턴
        return new ResponseEntity<>(new TokenDto(accessToken, refreshToken), httpHeaders, HttpStatus.OK);
    }

    //Access Token 재발급
    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody LoginDto loginDto, @RequestBody String refreshToken){
        //Redis에 저장된 사용자의 Refresh Token을 가져온다.
        String savedToken = redisService.getRefreshToken(loginDto.getUsername());


        if (savedToken == null || !savedToken.equals(refreshToken)){
            return ResponseEntity.status(401).body("Invalid Refresh Token");
        }
        //LoginDto 값을 파라미터로 받아 authToken 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        //토큰을 이용해 Auth객체를 생성하려고 할때 userDetailsService-loadUserByUsername이 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        //그렇게 생성된 Auth객체로 아래 SCH생성
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //해당 인증정보를 기반으로 jwt token 생성
        String newAccessToken = tokenProvider.createToken(authentication);

        return ResponseEntity.ok(new TokenDto(newAccessToken, refreshToken));
        //TODO Refresh 토큰도 재발급 해줘야 할텐데.. Redis에 저장된 Refresh 토큰 제거하고 재발급해서 다시 저장?
    }
}
