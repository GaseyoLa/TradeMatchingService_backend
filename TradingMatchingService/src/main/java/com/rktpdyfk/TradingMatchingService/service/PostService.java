package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void createPost(PostRequestDto postRequestDto){
        Post post = postRequestDto.to_Entity();
        postRepository.save(post);
    }
}
