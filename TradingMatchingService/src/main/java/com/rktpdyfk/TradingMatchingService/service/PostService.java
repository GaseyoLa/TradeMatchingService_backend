package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.entity.User;
import com.rktpdyfk.TradingMatchingService.repository.PostRepository;
import com.rktpdyfk.TradingMatchingService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;
@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //게시물 작성하기
    public void createPost(Optional<String> username, PostRequestDto postRequestDto){
        User user = userRepository.findByUsername(username);
        Post post = postRequestDto.to_Entity();
        post.setUser(user);
        System.out.println("User Object:" + user);
        postRepository.save(post);
    }

    //모든 게시물 페이징해서 보여주기
    public Page<PostListResponseDto> paging(Pageable pageable) {
        int page = pageable.getPageNumber() - 1; // page 위치에 있는 값은 0부터 시작한다.
        int pageLimit = 20; // 한페이지에 보여줄 글 개수

        // 한 페이지당 20개식 글을 보여주고, 정렬 기준은 최신순이어야 하므로 date 기준으로 오름차순
        Page<Post> postsPages = postRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.ASC, "date")));

        Page<PostListResponseDto> postsResponseDtoList = postsPages.map(
                postPage -> new PostListResponseDto(postPage));

        return postsResponseDtoList;
    }

    //모든 게시물 가져오기
    public List<PostListResponseDto> getAllPosts(){
        List<Post> postList = postRepository.findAll();
        List<PostListResponseDto> postResponseDtoList = postList.stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
        return postResponseDtoList;
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
