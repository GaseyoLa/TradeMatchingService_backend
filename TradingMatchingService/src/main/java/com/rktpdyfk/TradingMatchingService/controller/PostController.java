package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
import com.rktpdyfk.TradingMatchingService.service.PostService;
import com.rktpdyfk.TradingMatchingService.util.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;

@RestController
@RequestMapping("/user/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TokenProvider tokenProvider;
    //private final OptionPostService optionPostService;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadPost(HttpServletRequest httpServletRequest, @RequestBody PostRequestDto postRequestDto){
        //=============어차피 JWT를 거치면서 permit()해놓은 주소가 아니면 검증을 한다.=========
        //토큰 가져옴
        //String accessToken = tokenProvider.resolveToken(httpServletRequest);
        //토큰 유효성 검사
        //tokenProvider.validateToken(accessToken);
        //=============================================================================

        //Security Context에서 username 가져옴.
        Optional<String> userName = SecurityUtil.getCurrentUsername();

        postService.createPost(userName, postRequestDto);
        //optionPostService.createOptionPost(optionPost);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
