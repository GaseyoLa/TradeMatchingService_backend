package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
import com.rktpdyfk.TradingMatchingService.repository.PostRepository;
import com.rktpdyfk.TradingMatchingService.service.PostService;
import com.rktpdyfk.TradingMatchingService.util.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final TokenProvider tokenProvider;
    //private final OptionPostService optionPostService;

    //게시물 작성
    @PostMapping("/post/upload")
    @PreAuthorize("hasAnyRole('USER','ADMIN')") //두가지 권한을 모두 허용
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

    //모든 게시물 요청
    @GetMapping("/post/list")
    public ResponseEntity<List<PostListResponseDto>> getAllPosts(){
        List<PostListResponseDto> postListResponseDtoList = postService.getAllPosts();
        return ResponseEntity.ok(postListResponseDtoList);
    }

    //모든 게시물 페이징 요청
    @GetMapping("/post/list/page")
    public ResponseEntity<List<PostListResponseDto>> getPagingPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "20") int pageSize){
        return ResponseEntity.ok(postService.getAllPostsPaging(pageNumber, pageSize));
    }

    //하나의 게시물 요청
    @GetMapping("/post/{postId}") //url에 쓰는 변수명과 파라미터의 변수명은 일치해야한다.
    public ResponseEntity<PostListResponseDto> getPost(@PathVariable Long postId){
        PostListResponseDto postListResponseDto = postService.getPost(postId);
        return ResponseEntity.ok(postListResponseDto);
    }

    @GetMapping("/post/{postId}/delete")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }
}
