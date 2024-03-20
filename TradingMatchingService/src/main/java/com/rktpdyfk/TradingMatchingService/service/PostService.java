package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import com.rktpdyfk.TradingMatchingService.dto.TextSearchDto;
import com.rktpdyfk.TradingMatchingService.entity.Item;
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

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
