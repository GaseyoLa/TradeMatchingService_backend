package com.rktpdyfk.TradingMatchingService.dto;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.entity.Post;

public class PostDto {
    public static class PostRequestDto {
        private Item item;
        private Long price;

        //DTO -> Entity
        public Post to_Entity() {
            return Post.builder()
                    .item(item)
                    .price(price)
                    .build();
        }
    }
}
