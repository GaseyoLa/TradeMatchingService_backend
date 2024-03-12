package com.rktpdyfk.TradingMatchingService.controller;

import com.rktpdyfk.TradingMatchingService.jwt.TokenProvider;
import com.rktpdyfk.TradingMatchingService.service.PostService;
import com.rktpdyfk.TradingMatchingService.util.SecurityUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
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

    //모든 게시물 페이징 요청 미완성. 수정해야함
    @GetMapping("/post/pagelist")
    public ResponseEntity<Page<PostListResponseDto>> getPagingPosts(Pageable pageable){
        Page<PostListResponseDto> postPages = postService.paging(pageable);
        /**
         * blockLimit : page 개수 설정
         * 현재 사용자가 선택한 페이지 앞 뒤로 3페이지씩만 보여준다.
         * ex : 현재 사용자가 4페이지라면 2, 3, (4), 5, 6
         */
        int blockLimit = 3;
        int startPage = (((int) Math.ceil(((double) pageable.getPageNumber() / blockLimit))) - 1) * blockLimit + 1;
        int endPage = Math.min((startPage + blockLimit - 1), postPages.getTotalPages());

        //List<PostListResponseDto> postListResponseDtoList = postService.getAllPosts();
        return ResponseEntity.ok(postPages);
    }

}
