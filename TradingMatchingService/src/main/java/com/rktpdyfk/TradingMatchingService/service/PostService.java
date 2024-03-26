package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.entity.User;
import com.rktpdyfk.TradingMatchingService.repository.PostRepository;
import com.rktpdyfk.TradingMatchingService.repository.UserRepository;
import com.rktpdyfk.TradingMatchingService.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void createPost(Optional<String> username, PostRequestDto postRequestDto){
        User user = userRepository.findByUsername(username);
        Post post = postRequestDto.to_Entity();
        post.setUser(user);
        System.out.println("User Object:" + user);
        postRepository.save(post);
    }

    //모든 게시물 가져오기
    public List<PostListResponseDto> getAllPosts(){
        List<Post> postList = postRepository.findAll();
        List<PostListResponseDto> postResponseDtoList = postList.stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
        return postResponseDtoList;
    }

    //모든 게시물 페이징해서 가져오기
    public List<PostListResponseDto> getAllPostsPaging(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber, pageSize); //받아온 페이지 개수로 Pageable 객체 만듦.
        Page<Post> posts = postRepository.findAll(pageable); //findAll()에 pageable을 넣으면 그 수만큼 가져옴.
        List<PostListResponseDto> result = posts.stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
        return result;
    }

    //하나의 게시물 가져오기
    public PostListResponseDto getPost(Long postId){
        Optional<Post> post = postRepository.findById(postId);
        PostListResponseDto postListResponseDto = new PostListResponseDto(post.get());
        return postListResponseDto;
    }

    //현재 로그인한 유저 가져오기
    public User isUserCurrent() {
        User user =  userRepository.findByUsername(SecurityUtil.getCurrentUsername());
        if (user != null){
            return user;
        } else {
            throw new RuntimeException("로그인 유저 정보가 없습니다.");
        }
                //orElseThrow()는 해당 Optional 객체가 비어있을 때 예외를 발생하는 메소드.
                //.orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }
    //유저가 게시물의 권한을 가지고 있는지 확인
    public Post authorizationPostWriter(Long postId) {
        User user = isUserCurrent();
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("게시물이 없습니다."));
        if (!post.getUser().equals(user)) {
            throw new RuntimeException("로그인한 유저와 작성한 유저가 다릅니다.");
        }
        return post;
    }
    //게시물 삭제
    @Transactional
    public void deletePost(Long postId){
        Post post = authorizationPostWriter(postId);
        postRepository.delete(post);
    }
}
