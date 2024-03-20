package com.rktpdyfk.TradingMatchingService.dto;

import com.rktpdyfk.TradingMatchingService.entity.Item;
import com.rktpdyfk.TradingMatchingService.entity.Post;
import com.rktpdyfk.TradingMatchingService.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class PostDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostRequestDto {
        private Item item;
        private Long price;
        private Long incSTR;
        private Long incDEX;
        private Long incINT;
        private Long incLUK;
        private Long incPAD;//물리 공격력
        private Long incPDD;//물리 방어력
        private Long incMAD;//마법 공격력
        private Long incMDD;//마법 방어력
        private Long incEVA;//회피력
        private Long incACC;//명중률
        private Long tuc; //업그레이드 가능 횟수
        private Long incSpeed;//이동속도
        private Long incJump;//점프력
        private Long incMHP;//추가HP
        private Long incMMP;//추가MP

        //DTO -> Entity
        public Post to_Entity() {
            return Post.builder()
                    .item(item)
                    .price(price)
                    .incSTR(incSTR)
                    .incDEX(incDEX)
                    .incINT(incINT)
                    .incLUK(incLUK)
                    .incPAD(incPAD)
                    .incPDD(incPDD)
                    .incMAD(incMAD)
                    .incMDD(incMDD)
                    .incEVA(incEVA)
                    .incACC(incACC)
                    .tuc(tuc)
                    .incSpeed(incSpeed)
                    .incJump(incJump)
                    .incMHP(incMHP)
                    .incMMP(incMMP)
                    .build();
        }
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostListResponseDto {
        private Long userId;
        private Long itemId;
        private Long price;
        private Long incSTR;
        private Long incDEX;
        private Long incINT;
        private Long incLUK;
        private Long incPAD;//물리 공격력
        private Long incPDD;//물리 방어력
        private Long incMAD;//마법 공격력
        private Long incMDD;//마법 방어력
        private Long incEVA;//회피력
        private Long incACC;//명중률
        private Long tuc; //업그레이드 가능 횟수
        private Long incSpeed;//이동속도
        private Long incJump;//점프력
        private Long incMHP;//추가HP
        private Long incMMP;//추가MP


        public PostListResponseDto(Post post){
            this.userId = post.getUser().getId();
            this.itemId = post.getItem().getId();
            this.price = post.getPrice();
            this.incSTR = post.getIncSTR();
            this.incDEX = post.getIncDEX();
            this.incINT = post.getIncINT();
            this.incLUK = post.getIncLUK();
            this.incPAD = post.getIncPAD();
            this.incPDD = post.getIncPDD();
            this.incMAD = post.getIncMAD();
            this.incMDD = post.getIncMDD();
            this.incEVA = post.getIncEVA();
            this.incACC = post.getIncACC();
            this.tuc = post.getTuc();
            this.incSpeed = post.getIncSpeed();
            this.incJump = post.getIncJump();
            this.incMHP = post.getIncMHP();
            this.incMMP = post.getIncMMP();
        }
    }
}
