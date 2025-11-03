package com.rktpdyfk.TradingMatchingService.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    //refresh token 저장 (14일 만료)
    public void saveRefreshToken(String key, String refreshToken){
        redisTemplate.opsForValue().set("refresh save:" + key, refreshToken, 14, TimeUnit.DAYS);
    }
    //refresh token 조회
    public String getRefreshToken(String key){
        return (String) redisTemplate.opsForValue().get("refresh get:" + key);
    }
    //refresh token 삭제 (로그아웃 시)
    public void deleteRefreshToken(String key) {
        redisTemplate.delete("refresh:" + key);
    }
}
