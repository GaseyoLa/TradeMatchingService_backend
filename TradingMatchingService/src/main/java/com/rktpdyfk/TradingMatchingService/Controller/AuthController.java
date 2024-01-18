package com.rktpdyfk.TradingMatchingService.Controller;

import com.rktpdyfk.TradingMatchingService.Dto.LoginDto;
import com.rktpdyfk.TradingMatchingService.Dto.TokenDto;
import com.rktpdyfk.TradingMatchingService.jwt.JwtFilter;
import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
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

    public AuthController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

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
        String jwt = tokenProvider.createToken(authentication);
        System.out.println("Generated JWT: " + jwt);
        //jwt 토큰을 헤더에 삽입
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        System.out.println("Headers: " + httpHeaders);
        //TokenDto를 사용해 Body에 리턴
        return new ResponseEntity<>(new TokenDto(jwt), httpHeaders, HttpStatus.OK);
    }
}
