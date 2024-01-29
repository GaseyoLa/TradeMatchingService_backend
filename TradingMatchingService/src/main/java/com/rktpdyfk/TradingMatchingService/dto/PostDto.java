package com.rktpdyfk.TradingMatchingService.dto;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.entity.OptionPost;
import com.rktpdyfk.TradingMatchingService.entity.Post;

public class PostDto {
    public static class PostRequestDto {
        private Item item;
        private OptionPost optionPost;
        private int price;

        //DTO -> Entity
        public Post to_Entity() {
            return Post.builder()
                    .item(item)
                    .optionPost(optionPost)
                    .price(price)
                    .build();
        }
    }
}
