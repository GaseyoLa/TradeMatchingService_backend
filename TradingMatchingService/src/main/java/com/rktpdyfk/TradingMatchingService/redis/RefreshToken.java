package com.rktpdyfk.TradingMatchingService.redis;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
@RedisHash(value = "refresh_token") //Redis에 저장될 객체를 정의할떄 사용. @Entity와 유사한 개념이며, Redis에서 데이터를 Hash 형태로 저장한다.
public class RefreshToken {
    @Id
    private String userId;

    @Indexed //Redis에서 특정 필드를 기준으로 데이터를 빠르게 검색할 수 있도록 해준다. 이걸 사용하면 필드가 인덱싱되어 쿼리기반검색(findBy...)가 가능해진다.
    //StringRedisTemplate를 사용하면 @Indexed 없이도 특정 필드(token)로 검색이 가능하다.
    private String token;

    private String role;

    @TimeToLive
    private long ttl;

    public RefreshToken update(String token, long ttl){
        this.token = token;
        this.ttl = ttl;
        return this;
    }
}
