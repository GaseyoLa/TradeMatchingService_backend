package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.jwt.JwtFilter;
import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
import com.rktpdyfk.TradingMatchingService.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;

@RestController
@RequestMapping("/rktpdyfk/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TokenProvider tokenProvider;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadPost(HttpServletRequest httpServletRequest, @RequestParam("postInfo") PostRequestDto postRequestDto){
        //토큰 가져옴
        String accessToken = tokenProvider.resolveToken(httpServletRequest);
        //토큰 유효성 검사
        tokenProvider.validateToken(accessToken);
        String userName = tokenProvider.getUsername(accessToken);
        postService.createPost(userName, postRequestDto);


        return ResponseEntity.ok(HttpStatus.OK);
    }

}
