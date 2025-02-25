package com.rktpdyfk.TradingMatchingService.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveRefreshToken(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String getRefreshToken(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void deleteRefreshToken(String key) {
        redisTemplate.delete("refresh:" + key);
    }
}
