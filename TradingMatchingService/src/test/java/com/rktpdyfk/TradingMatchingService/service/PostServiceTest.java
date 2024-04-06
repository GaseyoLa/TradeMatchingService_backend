package com.rktpdyfk.TradingMatchingService.service;

import com.rktpdyfk.TradingMatchingService.dto.PostDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void getPost() {
        PostDto.PostListResponseDto postListResponseDto = postService.getPost(1L);
        Assertions.assertThat(postListResponseDto.getItemId()).isEqualTo(1002005);
    }
}
