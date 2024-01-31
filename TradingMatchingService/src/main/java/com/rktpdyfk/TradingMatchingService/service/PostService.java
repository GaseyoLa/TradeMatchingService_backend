package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.entity.User;
import com.rktpdyfk.TradingMatchingService.repository.PostRepository;
import com.rktpdyfk.TradingMatchingService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.rktpdyfk.TradingMatchingService.dto.PostDto.*;
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<Post> allPost(){
        List<Post> postList = postRepository.findAll();
        return postList;
    }

    public void createPost(Optional<String> username, PostRequestDto postRequestDto){
        User user = userRepository.findByUsername(username);
        Post post = postRequestDto.to_Entity();
        post.setUser(user);
        System.out.println("User Object:" + user);
        postRepository.save(post);
    }

    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
}
