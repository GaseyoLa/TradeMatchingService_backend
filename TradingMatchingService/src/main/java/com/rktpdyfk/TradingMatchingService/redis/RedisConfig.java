package com.rktpdyfk.TradingMatchingService.redis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/* Springboot 2.0부터는 RedisTemplate와 StringRedisTemplate를 자동으로 Bean을 생성해주기 때문에,
 * 따로 Bean 등록을 안해줘도 직접 주입해서 사용 가능. 하지만 자동 등록되는 RedisTemplate은 기본적으로 JDK 직렬화(Serializer)를
 * 사용하는데, 이는 Redis에 바이너리 데이터(\xac\xed\x00...)로 저장되므로, 사람이 읽기 어렵고 호환성이 떨어진다.
 * 따라서 StringRedisSerializer를 설정해주어서 이를 해결한다.
 * 직렬화 설정을 하기 위해서는 RedisConfig가 필요하다.
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // 일반적인 Key:Value의 경우에 사용되는 문자열(String) 직렬화
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        // Hash를 사용할 경우에 사용되는 문자열(String) 직렬화
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}
