package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.ItemDto;
import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired PostService postService;
    @Test
    void getPost_테스트() {
        PostDto.PostListResponseDto postResponseDto = postService.getPost(3L);
        Assertions.assertThat(postResponseDto.getPostId()).isEqualTo(3L);
    }
}